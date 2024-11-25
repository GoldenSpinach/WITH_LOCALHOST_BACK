package com.with.withlocalhost.user.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.with.withlocalhost.user.model.UserDto;
import com.with.withlocalhost.user.model.UserFcmDto;
import com.with.withlocalhost.user.model.service.FcmService;
import com.with.withlocalhost.user.model.service.SocialService;
import com.with.withlocalhost.user.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

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
	    
	    
//	    @Operation(summary = "카카오 로그인")
//	    @PostMapping("/kakao")
//	    public ResponseEntity<?> userLogin(@RequestBody Map<String, String> body)throws SQLException {
//	        String code = body.get("code");
//	        System.out.println("Code : " + code);
//	        try {
//	            // 서비스 계층에서 처리
//	            Map<String, Object> response = socialService.kakaoLogin(code);
//	            return ResponseEntity.ok(response);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return ResponseEntity.status(500).body("카카오 로그인 실패: " + e.getMessage());
//	        }
//	    }
	    
	    
	    @Operation(summary = "카카오 로그인")
	    @PostMapping("/kakao")
	    public ResponseEntity<?> Login(@RequestBody Map<String, String> body) throws SQLException {
	        String authorizationCode = body.get("code");
	        System.out.println("Authorization Code: " + authorizationCode);
	        // userLogin 호출하여 처리
	        Map<String, Object> response = userService.userLogin(authorizationCode);

	        // 성공 시 응답 반환
	        return ResponseEntity.ok(response);
	    }

	    
	    
	    @Operation(summary = "fcm 토큰 저장")
	    @PostMapping("/fcmtoken")
	    public ResponseEntity<?> addFcmToken(@RequestBody UserFcmDto userFcmDto) throws SQLException{
	    	//메세지 전송 관련 메소드 호출
	    	
	    	return ResponseEntity.ok(userService.addFcmToken(userFcmDto));
	    }
	
	    
	    @Operation(summary = "회원가입 정보 요청" , description = "minji123 으로 테스트 해보세용")
	    @PostMapping("/join")
	    public ResponseEntity<?> userJoin(@RequestHeader("Authorization") String accessToken ,@RequestBody UserDto userDto) throws SQLException{
	    	System.out.println("header access token : " + accessToken);
	    	System.out.println(userDto);
	    	
	    	return ResponseEntity.ok(userService.userJoin(userDto));
	    }
	    
	    
	    
}
