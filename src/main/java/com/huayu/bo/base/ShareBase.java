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
	*  user name
	*/
	private String yhm ; 

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

	public void setYhm(String yhm){
		this.yhm = yhm;
	} 

	public String getYhm(){
		return yhm;
	}  

	public void setDate(Date date){
		this.date = date;
	} 

	public Date getDate(){
		return date;
	}  

}