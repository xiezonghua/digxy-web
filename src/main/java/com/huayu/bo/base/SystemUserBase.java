package com.huayu.bo.base;

import java.util.Date;

public class SystemUserBase {
	/**
	*  KEY ID
	*/
	private Long id ; 

	/**
	*  user Name
	*/
	private String name ; 

	/**
	*  petName
	*/
	private String petName ; 

	/**
	*  password
	*/
	private String pwd ; 

	/**
	*  resume
	*/
	private String resume ; 

	/**
	*  boy or girl
	*/
	private Byte sex ; 

	/**
	*  email address
	*/
	private String email ; 

	/**
	*  sfz
	*/
	private String sfz ; 

	/**
	*  im
	*/
	private String im ; 

	/**
	*  phone
	*/
	private String phone ; 

	/**
	*  sign in time
	*/
	private Date registTime ; 

	/**
	*  sign off time
	*/
	private Date lastSignIn ; 

	/**
	*  point
	*/
	private String point ; 

	/**
	*  prestige
	*/
	private String prestige ; 


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

	public void setPetName(String petName){
		this.petName = petName;
	} 

	public String getPetName(){
		return petName;
	}  

	public void setPwd(String pwd){
		this.pwd = pwd;
	} 

	public String getPwd(){
		return pwd;
	}  

	public void setResume(String resume){
		this.resume = resume;
	} 

	public String getResume(){
		return resume;
	}  

	public void setSex(Byte sex){
		this.sex = sex;
	} 

	public Byte getSex(){
		return sex;
	}  

	public void setEmail(String email){
		this.email = email;
	} 

	public String getEmail(){
		return email;
	}  

	public void setSfz(String sfz){
		this.sfz = sfz;
	} 

	public String getSfz(){
		return sfz;
	}  

	public void setIm(String im){
		this.im = im;
	} 

	public String getIm(){
		return im;
	}  

	public void setPhone(String phone){
		this.phone = phone;
	} 

	public String getPhone(){
		return phone;
	}  

	public void setRegistTime(Date registTime){
		this.registTime = registTime;
	} 

	public Date getRegistTime(){
		return registTime;
	}  

	public void setLastSignIn(Date lastSignIn){
		this.lastSignIn = lastSignIn;
	} 

	public Date getLastSignIn(){
		return lastSignIn;
	}  

	public void setPoint(String point){
		this.point = point;
	} 

	public String getPoint(){
		return point;
	}  

	public void setPrestige(String prestige){
		this.prestige = prestige;
	} 

	public String getPrestige(){
		return prestige;
	}  

}