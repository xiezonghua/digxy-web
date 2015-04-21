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
	private Long resid ; 

	/**
	*  yhm
	*/
	private String yhm ; 

	/**
	*  create date time
	*/
	private Date date ; 

	/**
	*  state
	*/
	private Integer state ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setResid(Long resid){
		this.resid = resid;
	} 

	public Long getResid(){
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

	public void setState(Integer state){
		this.state = state;
	} 

	public Integer getState(){
		return state;
	}  

}