package com.huayu.platform.mail;

import org.apache.commons.lang3.StringUtils;

public class MailProperties {
	private String sender;
	private String receiver;
	private String subject ;
	private String content;
	private String[] files;
	
	private String password;
	private String host;
	
	public MailProperties(){
		
	}
	
	public MailProperties(String sender , String receiver , String password){
		this.sender = sender;
		this.receiver = receiver ;
		this.password = password ;
	}

	public String validate(){
		StringBuffer validateMsg = new StringBuffer();
		if(StringUtils.isEmpty(sender)){
			validateMsg.append("sender is null ; ");
		}
		
		if(StringUtils.isEmpty(receiver)){
			validateMsg.append("receiver is null ; ");
		}
		
		if(StringUtils.isEmpty(password)){
			validateMsg.append("password is null");
		}
		
	
		
		return validateMsg.toString() ;
	}
	
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		if(StringUtils.isEmpty(host)){
			host = "smtp." +  sender.substring(sender.indexOf('@'));
		}
		
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
