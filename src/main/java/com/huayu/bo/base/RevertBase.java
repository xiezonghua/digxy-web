package com.huayu.bo.base;

import java.util.Date;

public class RevertBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  resource id
	*/
	private Integer resid ; 

	/**
	*   who revert
	*/
	private String revertname ; 

	/**
	*  revert time
	*/
	private Date revertdate ; 

	/**
	*  revert content
	*/
	private String revertcontent ; 


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

	public void setRevertname(String revertname){
		this.revertname = revertname;
	} 

	public String getRevertname(){
		return revertname;
	}  

	public void setRevertdate(Date revertdate){
		this.revertdate = revertdate;
	} 

	public Date getRevertdate(){
		return revertdate;
	}  

	public void setRevertcontent(String revertcontent){
		this.revertcontent = revertcontent;
	} 

	public String getRevertcontent(){
		return revertcontent;
	}  

}