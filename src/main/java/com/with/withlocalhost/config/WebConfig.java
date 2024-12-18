package com.with.withlocalhost.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.with.withlocalhost.interceptor.AccessTokenInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final AccessTokenInterceptor accessTokenInterceptor;

	@Autowired
	public WebConfig(AccessTokenInterceptor accessTokenInterceptor) {
		this.accessTokenInterceptor = accessTokenInterceptor;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // 모든 경로에 대해
				.allowedOrigins("*") // 모든 도메인 허용
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
				.allowedHeaders("*") // 요청 헤더 허용
				.exposedHeaders("Authorization") // 응답 헤더에 "Authorization" 노출
				.allowCredentials(false); // 인증 정보 허용
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accessTokenInterceptor)
				.addPathPatterns("/user/**", "/chat/**", "/tour/create", "/tour/mytour", "/reservation/**",
						"/review/**") // /user 경로
				// 하위의 모든 경로 , "/chat/**", "/tour/mytour", "/reservation/**", "/review/**"
				.excludePathPatterns("/user/kakao"); // /user/login 경로는 제외
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /img/** 요청을 프로젝트의 static/img 디렉터리와 매핑
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:src/main/resources/static/img/");
    }


}
