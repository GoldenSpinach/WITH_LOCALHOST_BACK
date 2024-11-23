package com.with.withlocalhost.chat.model;

public class ChatRoomDto {
	private int chatRoomId;
	private String chatGuidId;
	private String chatGuestId;
	private String lastMessage;
	public ChatRoomDto() {

	}

	public ChatRoomDto(int chatRoomId, String chatGuidId, String chatGuestId , String lastMessage) {
		super();
		this.chatRoomId = chatRoomId;
		this.chatGuidId = chatGuidId;
		this.chatGuestId = chatGuestId;
		this.lastMessage = lastMessage;
	}

	public String getLastMessage() {
		return lastMessage;
	}
	
	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}
	
	public int getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public String getChatGuidId() {
		return chatGuidId;
	}

	public void setChatGuidId(String chatGuidId) {
		this.chatGuidId = chatGuidId;
	}

	public String getChatGuestId() {
		return chatGuestId;
	}

	public void setChatGuestId(String chatGuestId) {
		this.chatGuestId = chatGuestId;
	}

	@Override
	public String toString() {
		return "ChatRoomDto [chatRoomId=" + chatRoomId + ", chatGuidId=" + chatGuidId + ", chatGuestId=" + chatGuestId
				+ "]";
	}

}
