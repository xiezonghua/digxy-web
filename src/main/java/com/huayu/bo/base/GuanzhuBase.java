package com.huayu.bo.base;

import java.util.Date;

public class GuanzhuBase {
	/**
	*  key id
	*/
	private Long id ; 

	/**
	*  attentive user id
	*/
	private Long userId ; 

	/**
	*  follower user id
	*/
	private Long followerId ; 

	/**
	*  attentive time
	*/
	private Date date ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setUserId(Long userId){
		this.userId = userId;
	} 

	public Long getUserId(){
		return userId;
	}  

	public void setFollowerId(Long followerId){
		this.followerId = followerId;
	} 

	public Long getFollowerId(){
		return followerId;
	}  

	public void setDate(Date date){
		this.date = date;
	} 

	public Date getDate(){
		return date;
	}  

}