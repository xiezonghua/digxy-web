package com.huayu.bo.base;


public class ZhuanjiaBase {
	/**
	*  id
	*/
	private Long id ; 

	/**
	*  zjname
	*/
	private String zjname ; 

	/**
	*  zjqq
	*/
	private String zjqq ; 

	/**
	*  zjjianjie
	*/
	private String zjjianjie ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setZjname(String zjname){
		this.zjname = zjname;
	} 

	public String getZjname(){
		return zjname;
	}  

	public void setZjqq(String zjqq){
		this.zjqq = zjqq;
	} 

	public String getZjqq(){
		return zjqq;
	}  

	public void setZjjianjie(String zjjianjie){
		this.zjjianjie = zjjianjie;
	} 

	public String getZjjianjie(){
		return zjjianjie;
	}  

}