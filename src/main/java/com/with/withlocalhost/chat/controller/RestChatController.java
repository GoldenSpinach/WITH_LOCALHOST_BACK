package com.with.withlocalhost.chat.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.with.withlocalhost.chat.model.ChatMessageDto;
import com.with.withlocalhost.chat.model.ChatRoomDto;
import com.with.withlocalhost.chat.model.service.ChatService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("chat")
@CrossOrigin(origins = "http://localhost:5173")  // 프론트엔드 URL 지정
public class RestChatController {
	private final ChatService chatService;

	public RestChatController(ChatService chatService) {
		this.chatService = chatService;
	}

	@Operation(summary = "채팅방 조회", description = "채팅방 + 마지막 채팅도 줌")
	@GetMapping("chatroomList")
	public ResponseEntity<?> getChatRoomList(@RequestParam String userId) throws SQLException{
		List<ChatRoomDto> chatRoomList = chatService.getChatRoomList(userId); 
		return ResponseEntity.ok(chatRoomList);
	}
	@Operation(summary = "채팅 목록 조회", description = "채팅 목록 전체 다줌 최신순으로 정렬됨")
	@GetMapping("chatList")
	public ResponseEntity<?> getChatList(@RequestParam int chatRoomId) throws SQLException{
		List<ChatMessageDto> chatList = chatService.getChatList(chatRoomId);
		return ResponseEntity.ok(chatList);
	}
	
	@Operation(summary = "채팅방 삭제", description = "채팅방 삭제")
	@PostMapping("deleteChatRoom")
	public ResponseEntity<?> deleteChatRoom(@RequestParam int chatRoomId) throws SQLException{
		
		return ResponseEntity.ok(chatService.deleteChatRoom(chatRoomId));
	}
}
