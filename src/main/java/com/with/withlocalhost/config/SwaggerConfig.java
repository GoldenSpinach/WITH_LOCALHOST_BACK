package com.with.withlocalhost.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
	
    @Bean
    public GroupedOpenApi lookupApi() {
        return GroupedOpenApi.builder()
                .group("lookup") // 그룹 이름 설정
                .pathsToMatch("/lookup/**") // 해당 경로만 Swagger 문서화
                .build();
    }
	
    
    @Bean
    public GroupedOpenApi tourApi() {
        return GroupedOpenApi.builder()
                .group("tour") // 두 번째 그룹 이름 설정
                .pathsToMatch("/tour/**") // 해당 경로만 Swagger 문서화
                .build();
    }
    
    @Bean
    public GroupedOpenApi reservationApi() {
        return GroupedOpenApi.builder()
                .group("reservation") // 두 번째 그룹 이름 설정
                .pathsToMatch("/reservation/**") // 해당 경로만 Swagger 문서화
                .build();
    }
    
    @Bean
    public GroupedOpenApi reviewApi() {
        return GroupedOpenApi.builder()
                .group("review") // 두 번째 그룹 이름 설정
                .pathsToMatch("/review/**") // 해당 경로만 Swagger 문서화
                .build();
    }
    
    @Bean
    public GroupedOpenApi chatApi() {
        return GroupedOpenApi.builder()
                .group("chat") // 두 번째 그룹 이름 설정
                .pathsToMatch("/chat/**") // 해당 경로만 Swagger 문서화
                .build();
    }
    
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("user") // 두 번째 그룹 이름 설정
                .pathsToMatch("/user/**") // 해당 경로만 Swagger 문서화
                .build();
    }
    
}
