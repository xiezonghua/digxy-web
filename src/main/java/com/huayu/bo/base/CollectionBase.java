package com.huayu.bo.base;

import java.util.Date;

public class CollectionBase {
	/**
	*  key id
	*/
	private Long id ; 

	/**
	*  resource id
	*/
	private Long resid ; 

	/**
	*  collector id
	*/
	private Long collectionId ; 

	/**
	*  collector
	*/
	private String collectioner ; 

	/**
	*  collect date time
	*/
	private Date collectiondate ; 


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

	public void setCollectionId(Long collectionId){
		this.collectionId = collectionId;
	} 

	public Long getCollectionId(){
		return collectionId;
	}  

	public void setCollectioner(String collectioner){
		this.collectioner = collectioner;
	} 

	public String getCollectioner(){
		return collectioner;
	}  

	public void setCollectiondate(Date collectiondate){
		this.collectiondate = collectiondate;
	} 

	public Date getCollectiondate(){
		return collectiondate;
	}  

}