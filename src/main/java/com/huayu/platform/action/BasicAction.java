package com.huayu.platform.action;

import com.huayu.platform.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = 6800744849910198243L;

	private Integer role;
	private String userName;
	private Long userId;
	private Integer pageNum = 0;
	private Integer offset = 10;
	private Pagination pagination = new Pagination(); 

	public Integer getRole(){
		return 0;
	}

	public String getUserName() {
		return userName;
	}

	public Long getUserId() {
		return 2l;
	}

	public String getPassword() {
		return "";
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	public Pagination getPagination(){
		pagination.setOffset(offset);
		pagination.setPageNum(pageNum);
		return pagination;
	}

}
