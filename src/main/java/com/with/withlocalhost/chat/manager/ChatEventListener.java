package com.with.withlocalhost.chat.manager;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatEventListener {

	// 사용자 ID를 키로 WebSocket 세션 상태 관리
	private static final Map<String, String> sessionMap = new ConcurrentHashMap<>();

	public static boolean isUserConnected(String userId) {
		System.out.println("user Id : " + userId);
		return sessionMap.containsKey(userId);
	}

	@EventListener
	public void handleSessionConnected(SessionConnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String userId = accessor.getFirstNativeHeader("userId");
		System.out.println("connected : " + userId);
		if (userId != null) {
			String sessionId = accessor.getSessionId();
			sessionMap.put(userId, sessionId); // 사용자 ID와 세션 ID를 저장
			System.out.println("STOMP 연결 성공: User ID = " + userId + ", Session ID = " + sessionId);
		}
	}

	@EventListener
	public void handleSessionDisconnected(SessionDisconnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String sessionId = accessor.getSessionId();

		// sessionMap에서 sessionId에 해당하는 userId 찾기
		String userId = sessionMap.entrySet().stream().filter(entry -> entry.getValue().equals(sessionId))
				.map(Map.Entry::getKey).findFirst().orElse("Unknown User"); // userId를 찾지 못했을 경우 기본값

		// sessionMap에서 해당 사용자 제거
		sessionMap.entrySet().removeIf(entry -> entry.getValue().equals(sessionId));

		System.out.println("STOMP 연결 종료: User ID = " + userId + ", Session ID = " + sessionId);
	}

}
