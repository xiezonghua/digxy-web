package com.huayu.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.huayu.platform.util.string.Security;

public class UserModel {
	private Long id;
	private String userName;
	private String petName;
	private Byte sex;
	private String oldPassword;
	private String password;
	private String cardID;
	private String imessager;
	private String phone;
	private Date regtime;
	private String profile;
	private String email;
	private String imgSrc;
	private String level;
	private Byte role;
	
	//项目申请
	private String name ;
	private String birthplace;
	private Date birthdate;
	private String school;
	private String major;
	private String health;
	private String englishLevel;
	private String edu;
	private String professionalSkill;
	private String plan;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getOldPassword() {
		if(StringUtils.isEmpty(oldPassword)) return oldPassword; 
		return Security.encryptWithMD5(oldPassword);
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		if(StringUtils.isEmpty(password)) return password;
		return Security.encryptWithMD5(password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Byte getSex() {
		return sex;
	}
	
	public String getImessager() {
		return imessager;
	}

	public void setImessager(String imessager) {
		this.imessager = imessager;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Byte getRole() {
		return role;
	}

	public void setRole(Byte role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getProfessionalSkill() {
		return professionalSkill;
	}

	public void setProfessionalSkill(String professionalSkill) {
		this.professionalSkill = professionalSkill;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	
}
