package com.huayu.bo.base;

import java.util.Date;

public class MailBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  email sender
	*/
	private String senduser ; 

	/**
	*  email receiver
	*/
	private String receiveuser ; 

	/**
	*  email title
	*/
	private String emailtitle ; 

	/**
	*  email content
	*/
	private String emailcontent ; 

	/**
	*  email create time
	*/
	private Date date ; 

	/**
	*  bj
	*/
	private Integer bj ; 

	/**
	*  senddelbj
	*/
	private Integer senddelbj ; 

	/**
	*  receivedelbj
	*/
	private Integer receivedelbj ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setSenduser(String senduser){
		this.senduser = senduser;
	} 

	public String getSenduser(){
		return senduser;
	}  

	public void setReceiveuser(String receiveuser){
		this.receiveuser = receiveuser;
	} 

	public String getReceiveuser(){
		return receiveuser;
	}  

	public void setEmailtitle(String emailtitle){
		this.emailtitle = emailtitle;
	} 

	public String getEmailtitle(){
		return emailtitle;
	}  

	public void setEmailcontent(String emailcontent){
		this.emailcontent = emailcontent;
	} 

	public String getEmailcontent(){
		return emailcontent;
	}  

	public void setDate(Date date){
		this.date = date;
	} 

	public Date getDate(){
		return date;
	}  

	public void setBj(Integer bj){
		this.bj = bj;
	} 

	public Integer getBj(){
		return bj;
	}  

	public void setSenddelbj(Integer senddelbj){
		this.senddelbj = senddelbj;
	} 

	public Integer getSenddelbj(){
		return senddelbj;
	}  

	public void setReceivedelbj(Integer receivedelbj){
		this.receivedelbj = receivedelbj;
	} 

	public Integer getReceivedelbj(){
		return receivedelbj;
	}  

}