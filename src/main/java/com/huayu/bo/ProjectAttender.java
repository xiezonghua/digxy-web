package com.huayu.bo;

import com.huayu.bo.base.ProjectAttenderBase;

/**
* 
*
*/
public class ProjectAttender extends ProjectAttenderBase {
	private String attenderName;
	private String attenderPetName;
	private String portraitSrc;

	public String getAttenderName() {
		return attenderName;
	}

	public void setAttenderName(String attenderName) {
		this.attenderName = attenderName;
	}

	public String getAttenderPetName() {
		return attenderPetName;
	}

	public void setAttenderPetName(String attenderPetName) {
		this.attenderPetName = attenderPetName;
	}

	public String getPortraitSrc() {
		return portraitSrc;
	}

	public void setPortraitSrc(String portraitSrc) {
		this.portraitSrc = portraitSrc;
	}

}