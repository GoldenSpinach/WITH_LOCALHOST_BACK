package com.with.withlocalhost.chat.model.service;

import com.with.withlocalhost.chat.manager.ChatManager;
import com.with.withlocalhost.chat.model.ChatMessageDto;
import com.with.withlocalhost.chat.model.ChatRoomDto;
import com.with.withlocalhost.chat.model.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final ChatManager chatManager;

    public ChatServiceImpl(ChatRepository chatRepository, ChatManager chatManager) {
        this.chatRepository = chatRepository;
        this.chatManager = chatManager;
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
        return result > 0 ? "success" : "fail";
    }

    // 메시지 저장 후 전송
    @Override
    public void sendMessage(ChatMessageDto chatMessageDto) throws SQLException {
        // DB에 메시지 저장
        int result = chatRepository.insertChatMessage(chatMessageDto);

        if (result > 0) {
            // ChatManager를 통해 메시지 전송 처리
            chatManager.sendMessage(chatMessageDto);
        }
    }

	@Override
	public String createChatRoom(ChatRoomDto chatRoomDto) throws SQLException {
		int checkChatRoom = chatRepository.checkChatRoom(chatRoomDto);
		
		if(checkChatRoom==0) {
			int result = chatRepository.createChatRoom(chatRoomDto);
			if(result>0) {
				if(result>0) {
					return "success";
				}
				return "fail";
			}
		}
		return "fail";
	}

}
