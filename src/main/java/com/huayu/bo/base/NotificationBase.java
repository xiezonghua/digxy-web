package com.huayu.bo.base;

import java.util.Date;

public class NotificationBase {
	/**
	*  key id
	*/
	private Long id ; 

	/**
	*  business id
	*/
	private Long busId ; 

	/**
	*  detail
	*/
	private String content ; 

	/**
	*  add date
	*/
	private Date addDate ; 

	/**
	*  add user id
	*/
	private Long addUserId ; 

	/**
	*   0 : information , 1: notify all
	*/
	private Byte type ;

	/**
	*  0 : unavailable , 1 : available
	*/
	private Byte status ;

	/**
	*  1 : main  
	*/
	private Byte isMain ;


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setBusId(Long busId){
		this.busId = busId;
	} 

	public Long getBusId(){
		return busId;
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

	public void setAddUserId(Long addUserId){
		this.addUserId = addUserId;
	} 

	public Long getAddUserId(){
		return addUserId;
	}  

	public void setType(Byte type){
		this.type = type;
	} 

	public Byte getType(){
		return type;
	}  

	public void setStatus(Byte status){
		this.status = status;
	} 

	public Byte getStatus(){
		return status;
	}  

	public void setIsMain(Byte isMain){
		this.isMain = isMain;
	} 

	public Byte getIsMain(){
		return isMain;
	}  

}