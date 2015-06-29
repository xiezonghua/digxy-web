package com.huayu.bo.base;

import java.util.Date;

public class MessageBase {
	/**
	*  KEY ID
	*/
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

	/**
	*  email create time
	*/
	private Date addDate ; 

	/**
	*  status
	*/
	private Byte status ; 

	/**
	*  senderMark
	*/
	private Byte senderMark ; 

	/**
	*  receiverMark
	*/
	private Byte receiverMark ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setSenderId(Long senderId){
		this.senderId = senderId;
	} 

	public Long getSenderId(){
		return senderId;
	}  

	public void setSender(String sender){
		this.sender = sender;
	} 

	public String getSender(){
		return sender;
	}  

	public void setReceiverId(Long receiverId){
		this.receiverId = receiverId;
	} 

	public Long getReceiverId(){
		return receiverId;
	}  

	public void setReceiver(String receiver){
		this.receiver = receiver;
	} 

	public String getReceiver(){
		return receiver;
	}  

	public void setTitle(String title){
		this.title = title;
	} 

	public String getTitle(){
		return title;
	}  

	public void setContent(String content){
		this.content = content;
	} 

	public String getContent(){
		return content;
	}  

	public void setAddDate(Date addDate){
		this.addDate = addDate;
	} 

	public Date getAddDate(){
		return addDate;
	}  

	public void setStatus(Byte status){
		this.status = status;
	} 

	public Byte getStatus(){
		return status;
	}  

	public void setSenderMark(Byte senderMark){
		this.senderMark = senderMark;
	} 

	public Byte getSenderMark(){
		return senderMark;
	}  

	public void setReceiverMark(Byte receiverMark){
		this.receiverMark = receiverMark;
	} 

	public Byte getReceiverMark(){
		return receiverMark;
	}  

}