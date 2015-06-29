package com.huayu.bo;

import java.util.Date;

import com.huayu.bo.base.ProjectBase;

/**
* 
*
*/
public class Project extends ProjectBase {
	private String attenderName;
	private String attenderPetName;
	private String resName;
	private Date createDate;
	private Byte projectStatus;
	private String filePath;
	private String fileName;
	private String attenderCount;

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

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Byte getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Byte projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAttenderCount() {
		return attenderCount;
	}

	public void setAttenderCount(String attenderCount) {
		this.attenderCount = attenderCount;
	}

}