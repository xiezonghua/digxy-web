package com.huayu.platform.action;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = 6800744849910198243L;

	private String loginName;
	private String userName;
	private Long userId;

	public String getLoginName() {
		return loginName;
	}

	public String getUserName() {
		return userName;
	}


	public Long getUserId() {
		return 2l;
	}

	public String getPassword(){
		return "";
	}

}
