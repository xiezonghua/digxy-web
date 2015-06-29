package com.huayu.model;

public class ProjectModel {
	private Long id;
	private Long projectId;
	private Byte status;
	private Byte pstatus;
	private String msg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getPstatus() {
		return pstatus;
	}

	public void setPstatus(Byte pstatus) {
		this.pstatus = pstatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
