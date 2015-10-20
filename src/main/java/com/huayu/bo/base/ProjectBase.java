package com.huayu.bo.base;

import java.util.Date;

public class ProjectBase {
	/**
	*  key id
	*/
	private Long id ; 

	/**
	*  project name
	*/
	private String name ; 

	/**
	*  description
	*/
	private String description ; 

	/**
	*  who upload the resource
	*/
	private Long sponsor ; 

	/**
	*  upload date
	*/
	private Date uploadDate ; 

	/**
	*  who check the resource
	*/
	private Long checker ; 

	/**
	*  check date
	*/
	private Date checkDate ; 

	/**
	*  passed , waiting , failure
	*/
	private Byte status ; 

	/**
	*  check message
	*/
	private String checkMsg ; 

	/**
	*  what time the project begin in plan
	*/
	private Date beginDatetime ; 

	/**
	*  what time the project end in plan
	*/
	private Date endDatetime ; 

	/**
	*  attender limit
	*/
	private Integer attenderLimit ; 

	/**
	*  plan document
	*/
	private String planDoc ; 

	/**
	*  foster plan document
	*/
	private String fosterDoc ; 

	/**
	*  talents document
	*/
	private String talentsDoc ; 

	/**
	*  project handle status
	*/
	private Byte processStatus ; 


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

	public void setDescription(String description){
		this.description = description;
	} 

	public String getDescription(){
		return description;
	}  

	public void setSponsor(Long sponsor){
		this.sponsor = sponsor;
	} 

	public Long getSponsor(){
		return sponsor;
	}  

	public void setUploadDate(Date uploadDate){
		this.uploadDate = uploadDate;
	} 

	public Date getUploadDate(){
		return uploadDate;
	}  

	public void setChecker(Long checker){
		this.checker = checker;
	} 

	public Long getChecker(){
		return checker;
	}  

	public void setCheckDate(Date checkDate){
		this.checkDate = checkDate;
	} 

	public Date getCheckDate(){
		return checkDate;
	}  

	public void setStatus(Byte status){
		this.status = status;
	} 

	public Byte getStatus(){
		return status;
	}  

	public void setCheckMsg(String checkMsg){
		this.checkMsg = checkMsg;
	} 

	public String getCheckMsg(){
		return checkMsg;
	}  

	public void setBeginDatetime(Date beginDatetime){
		this.beginDatetime = beginDatetime;
	} 

	public Date getBeginDatetime(){
		return beginDatetime;
	}  

	public void setEndDatetime(Date endDatetime){
		this.endDatetime = endDatetime;
	} 

	public Date getEndDatetime(){
		return endDatetime;
	}  

	public void setAttenderLimit(Integer attenderLimit){
		this.attenderLimit = attenderLimit;
	} 

	public Integer getAttenderLimit(){
		return attenderLimit;
	}  

	public void setPlanDoc(String planDoc){
		this.planDoc = planDoc;
	} 

	public String getPlanDoc(){
		return planDoc;
	}  

	public void setFosterDoc(String fosterDoc){
		this.fosterDoc = fosterDoc;
	} 

	public String getFosterDoc(){
		return fosterDoc;
	}  

	public void setTalentsDoc(String talentsDoc){
		this.talentsDoc = talentsDoc;
	} 

	public String getTalentsDoc(){
		return talentsDoc;
	}  

	public void setProcessStatus(Byte processStatus){
		this.processStatus = processStatus;
	} 

	public Byte getProcessStatus(){
		return processStatus;
	}  

}