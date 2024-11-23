package com.with.withlocalhost.chat.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.with.withlocalhost.chat.model.ChatMessageDto;
import com.with.withlocalhost.chat.model.ChatRoomDto;
import com.with.withlocalhost.chat.model.repository.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService {

	private final ChatRepository chatRepository;
	private final SimpMessagingTemplate template;

	// socket이 연결되어 있는 사용자 session 저장 변수
	private Map<String, WebSocketSession> socketInfo = new HashMap();

	public ChatServiceImpl(SimpMessagingTemplate template, ChatRepository chatRepository) {
		this.template = template;
		this.chatRepository = chatRepository;
	}


	@Override
	public List<ChatRoomDto> getChatRoomList(String userId) throws SQLException {
		return chatRepository.getChatRoomList(userId);
	}

	@Override
	public List<ChatMessageDto> getChatList(int chatRoomId) throws SQLException {
		return chatRepository.getChatList(chatRoomId);
	}

	@Override
	public String deleteChatRoom(int chatRoomId) throws SQLException {
		int result = chatRepository.deleteChatRoom(chatRoomId);
		if(result>0) {
			return "success";
		}
		return "fail";
	}

	
	
	
	/*
	 * =---------------------------------------
	 * TODO : STOMP 관련 함수들
	 */
	
	
	// 메세지 전송
	public void sendMessage(ChatMessageDto chatMessageDto) throws SQLException {

		// db에 저장한다.
		int result = chatRepository.insertChatMessage(chatMessageDto);
		if (result > 0) {
			int chatRoom = chatMessageDto.getChatRoomId();
			String receiver = chatMessageDto.getReceiver();
			WebSocketSession receiverSession = socketInfo.get(receiver);

			// socket 연결이 되어 있는 경우 message를 전송한다.
			if (receiverSession != null && receiverSession.isOpen()) {

				template.convertAndSend("/sub/chat/room/" + chatRoom, chatMessageDto);
			} else {
				// fcm 으로 전송한다.
			}

		}
	}

}
