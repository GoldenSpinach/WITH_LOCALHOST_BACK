package com.with.withlocalhost.chat.manager;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.with.withlocalhost.chat.model.ChatMessageDto;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatManager {

    // 사용자 ID를 키로 WebSocket 세션 상태 관리
    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();

    private final SimpMessagingTemplate template;

    public ChatManager(SimpMessagingTemplate template) {
        this.template = template;
    }

    // 메시지 전송 메서드
    public void sendMessage(ChatMessageDto chatMessageDto) {
        int chatRoomId = chatMessageDto.getChatRoomId();
        String receiver = chatMessageDto.getReceiver();
        
        System.out.println("receiver : " + receiver);
        // 사용자 연결 상태 확인
        if (ChatEventListener.isUserConnected(receiver)) {
            // WebSocket 메시지 전송
            System.out.println("User " + receiver + " is connected. Sending message via WebSocket.");
            template.convertAndSend("/sub/chat/room/" + chatRoomId, chatMessageDto);
        } else {
            // FCM 알림 전송
            System.out.println("User " + receiver + " is not connected. Sending FCM notification.");
            //sendFcmNotification(receiver, chatMessageDto);
        }
    }

    // FCM 알림 전송
    private void sendFcmNotification(String receiver, ChatMessageDto chatMessageDto) {

        // 실제 구현은 FCM SDK 또는 HTTP 요청을 통해 메시지 전송
    }
}
