package com.huayu.bo.base;

import java.util.Date;

public class ShareBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  resource id
	*/
	private Integer resid ; 

	/**
	*  share owner
	*/
	private Long sharerId ; 

	/**
	*  share time
	*/
	private Date date ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setResid(Integer resid){
		this.resid = resid;
	} 

	public Integer getResid(){
		return resid;
	}  

	public void setSharerId(Long sharerId){
		this.sharerId = sharerId;
	} 

	public Long getSharerId(){
		return sharerId;
	}  

	public void setDate(Date date){
		this.date = date;
	} 

	public Date getDate(){
		return date;
	}  

}