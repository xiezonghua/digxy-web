package com.huayu.bo.base;

import java.util.Date;

public class ProjectBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  resource id
	*/
	private Long resId ; 

	/**
	*  attender id
	*/
	private Long attenderId ; 

	/**
	*  create date time
	*/
	private Date applyDate ; 

	/**
	*  attender role
	*/
	private Byte role ; 

	/**
	*  state , 1 apply , 2 : working 3:completed 
	*/
	private Byte state ; 

	/**
	*  error info
	*/
	private String msg ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setResId(Long resId){
		this.resId = resId;
	} 

	public Long getResId(){
		return resId;
	}  

	public void setAttenderId(Long attenderId){
		this.attenderId = attenderId;
	} 

	public Long getAttenderId(){
		return attenderId;
	}  

	public void setApplyDate(Date applyDate){
		this.applyDate = applyDate;
	} 

	public Date getApplyDate(){
		return applyDate;
	}  

	public void setRole(Byte role){
		this.role = role;
	} 

	public Byte getRole(){
		return role;
	}  

	public void setState(Byte state){
		this.state = state;
	} 

	public Byte getState(){
		return state;
	}  

	public void setMsg(String msg){
		this.msg = msg;
	} 

	public String getMsg(){
		return msg;
	}  

}