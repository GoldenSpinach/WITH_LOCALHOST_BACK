//package com.with.withlocalhost.common;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.with.withlocalhost.user.model.service.UserService;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Aspect
//@Component
//public class AccessTokenAop {
//
//    private final UserService userService;
//
//    public AccessTokenAop(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Around("@annotation(AccessTokenAop)")
//    public Object reissueToken(ProceedingJoinPoint joinPoint) throws Throwable {
//    	System.out.println("aop 실행 완료");
//    	Object result = joinPoint.proceed();
//        HttpServletRequest request = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String accessToken = request.getHeader("Authorization").substring(7);
//        String newAccessToken = userService.updateAccessToken(accessToken);
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        response.setHeader("Authorization", "Bearer " + newAccessToken);
//
//        return result;
//    }
//}
//
//
