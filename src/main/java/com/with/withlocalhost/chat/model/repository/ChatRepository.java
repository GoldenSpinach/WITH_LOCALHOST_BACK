package com.with.withlocalhost.chat.model.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.with.withlocalhost.chat.model.ChatMessageDto;
import com.with.withlocalhost.chat.model.ChatRoomDto;

@Mapper
public interface ChatRepository {

	int insertChatMessage(ChatMessageDto chatMessageDto) throws SQLException;
	
	List<ChatRoomDto> getChatRoomList(String userId) throws SQLException;
	
	List<ChatMessageDto> getChatList(int chatRoomId) throws SQLException;
	
	int deleteChatRoom(int chatRoomId) throws SQLException;
	
	String getToken(String userId)  throws SQLException;
}
