package com.huayu.bo;

import com.huayu.bo.base.ProjectBase;

/**
* 
*
*/
public class Project extends ProjectBase {
	private String sponsorName;

	private String major;

	private String company;

	private String sponsorResume;
	
	private String portrait;

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSponsorResume() {
		return sponsorResume;
	}

	public void setSponsorResume(String sponsorResume) {
		this.sponsorResume = sponsorResume;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	
}