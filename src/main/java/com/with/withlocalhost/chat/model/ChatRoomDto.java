package com.with.withlocalhost.chat.model;

public class ChatRoomDto {
    private int chatRoomId;
    private String chatGuidId;
    private String chatGuidNickName;
    private String chatGuestId;
    private String chatGuestNickName;
    private String lastMessage;
    private String userImg;

    public ChatRoomDto() {

    }

    public ChatRoomDto(int chatRoomId, String chatGuidId, String chatGuidNickName, String chatGuestId, String chatGuestNickName, String lastMessage , String userImg) {
        super();
        this.chatRoomId = chatRoomId;
        this.chatGuidId = chatGuidId;
        this.chatGuidNickName = chatGuidNickName;
        this.chatGuestId = chatGuestId;
        this.chatGuestNickName = chatGuestNickName;
        this.lastMessage = lastMessage;
        this.userImg = userImg;
    }

    // Getter and Setter methods
    
    public String getUserImg() {
    	return userImg;
    }
    public void setUserImg(String userImg) {
    	this.userImg = userImg;
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

    public String getChatGuidNickName() {
        return chatGuidNickName;
    }

    public void setChatGuidNickName(String chatGuidNickName) {
        this.chatGuidNickName = chatGuidNickName;
    }

    public String getChatGuestId() {
        return chatGuestId;
    }

    public void setChatGuestId(String chatGuestId) {
        this.chatGuestId = chatGuestId;
    }

    public String getChatGuestNickName() {
        return chatGuestNickName;
    }

    public void setChatGuestNickName(String chatGuestNickName) {
        this.chatGuestNickName = chatGuestNickName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    @Override
    public String toString() {
        return "ChatRoomDto [chatRoomId=" + chatRoomId + ", chatGuidId=" + chatGuidId + ", chatGuestId=" + chatGuestId
                + ", chatGuidNickName=" + chatGuidNickName + ", chatGuestNickName=" + chatGuestNickName + "]";
    }
}
