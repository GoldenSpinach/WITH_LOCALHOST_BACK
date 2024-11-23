package com.with.withlocalhost.chat.model;

import java.util.Date;

public class ChatMessageDto {
	private int msgId;
	private String sendId;
	private int chatRoomId;
	private String msgContent;
	private String msgSendDate;
	private String msgSendTime;
	private String msgStatus;
	private String receiver;
	public ChatMessageDto() {

	}

	public ChatMessageDto(int msgId ,String sendId, int chatRoomId, String msgContent, String msgSendDate, String msgSendTime,String msgStatus,String receiver) {
		super();
		this.msgId = msgId;
		this.sendId = sendId;
		this.chatRoomId = chatRoomId;
		this.msgContent = msgContent;
		this.msgSendDate = msgSendDate;
		this.msgSendTime = msgSendTime;
		this.msgStatus = msgStatus;
		this.receiver = receiver;
	}
	
	public String getReceiver() {
		return receiver;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public String getMsgSendTime() {
		return msgSendTime;
	}
	
	public void setMsgSendTime(String msgSendTime) {
		this.msgSendTime = msgSendTime;
	}
	
	public int getMsgId() {
		return msgId;
	}
	
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public int getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgSendDate() {
		return msgSendDate;
	}

	public void setMsgSendDate(String msgSendDate) {
		this.msgSendDate = msgSendDate;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	@Override
	public String toString() {
		return "ChatMessageDto [sendId=" + sendId + ", chatRoomId=" + chatRoomId + ", msgContent=" + msgContent
				+ ", msgSendDate=" + msgSendDate + ", msgStatus=" + msgStatus + "]";
	}

}
