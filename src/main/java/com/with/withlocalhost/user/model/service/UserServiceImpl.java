package com.with.withlocalhost.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.user.model.UserDto;
import com.with.withlocalhost.user.model.UserFcmDto;
import com.with.withlocalhost.user.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final KakaoAuthService kaoService;

	public UserServiceImpl(UserRepository userRepository, KakaoAuthService kaoService) {
		this.userRepository = userRepository;
		this.kaoService = kaoService;
	}

	@Override
	public String addFcmToken(UserFcmDto userFcmDto) throws SQLException {
		int result = userRepository.addFcmToken(userFcmDto);
		if (result > 0) {
			return "success";
		}
		return "fail";
	}

	/*
	 * 추가 회원가입
	 */
	@Override
	public String userJoin(UserDto userDto) throws SQLException {
		int result = userRepository.userJoin(userDto);
		if (result > 0) {
			return "success";
		}

		return "fail";
	}

	/*
	 * 로그인 및 회원가입
	 */
	@Override
	public Map<String, Object> userLogin(String authorizationCode) throws SQLException {
	    Map<String, Object> resultMap = new HashMap<>();

	    try {
	        // 1. access, refresh 토큰 발급받기
	        Map<String, String> tokens;
	        try {
	            tokens = kaoService.handleKakaoCallback(authorizationCode);
	            System.out.println("Tokens: " + tokens);
	        } catch (Exception e) {
	            // 인증 실패 처리
	            resultMap.put("status", "error");
	            resultMap.put("message", "Invalid authorization code or expired.");
	            return resultMap;
	        }

	        String accessToken = tokens.get("access_token");
	        String refreshToken = tokens.get("refresh_token");
	        System.out.println("Access Token: " + accessToken);
	        System.out.println("Refresh Token: " + refreshToken);

	        // 2. access 토큰으로 사용자 정보 받기
	        Map<String, Object> userInfo = kaoService.getUserInfo(accessToken);
	        System.out.println("User Info: " + userInfo);

	        // 사용자 정보 추출
	        String userId = String.valueOf(userInfo.get("id"));

	        // "kakao_account"에서 이메일 정보 추출
	        Map<String, Object> kakaoAccount = (Map<String, Object>) userInfo.get("kakao_account");
	        String email = null;
	        if (kakaoAccount != null && (Boolean) kakaoAccount.get("is_email_valid") && (Boolean) kakaoAccount.get("is_email_verified")) {
	            email = (String) kakaoAccount.get("email");
	        }

	        // "properties"에서 닉네임과 프로필 이미지 추출
	        Map<String, Object> properties = (Map<String, Object>) userInfo.get("properties");
	        String nickname = null;
	        String profileImage = null;
	        if (properties != null) {
	            nickname = (String) properties.get("nickname");
	            profileImage = (String) properties.get("profile_image");
	        }

	        // 결과 출력
	        System.out.println("User ID: " + userId);
	        System.out.println("Email: " + email);
	        System.out.println("Nickname: " + nickname);
	        System.out.println("Profile Image: " + profileImage);

	        // 3. id값으로 사용자 정보가 있는지 DB 검사
	        UserDto user = userRepository.findUserById(userId);
	        System.out.println("User from DB: " + user);

	        if (user != null) {
	            // 4. DB에 정보가 있으면
	            resultMap.put("isMember", true);
	            // 4-1. Refresh 토큰만 업데이트
	            userRepository.updateRefreshToken(userId, refreshToken);
	        } else {
	            // 5. DB에 정보가 없으면
	            resultMap.put("isMember", false);

	            // 5-1. 사용자 정보를 DB에 저장
	            UserDto newUser = new UserDto();
	            newUser.setUserId(userId);
	            newUser.setEmail(email);
	            newUser.setNickName(nickname);
	            newUser.setImgUrl(profileImage);
	            newUser.setRefreshToken(refreshToken);
	            userRepository.addUser(newUser);
	        }

	        // resultMap에 id와 profileImage 추가
	        resultMap.put("id", userId);
	        resultMap.put("profileImage", profileImage);
	        resultMap.put("nickName", nickname);
	        resultMap.put("accessToken" , accessToken);
	        resultMap.put("email", email);
	        return resultMap;

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new SQLException("User login failed: " + e.getMessage());
	    }
	}



}
