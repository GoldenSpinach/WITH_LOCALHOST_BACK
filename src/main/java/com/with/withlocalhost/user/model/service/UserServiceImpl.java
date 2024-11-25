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
	public String userJoin(String accessToken , UserDto userDto) throws SQLException {
		Map<String , Object> userInfo = getUserInfo(accessToken);
		String id = (String) userInfo.get("userId");
		userDto.setUserId(id);
		System.out.println("service userDto : " + userDto);
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

	        // 3. id값으로 사용자 정보가 있는지 DB 검사
	        UserDto user = userRepository.findUserById(userId);

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



	
	
	/*
	 * 토큰으로 사용자 정보 가져오기
	 */
	@Override
	public Map<String, Object> getUserInfo(String accessToken) throws SQLException {
	    Map<String, Object> resultMap = new HashMap<>();

	    // 1. Access 토큰으로 사용자 정보 가져오기
	    Map<String, Object> kakaoUserInfo = kaoService.getUserInfo(accessToken);

	    // 사용자 정보에서 ID 가져오기
	    String userId = String.valueOf(kakaoUserInfo.get("id"));

	    // 2. "kakao_account"에서 이메일 정보 추출
	    Map<String, Object> kakaoAccount = (Map<String, Object>) kakaoUserInfo.get("kakao_account");
	    String email = null;
	    if (kakaoAccount != null && (Boolean) kakaoAccount.get("is_email_valid") && (Boolean) kakaoAccount.get("is_email_verified")) {
	        email = (String) kakaoAccount.get("email");
	    }

	    // 3. "properties"에서 닉네임과 프로필 이미지 추출
	    Map<String, Object> properties = (Map<String, Object>) kakaoUserInfo.get("properties");
	    String nickname = null;
	    String profileImage = null;
	    if (properties != null) {
	        nickname = (String) properties.get("nickname");
	        profileImage = (String) properties.get("profile_image");
	    }

	    // 4. 사용자 ID로 DB에서 사용자 정보 조회
	    UserDto user = userRepository.findUserById(userId);
	    
	    // 5. DB에서 가져온 Refresh 토큰으로 Access 토큰 갱신
	    String refreshToken = user.getRefreshToken();
	    String newAccessToken = kaoService.refreshAccessToken(refreshToken);

	    // 6. 결과 데이터 생성
	    resultMap.put("accessToken", newAccessToken);
	    resultMap.put("userId", userId);
	    resultMap.put("email", email);
	    resultMap.put("nickname", nickname);
	    resultMap.put("profileImage", profileImage);
//	    resultMap.put("userInfo", user);
	    resultMap.put("phoneNumber", user.getPhoneNumber());
	    resultMap.put("gender", user.getGender());
	    resultMap.put("birth" , user.getBirth());
	    
	    return resultMap;
	}


	/*
	 * access 토큰 업데이트
	 */
	public String updateAccessToken(String accessToken) throws SQLException {
        try {
            // 1. Access 토큰으로 사용자 정보 가져오기
            Map<String, Object> userInfo = kaoService.getUserInfo(accessToken);

            // 사용자 정보를 기반으로 사용자 ID 가져오기
            if (userInfo == null || userInfo.containsKey("error")) {
                throw new IllegalArgumentException("유효하지 않은 Access 토큰입니다.");
            }
            String userId = (String) userInfo.get("id");

            // 2. 사용자 ID로 Refresh 토큰 가져오기
            String refreshToken = userRepository.findRefreshTokenByUserId(userId);
            if (refreshToken == null) {
                throw new IllegalStateException("Refresh 토큰이 존재하지 않습니다.");
            }

            // 3. Refresh 토큰으로 새로운 Access 토큰 발급받기
            String newAccessToken = kaoService.refreshAccessToken(refreshToken);

            // 새로운 Access 토큰 반환
            return newAccessToken;
        } catch (Exception e) {
            // 에러 처리 로직
            System.err.println("Access 토큰 갱신 중 에러 발생: " + e.getMessage());
            throw new SQLException("Access 토큰 갱신 중 문제가 발생했습니다.", e);
        }
    }

	/*
	 * 사용자 로그아웃 ( kao Session 삭제 )
	 */
	@Override
	public String logOut(String accessToken) throws SQLException {
	    try {
	        // 1. 카카오 로그아웃 처리
	    	kaoService.logoutUser(accessToken);
	        // 2. 성공 메시지 반환
	        return "success";
	    } catch (Exception e) {
	        // 3. 에러 처리
	        throw new SQLException("An error occurred while logging out: " + e.getMessage(), e);
	    }
	}

	
}
