package com.huayu.platform.action;

import java.util.Date;
import java.util.Map;

import com.huayu.platform.AuthorityType;
import com.huayu.platform.Pagination;
import com.huayu.platform.exception.ActionRuntimeException;
import com.huayu.platform.exception.ExceptionCode;
import com.huayu.utils.SessionHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = 6800744849910198243L;

//	private Integer role;
//	private String userName;
//	private Long userId;
	private Integer pageNum = 1;
	private Integer offset = 10;
	private Date beginDate ;
	private Date endDate ;
	private Pagination pagination = new Pagination(); 

	public Byte getRole(){
		return (Byte)getSession().get(SessionHelper.SESSION_USER_ROLE);
	}

	public String getUserName() {
		return  (String)getSession().get(SessionHelper.SESSION_USERNAME);
	}

	public Long getUserId() {
		return (Long)getSession().get(SessionHelper.SESSION_USER_ID);
	}

	public String getPassword() {
		return "";
	}

	protected void hasManagerAuthority() {
		Byte role = getRole();
		if(AuthorityType.SUPER_MAN.getValue() != role && AuthorityType.MANAGER.getValue() != role){
			throw new ActionRuntimeException("you need to apply for permission", ExceptionCode.NOT_AUTHORITY);
		}
	}
	private Map<String , Object> getSession(){
		 return ActionContext.getContext().getSession();
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
	
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Pagination getPagination(){
		pagination.setOffset(offset);
		pagination.setPageNum(pageNum);
		return pagination;
	}

}
