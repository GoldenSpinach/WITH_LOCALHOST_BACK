package com.with.withlocalhost.user.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.with.withlocalhost.common.annotation.AccessTokenAop;
import com.with.withlocalhost.user.model.UserDto;
import com.with.withlocalhost.user.model.UserFcmDto;
import com.with.withlocalhost.user.model.service.FcmService;
import com.with.withlocalhost.user.model.service.SocialService;
import com.with.withlocalhost.user.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173") // 프론트엔드 URL 지정
public class RestUserController {

	private final UserService userService;
	private final SocialService socialService;

	public RestUserController(UserService userService, SocialService socialService) {
		this.userService = userService;
		this.socialService = socialService;
	}

	@Operation(summary = "카카오 로그인")
	@PostMapping("/kakao")
	public ResponseEntity<?> Login(@RequestBody Map<String, String> body) throws SQLException {
		String authorizationCode = body.get("code");
		// userLogin 호출하여 처리
		Map<String, Object> response = userService.userLogin(authorizationCode);

		// 성공 시 응답 반환
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "fcm 토큰 저장")
	@PostMapping("/fcmtoken")
	public ResponseEntity<?> addFcmToken(@RequestBody UserFcmDto userFcmDto) throws SQLException {
		// 메세지 전송 관련 메소드 호출
		return ResponseEntity.ok(userService.addFcmToken(userFcmDto));
	}

	@Operation(summary = "회원가입 정보 요청", description = "minji123 으로 테스트 해보세용")
	@PostMapping("/join")
	@AccessTokenAop
	public ResponseEntity<?> userJoin(HttpServletRequest request ,@RequestBody UserDto userDto)throws SQLException {
		String accessToken = (String) request.getAttribute("accessToken");
		System.out.println("userDto : " + userDto);
		return ResponseEntity.ok(userService.userJoin(accessToken , userDto));
	}

	// @RequestHeader("Authorization") String accessToken
	@Operation(summary = "회원가입 정보 요청", description = "")
	@GetMapping("/info")
	public ResponseEntity<?> getUserInfo(HttpServletRequest request) throws SQLException {
		String accessToken = (String) request.getAttribute("accessToken"); // 재사용
		return ResponseEntity.ok(userService.getUserInfo(accessToken));
	}

	@Operation(summary = "로그아웃", description = "")
	@PostMapping("/logout")
	public ResponseEntity<?> logOut(HttpServletRequest request) throws SQLException {
		String accessToken = (String) request.getAttribute("accessToken"); // 재사용
		return ResponseEntity.ok(userService.getUserInfo(accessToken));
	}

}
