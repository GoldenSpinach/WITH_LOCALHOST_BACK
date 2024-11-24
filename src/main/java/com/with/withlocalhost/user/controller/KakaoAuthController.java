package com.with.withlocalhost.user.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.with.withlocalhost.user.model.service.KakaoAuthService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class KakaoAuthController {

    private final KakaoAuthService kakaoAuthService;

    public KakaoAuthController(KakaoAuthService kakaoAuthService) {
        this.kakaoAuthService = kakaoAuthService;
    }

    /**
     * 1. 카카오 로그인 URL 생성
     * - 클라이언트에서 로그인 버튼 클릭 시 리디렉션할 URL 생성
     */
    @GetMapping("/kakao/login-url")
    public ResponseEntity<String> generateKakaoLoginUrl() {
        return ResponseEntity.ok(kakaoAuthService.generateKakaoLoginUrl());
    }

    /**
     * 2. 카카오 인증 콜백 처리 (Authorization Code → 토큰)
     * - 카카오에서 Authorization Code를 받아 Access 토큰과 Refresh 토큰을 발급받음
     */
    @GetMapping("/kakao/callback")
    public ResponseEntity<Map<String, String>> handleKakaoCallback(@RequestParam("code") String authorizationCode) {
        return ResponseEntity.ok(kakaoAuthService.handleKakaoCallback(authorizationCode));
    }

    /**
     * 3. 카카오 사용자 정보 조회
     * - 발급받은 Access 토큰을 이용하여 카카오 사용자 정보를 가져옴
     */
    @GetMapping("/kakao/user-info")
    public ResponseEntity<Map<String, Object>> getUserInfo(@RequestHeader("Authorization") String accessToken) {
        return ResponseEntity.ok(kakaoAuthService.getUserInfo(accessToken));
    }

    /**
     * 4. Access 토큰 갱신
     * - Refresh 토큰을 사용하여 새로운 Access 토큰을 발급받음
     */
    @PostMapping("/kakao/refresh-token")
    public ResponseEntity<String> refreshAccessToken(@RequestParam("refresh_token") String refreshToken) {
        return ResponseEntity.ok(kakaoAuthService.refreshAccessToken(refreshToken));
    }

    /**
     * 5. 카카오 사용자 로그아웃
     * - Access 토큰을 사용하여 카카오 세션을 종료
     */
    @PostMapping("/kakao/logout")
    public ResponseEntity<Void> logoutUser(@RequestHeader("Authorization") String accessToken) {
        kakaoAuthService.logoutUser(accessToken);
        return ResponseEntity.ok().build();
    }

    /**
     * 6. Refresh 토큰 무효화 (카카오 계정 연결 해제)
     * - 사용자의 카카오 계정 연결을 해제
     */
    @PostMapping("/kakao/unlink")
    public ResponseEntity<Void> unlinkUser(@RequestHeader("Authorization") String accessToken) {
        kakaoAuthService.unlinkUser(accessToken);
        return ResponseEntity.ok().build();
    }
}
