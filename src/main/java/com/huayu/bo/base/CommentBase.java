package com.huayu.bo.base;

import java.util.Date;

public class CommentBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  resource id
	*/
	private Long resId ; 

	/**
	*  who comment
	*/
	private Long commenterId ; 

	/**
	*   who revert
	*/
	private String commenter ; 

	/**
	*  comment time
	*/
	private Date commentDate ; 

	/**
	*  content
	*/
	private String content ; 


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

	public void setCommenterId(Long commenterId){
		this.commenterId = commenterId;
	} 

	public Long getCommenterId(){
		return commenterId;
	}  

	public void setCommenter(String commenter){
		this.commenter = commenter;
	} 

	public String getCommenter(){
		return commenter;
	}  

	public void setCommentDate(Date commentDate){
		this.commentDate = commentDate;
	} 

	public Date getCommentDate(){
		return commentDate;
	}  

	public void setContent(String content){
		this.content = content;
	} 

	public String getContent(){
		return content;
	}  

}