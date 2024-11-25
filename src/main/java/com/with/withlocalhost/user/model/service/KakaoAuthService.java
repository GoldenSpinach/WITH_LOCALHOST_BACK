package com.with.withlocalhost.user.model.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoAuthService {

	private final String CLIENT_ID = "9247db9521fcc29d87f5a88abe98639f"; // 카카오 REST API 키
	private final String CLIENT_SECRET = ""; // 선택적, 필요 없으면 빈 문자열
	private final String REDIRECT_URI = "http://localhost:5173/kakao";

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 1. 카카오 로그인 URL 생성
     * - 카카오 인증 페이지로 리디렉션할 URL을 생성
     */
    public String generateKakaoLoginUrl() {
        return "https://kauth.kakao.com/oauth/authorize" +
                "?client_id=" + CLIENT_ID +
                "&redirect_uri=" + REDIRECT_URI +
                "&response_type=code";
    }

    /**
     * 2. 카카오 인증 콜백 처리 (Authorization Code → 토큰)
     * - Authorization Code를 사용해 Access 토큰과 Refresh 토큰을 발급받음
     */
    public Map<String, String> handleKakaoCallback(String authorizationCode) {
        String tokenUrl = "https://kauth.kakao.com/oauth/token";

        MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("grant_type", "authorization_code");
        tokenParams.add("client_id", CLIENT_ID);
        tokenParams.add("redirect_uri", REDIRECT_URI);
        tokenParams.add("code", authorizationCode);
        tokenParams.add("client_secret", CLIENT_SECRET);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(tokenParams, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);
        
        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", (String) response.getBody().get("access_token"));
        tokens.put("refresh_token", (String) response.getBody().get("refresh_token"));

        return tokens;
    }

    /**
     * 3. 카카오 사용자 정보 조회
     * - Access 토큰을 사용해 카카오 사용자 정보를 조회
     */
    public Map<String, Object> getUserInfo(String accessToken) {
        String userInfoUrl = "https://kapi.kakao.com/v2/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        HttpEntity<?> request = new HttpEntity<>(headers);
        Map<String, Object> result = new HashMap<>();

        try {
            // 사용자 정보 요청
            ResponseEntity<Map> response = restTemplate.exchange(userInfoUrl, HttpMethod.GET, request, Map.class);

            // 성공 시 사용자 정보 반환
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // 실패 시 에러 정보 반환
            result.put("error", e.getStatusCode().toString()); // HTTP 상태 코드
            result.put("error_description", e.getResponseBodyAsString()); // 에러 상세 정보
            return result;
        }
    }



    /**
     * 4. Access 토큰 갱신
     * - Refresh 토큰으로 새로운 Access 토큰을 발급
     */
    public String refreshAccessToken(String refreshToken) {
        String tokenUrl = "https://kauth.kakao.com/oauth/token";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("client_id", CLIENT_ID);
        params.add("refresh_token", refreshToken);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);

        return (String) response.getBody().get("access_token");
    }

    /**
     * 5. 카카오 사용자 로그아웃
     * - Access 토큰을 사용하여 카카오 세션을 종료
     */
    public void logoutUser(String accessToken) {
        String logoutUrl = "https://kapi.kakao.com/v1/user/logout";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity<?> request = new HttpEntity<>(headers);
        restTemplate.postForEntity(logoutUrl, request, Void.class);
    }

    /**
     * 6. Refresh 토큰 무효화 (카카오 계정 연결 해제)
     * - Access 토큰을 사용하여 사용자의 카카오 계정 연결 해제
     */
    public void unlinkUser(String accessToken) {
        String unlinkUrl = "https://kapi.kakao.com/v1/user/unlink";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity<?> request = new HttpEntity<>(headers);
        restTemplate.postForEntity(unlinkUrl, request, Void.class);
    }
}
