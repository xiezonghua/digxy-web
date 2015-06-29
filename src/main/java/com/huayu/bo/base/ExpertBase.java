package com.huayu.bo.base;

import java.util.Date;

public class ExpertBase {
	/**
	*  id
	*/
	private Long id ; 

	/**
	*  name
	*/
	private String name ; 

	/**
	*  qq
	*/
	private String qq ; 

	/**
	*  profile
	*/
	private String profile ; 

	/**
	*  addDate
	*/
	private Date addDate ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setName(String name){
		this.name = name;
	} 

	public String getName(){
		return name;
	}  

	public void setQq(String qq){
		this.qq = qq;
	} 

	public String getQq(){
		return qq;
	}  

	public void setProfile(String profile){
		this.profile = profile;
	} 

	public String getProfile(){
		return profile;
	}  

	public void setAddDate(Date addDate){
		this.addDate = addDate;
	} 

	public Date getAddDate(){
		return addDate;
	}  

}