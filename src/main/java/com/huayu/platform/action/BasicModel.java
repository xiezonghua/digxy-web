package com.huayu.platform.action;

public class BasicModel {
	private int status = 200;
	private String statusInfo;

	private Object data;

	private Object validateInfo;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getValidateInfo() {
		return validateInfo;
	}

	public void setValidateInfo(Object validateInfo) {
		this.validateInfo = validateInfo;
	}

}
