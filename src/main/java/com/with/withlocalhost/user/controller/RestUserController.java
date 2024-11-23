package com.with.withlocalhost.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8000")
public class RestUserController {

	 private final String CLIENT_ID = "9247db9521fcc29d87f5a88abe98639f"; // 카카오 REST API 키
	    private final String CLIENT_SECRET = ""; // 선택적, 필요 없으면 빈 문자열
	    private final String REDIRECT_URI = "http://localhost:8000/kakaotest";
	
	
	
	    @PostMapping("/kakao")
	    public ResponseEntity<?> kaoLogin(@RequestBody Map<String , String >body){
	        String code = body.get("code");
	        System.out.println("도착했음");
	        System.out.println("code : " + code);
	        try {
	            // 1. 액세스 토큰 요청
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

	            ResponseEntity<Map> tokenResponse = restTemplate.exchange(
	                    tokenUrl,
	                    HttpMethod.POST,
	                    tokenRequest,
	                    Map.class
	            );

	            String accessToken = (String) tokenResponse.getBody().get("access_token");

	            // 2. 사용자 정보 요청
	            String userInfoUrl = "https://kapi.kakao.com/v2/user/me";

	            HttpHeaders userHeaders = new HttpHeaders();
	            userHeaders.add("Authorization", "Bearer " + accessToken);

	            HttpEntity<Void> userRequest = new HttpEntity<>(userHeaders);

	            ResponseEntity<Map> userResponse = restTemplate.exchange(
	                    userInfoUrl,
	                    HttpMethod.GET,
	                    userRequest,
	                    Map.class
	            );

	            // 사용자 정보 추출
	            Map userInfo = userResponse.getBody();

	            // 액세스 토큰과 사용자 정보 함께 반환
	            Map<String, Object> response = new HashMap<>();
	            response.put("access_token", accessToken);
	            response.put("user_info", userInfo);

	            return ResponseEntity.ok(response);

	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("카카오 로그인 실패: " + e.getMessage());
	        }
	    }
	
	
	
}
