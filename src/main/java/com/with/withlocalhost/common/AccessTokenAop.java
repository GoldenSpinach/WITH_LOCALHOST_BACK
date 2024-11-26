package com.with.withlocalhost.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.with.withlocalhost.user.model.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Aspect
@Component
public class AccessTokenAop {

	private final UserService userService;

	public AccessTokenAop(UserService userService) {
		this.userService = userService;
	}
	
	
	@Around("@annotation(com.with.withlocalhost.common.annotation.AccessTokenAop)")
	public Object reissueToken(ProceedingJoinPoint joinPoint) throws Throwable {
		// 원래 메서드 실행
		Object result = joinPoint.proceed();

		// 요청 객체 가져오기
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null) {
			throw new IllegalStateException("요청 정보가 존재하지 않습니다.");
		}
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();

		// Authorization 헤더 처리
		String authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new IllegalArgumentException("유효하지 않은 Authorization 헤더입니다.");
		}
		String accessToken = authorizationHeader.substring(7);

		// AccessToken 갱신
		String newAccessToken = userService.updateAccessToken(accessToken);
		System.out.println("AOP NEWACCESSTOKEN : " + newAccessToken);
		// 응답 헤더에 새 토큰 추가
		if (response != null) {
			response.setHeader("Authorization", "Bearer " + newAccessToken);
		} else {
			System.out.println("응답 객체가 존재하지 않습니다.");
		}

		return result;
	}
}
