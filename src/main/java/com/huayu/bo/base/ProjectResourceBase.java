package com.huayu.bo.base;

import java.util.Date;

public class ProjectResourceBase {
	/**
	*  key id
	*/
	private Long id ; 

	/**
	*  resource name
	*/
	private String name ; 

	/**
	*  resource description
	*/
	private String resDesc ; 

	/**
	*  file name , including the doc , swf ,image
	*/
	private String docName ; 

	/**
	*  where the file store .
	*/
	private String docFloder ; 

	/**
	*  level
	*/
	private Byte star ;

	/**
	*  upload time
	*/
	private Date uploadDate ; 

	/**
	*  who upload
	*/
	private Long uploader ; 

	/**
	*  who belong to 
	*/
	private Long projectId ; 

	/**
	*  some tag  
	*/
	private String label ; 

	/**
	*  click it times
	*/
	private Integer clickTimes ; 

	/**
	*  download times
	*/
	private Integer downloadTimes ; 

	/**
	*  status
	*/
	private Byte status ;


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

	public void setResDesc(String resDesc){
		this.resDesc = resDesc;
	} 

	public String getResDesc(){
		return resDesc;
	}  

	public void setDocName(String docName){
		this.docName = docName;
	} 

	public String getDocName(){
		return docName;
	}  

	public void setDocFloder(String docFloder){
		this.docFloder = docFloder;
	} 

	public String getDocFloder(){
		return docFloder;
	}  

	public void setStar(Byte star){
		this.star = star;
	} 

	public Byte getStar(){
		return star;
	}  

	public void setUploadDate(Date uploadDate){
		this.uploadDate = uploadDate;
	} 

	public Date getUploadDate(){
		return uploadDate;
	}  

	public void setUploader(Long uploader){
		this.uploader = uploader;
	} 

	public Long getUploader(){
		return uploader;
	}  

	public void setProjectId(Long projectId){
		this.projectId = projectId;
	} 

	public Long getProjectId(){
		return projectId;
	}  

	public void setLabel(String label){
		this.label = label;
	} 

	public String getLabel(){
		return label;
	}  

	public void setClickTimes(Integer clickTimes){
		this.clickTimes = clickTimes;
	} 

	public Integer getClickTimes(){
		return clickTimes;
	}  

	public void setDownloadTimes(Integer downloadTimes){
		this.downloadTimes = downloadTimes;
	} 

	public Integer getDownloadTimes(){
		return downloadTimes;
	}  

	public void setStatus(Byte status){
		this.status = status;
	} 

	public Byte getStatus(){
		return status;
	}  

}