package com.huayu.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.model.UserModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.platform.util.DateUtils;
import com.huayu.service.SystemUserService;

public class SystemUserAction extends BasicModelAction {

	private static final long serialVersionUID = 1L;
	
	@Resource(name="systemUserService")
	private SystemUserService service;
	
	private UserModel userModel;
	
	@Action(value="regist" , results={@Result(type="json" , name=SUCCESS)})
	public String regist(){
		String[] validateNames = new String[]{"userName", "password","petName" , "email"};
		String[] validateValues = new String[]{userModel.getUserName() , userModel.getPassword() , userModel.getPetName() , userModel.getEmail()};
		if(!validate(validateNames, validateValues)) return SUCCESS;
		userModel.setRegtime(new Date());
//		service.addSelective();
		return SUCCESS;
	}

	@Action(value="update" , results={@Result(type="json" , name=SUCCESS)})
	public String update(){
		if(null == userModel.getId()){
			setStautsInfo("update failure ,  missed the key");
			return SUCCESS;
		}
		
		String[] validateNames = new String[]{"petName" , "email"};
		String[] validateValues = new String[]{ userModel.getPetName() , userModel.getEmail()};
		if(!validate(validateNames, validateValues)) return SUCCESS;
		
//		service.updateByPrimaryKeySelective(DigxyBoConverter.toUser(userModel));
		return SUCCESS;
		
	}
	
	public static void main(String[] args) {
		String dateFolder = DateUtils.format(new Date(), "/yyyyMMdd/");
		System.out.println(dateFolder);
	}

}
