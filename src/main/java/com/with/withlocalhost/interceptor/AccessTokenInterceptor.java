package com.with.withlocalhost.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.with.withlocalhost.user.model.service.KakaoAuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class AccessTokenInterceptor implements HandlerInterceptor {

    private final KakaoAuthService kakaoAuthService;

    public AccessTokenInterceptor(KakaoAuthService kakaoAuthService) {
        this.kakaoAuthService = kakaoAuthService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. OPTIONS 요청 처리
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            response.setStatus(HttpServletResponse.SC_OK);
            return false; // OPTIONS 요청은 여기서 종료
        }

        // 2. Authorization 헤더 검증 
        String authorizationHeader = request.getHeader("Authorization");
    
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authorization header is missing or invalid");
            return false;
        }

        // 3. Access Token 검증
        String accessToken = authorizationHeader.substring(7);
        System.out.println("INTERCEPTOR ACCESSTOKEN : " + accessToken);
        Map<String, Object> userInfo = kakaoAuthService.getUserInfo(accessToken);
        if (userInfo == null || userInfo.get("id") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid Access Token");
            return false;
        }
        
     // "properties"에서 닉네임과 프로필 이미지 추출
        Map<String, Object> properties = (Map<String, Object>) userInfo.get("properties");
        String nickname = null;
        String profileImage = null;
        if (properties != null) {
            nickname = (String) properties.get("nickname");
            profileImage = (String) properties.get("profile_image");
        }
        
        // 4. Access Token을 요청 속성에 저장
        String userId = String.valueOf(userInfo.get("id"));
        request.setAttribute("userId", userId);
        request.setAttribute("nickname", nickname);
        request.setAttribute("accessToken", accessToken);
        return true; // 다음 핸들러로 요청 전달
    }
}
