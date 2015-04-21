package com.huayu.bo.base;

import java.util.Date;

public class ResourcesBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  resouce name 
	*/
	private String resname ; 

	/**
	*  resource description
	*/
	private String resdescribe ; 

	/**
	*  resource label
	*/
	private String reslabel ; 

	/**
	*  resource store path
	*/
	private String respath ; 

	/**
	*  pdf store path
	*/
	private String pdfpath ; 

	/**
	*  swf store path
	*/
	private String swfpath ; 

	/**
	*  resource format
	*/
	private String resformat ; 

	/**
	*  resource src
	*/
	private String ressrc ; 

	/**
	*  type
	*/
	private Byte restype ;

	/**
	*  dic type
	*/
	private Byte dictype ;

	/**
	*  who commit
	*/
	private Long uploaderid ; 

	/**
	*  who commit
	*/
	private String uploader ; 

	/**
	*  commit datetime
	*/
	private Date uploaddate ; 

	/**
	*  who modify 
	*/
	private String modifier ;

	/**
	*  modify date time
	*/
	private Date modifydate ; 

	/**
	*  click times
	*/
	private Integer clicktimes ;

	/**
	*  download times
	*/
	private Integer downloadtimes ;

	/**
	*  document class
	*/
	private Byte resstar ;

	/**
	*  resource state
	*/
	private Byte resstatus ; 

	/**
	*  pstate
	*/
	private Integer pstate ; 


	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}  

	public void setResname(String resname){
		this.resname = resname;
	} 

	public String getResname(){
		return resname;
	}  

	public void setResdescribe(String resdescribe){
		this.resdescribe = resdescribe;
	} 

	public String getResdescribe(){
		return resdescribe;
	}  

	public void setReslabel(String reslabel){
		this.reslabel = reslabel;
	} 

	public String getReslabel(){
		return reslabel;
	}  

	public void setRespath(String respath){
		this.respath = respath;
	} 

	public String getRespath(){
		return respath;
	}  

	public void setPdfpath(String pdfpath){
		this.pdfpath = pdfpath;
	} 

	public String getPdfpath(){
		return pdfpath;
	}  

	public void setSwfpath(String swfpath){
		this.swfpath = swfpath;
	} 

	public String getSwfpath(){
		return swfpath;
	}  

	public void setResformat(String resformat){
		this.resformat = resformat;
	} 

	public String getResformat(){
		return resformat;
	}  

	public void setRessrc(String ressrc){
		this.ressrc = ressrc;
	} 

	public String getRessrc(){
		return ressrc;
	}  

	public void setRestype(Byte restype){
		this.restype = restype;
	} 

	public Byte getRestype(){
		return restype;
	}  

	public void setDictype(Byte dictype){
		this.dictype = dictype;
	} 

	public Byte getDictype(){
		return dictype;
	}  

	public void setUploaderid(Long uploaderid){
		this.uploaderid = uploaderid;
	} 

	public Long getUploaderid(){
		return uploaderid;
	}  

	public void setUploader(String uploader){
		this.uploader = uploader;
	} 

	public String getUploader(){
		return uploader;
	}  

	public void setUploaddate(Date uploaddate){
		this.uploaddate = uploaddate;
	} 

	public Date getUploaddate(){
		return uploaddate;
	}  

	public void setModifier(String modifier){
		this.modifier = modifier;
	} 

	public String getModifier(){
		return modifier;
	}  

	public void setModifydate(Date modifydate){
		this.modifydate = modifydate;
	} 

	public Date getModifydate(){
		return modifydate;
	}  

	public void setClicktimes(Integer clicktimes){
		this.clicktimes = clicktimes;
	} 

	public Integer getClicktimes(){
		return clicktimes;
	}  

	public void setDownloadtimes(Integer downloadtimes){
		this.downloadtimes = downloadtimes;
	} 

	public Integer getDownloadtimes(){
		return downloadtimes;
	}  

	public void setResstar(Byte resstar){
		this.resstar = resstar;
	} 

	public Byte getResstar(){
		return resstar;
	}  

	public void setResstatus(Byte resstatus){
		this.resstatus = resstatus;
	} 

	public Byte getResstatus(){
		return resstatus;
	}  

	public void setPstate(Integer pstate){
		this.pstate = pstate;
	} 

	public Integer getPstate(){
		return pstate;
	}  

}