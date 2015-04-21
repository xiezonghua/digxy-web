package com.huayu.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.huayu.bo.User;
import com.huayu.service.UserService;
import com.huayu.utils.SessionHelper;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthCheckFilter extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;
	
	private String excludedPatter = "" ;
	
	@Resource
	private UserService userService;	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Pattern pathPatten = Pattern.compile("");
		Matcher matcher = pathPatten.matcher("");
		if(matcher != null && matcher.find()){
			return invocation.invokeActionOnly();
		}
		ActionContext context = invocation.getInvocationContext() ;		
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		
		HttpSession session =  request.getSession();
		String userName = (String) session.getAttribute(SessionHelper.SESSION_USERNAME);
		String password = (String) session.getAttribute(SessionHelper.SESSION_PASSWORD);
		
//		Map<String, Object> session = invocation.getInvocationContext().getSession();
//		
//		String userName =  (String) session.get(SessionHelper.SESSION_USERNAME);
//		String password = (String) session.get(SessionHelper.SESSION_PASSWORD);
	
		boolean isCorrect = isCorrectAccount(userName, password);
		
		if(!isCorrect){
			return invocation.invoke();
		}
		session.setMaxInactiveInterval(10*60*1000);
		return Action.LOGIN;
	}
	
	private boolean isCorrectAccount(String userName , String password){
		boolean  isCorrect = false ;
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			return isCorrect ;
		}
		
		User user = userService.userLogin(userName, password);	
		if( null != user ){
			isCorrect = true ;			
		}		
		return isCorrect ;
	}
}

