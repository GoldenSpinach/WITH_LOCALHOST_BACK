package com.with.withlocalhost.chat.controller;

import java.sql.SQLException;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.with.withlocalhost.chat.model.ChatMessageDto;
import com.with.withlocalhost.chat.model.service.ChatService;




// Stomp Controller
@Controller
public class ChatController {
	private final ChatService chatService;

	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}

	//stop/chat/send
	
	
	@MessageMapping("/send")
	public void sendMessage(ChatMessageDto chatMessageDto) throws SQLException {
		System.out.println("send 도착 @@@ : " + chatMessageDto);
		chatService.sendMessage(chatMessageDto);
	}

}
