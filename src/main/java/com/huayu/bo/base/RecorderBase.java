package com.huayu.bo.base;

import java.util.Date;

public class RecorderBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  resource id
	*/
	private Long resid ; 

	/**
	*  who download
	*/
	private String downloader ; 

	/**
	*  download date time
	*/
	private Date downloaddate ; 


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

	public void setDownloader(String downloader){
		this.downloader = downloader;
	} 

	public String getDownloader(){
		return downloader;
	}  

	public void setDownloaddate(Date downloaddate){
		this.downloaddate = downloaddate;
	} 

	public Date getDownloaddate(){
		return downloaddate;
	}  

}