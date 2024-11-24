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

import com.with.withlocalhost.user.model.UserFcmDto;
import com.with.withlocalhost.user.model.service.SocialService;
import com.with.withlocalhost.user.model.service.UserService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8000")
public class RestUserController {

	private final UserService userService;
	private final SocialService socialService;
	
	
	public RestUserController( UserService userService , SocialService socialService) {
		this.userService = userService;
		this.socialService = socialService;
	}
	
	
	
	 private final String CLIENT_ID = "9247db9521fcc29d87f5a88abe98639f"; // 카카오 REST API 키
	    private final String CLIENT_SECRET = ""; // 선택적, 필요 없으면 빈 문자열
	    private final String REDIRECT_URI = "http://localhost:8000/kakaotest";
	
	
	    // 이름 , 경로 수정 필요
	    
	    
	
	    @PostMapping("/kakao")
	    public ResponseEntity<?> kakaoLogin(@RequestBody Map<String, String> body) {
	        String code = body.get("code");
	        try {
	            // 서비스 계층에서 처리
	            Map<String, Object> response = socialService.kakaoLogin(code);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("카카오 로그인 실패: " + e.getMessage());
	        }
	    }
	
	    @PostMapping("/fcmtoken")
	    public ResponseEntity<?> addFcmToken(@RequestBody UserFcmDto userFcmDto){
	    	
	    	return ResponseEntity.ok("te");
	    }
	
}
