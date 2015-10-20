package com.huayu.bo;

import com.huayu.bo.base.ProjectResourceBase;

/**
* 
*
*/
public class ProjectResource extends ProjectResourceBase {

	private String projectName;
	private String uploaderName;
	private String portrait;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

}