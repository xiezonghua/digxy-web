package com.huayu.model;

public class MessageModel {
	private Long id ; 

	/**
	*  sender id
	*/
	private Long senderId ; 

	/**
	*   sender
	*/
	private String sender ; 

	/**
	*  receiver id
	*/
	private Long receiverId ; 

	/**
	*  email receiver
	*/
	private String receiver ; 

	/**
	*  email title
	*/
	private String title ; 

	/**
	*  email content
	*/
	private String content ;
	
	private Byte status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	} 
	
	
}

