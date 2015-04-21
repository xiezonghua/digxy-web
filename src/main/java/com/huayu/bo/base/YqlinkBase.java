package com.huayu.bo.base;


public class YqlinkBase {
	/**
	*  id
	*/
	private Long id ; 

	/**
	*  yqtitle
	*/
	private String yqtitle ; 

	/**
	*  yqhref
	*/
	private String yqhref ; 

	/**
	*  yqxh
	*/
	private Integer yqxh ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setYqtitle(String yqtitle){
		this.yqtitle = yqtitle;
	} 

	public String getYqtitle(){
		return yqtitle;
	}  

	public void setYqhref(String yqhref){
		this.yqhref = yqhref;
	} 

	public String getYqhref(){
		return yqhref;
	}  

	public void setYqxh(Integer yqxh){
		this.yqxh = yqxh;
	} 

	public Integer getYqxh(){
		return yqxh;
	}  

}