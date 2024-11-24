package com.with.withlocalhost.user.model.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import com.with.withlocalhost.user.model.mapper.UserRepository;

@Service
public class SocialService {

	private final UserRepository userRepository;

	public SocialService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private final String CLIENT_ID = "9247db9521fcc29d87f5a88abe98639f"; // 카카오 REST API 키
	private final String CLIENT_SECRET = ""; // 선택적, 필요 없으면 빈 문자열
	private final String REDIRECT_URI = "http://localhost:8000/kakaotest";

	public Map<String, Object> kakaoLogin(String code) throws Exception {
		// 1. 액세스 토큰 요청
		String accessToken = getAccessToken(code);

		// 2. 사용자 정보 요청
		Map<String, Object> userInfo = getUserInfo(accessToken);

		// 3. 응답 생성
		Map<String, Object> response = new HashMap<>();
		response.put("access_token", accessToken);
		response.put("user_info", userInfo);

		return response;
	}

	private String getAccessToken(String code) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String tokenUrl = "https://kauth.kakao.com/oauth/token";

		MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
		tokenParams.add("grant_type", "authorization_code");
		tokenParams.add("client_id", CLIENT_ID);
		tokenParams.add("redirect_uri", REDIRECT_URI);
		tokenParams.add("code", code);
		tokenParams.add("client_secret", CLIENT_SECRET);

		HttpHeaders tokenHeaders = new HttpHeaders();
		tokenHeaders.add("Content-Type", "application/x-www-form-urlencoded");

		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(tokenParams, tokenHeaders);

		ResponseEntity<Map> tokenResponse = restTemplate.exchange(tokenUrl, HttpMethod.POST, tokenRequest, Map.class);

		return (String) tokenResponse.getBody().get("access_token");
	}

	private Map<String, Object> getUserInfo(String accessToken) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String userInfoUrl = "https://kapi.kakao.com/v2/user/me";

		HttpHeaders userHeaders = new HttpHeaders();
		userHeaders.add("Authorization", "Bearer " + accessToken);

		HttpEntity<Void> userRequest = new HttpEntity<>(userHeaders);

		ResponseEntity<Map> userResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, userRequest, Map.class);

		return userResponse.getBody();
	}

}
