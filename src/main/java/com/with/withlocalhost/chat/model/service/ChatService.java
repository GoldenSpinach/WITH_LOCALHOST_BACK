package com.with.withlocalhost.chat.model.service;

import java.sql.SQLException;
import java.util.List;

import com.with.withlocalhost.chat.model.ChatMessageDto;
import com.with.withlocalhost.chat.model.ChatRoomDto;

public interface ChatService {

	void sendMessage(ChatMessageDto chatMessageDto) throws SQLException;
	
	
	//채팅방 목록 가져오기
	List<ChatRoomDto> getChatRoomList(String userId) throws SQLException;
	
	//채팅 목록 가져오기
	List<ChatMessageDto> getChatList(int chatRoomId) throws SQLException;
	
	//채팅 나가기
	String deleteChatRoom(int chatRoomId) throws SQLException;
	

}
