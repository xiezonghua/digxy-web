package com.huayu.bo.base;


public class KeywordBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  key word
	*/
	private String keywords ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setKeywords(String keywords){
		this.keywords = keywords;
	} 

	public String getKeywords(){
		return keywords;
	}  

}