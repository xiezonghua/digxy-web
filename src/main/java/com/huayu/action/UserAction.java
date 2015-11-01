package com.huayu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huayu.bo.User;
import com.huayu.constant.DictConst;
import com.huayu.model.UserModel;
import com.huayu.platform.AuthorityType;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.platform.util.validate.ValidateUtils;
import com.huayu.service.UserService;
import com.huayu.utils.DictionaryHelper;
import com.huayu.utils.DigxyBoConverter;
import com.huayu.utils.SessionHelper;
import com.opensymphony.xwork2.ActionContext;

@Namespace("/user")
public class UserAction extends BasicModelAction {
	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = LoggerFactory.getLogger(UserAction.class.getCanonicalName());
	
	private UserModel userModel = new UserModel();
	
	@Resource(name="userService")	
	private UserService service;

	@Action(value="center" , results={@Result(type="velocity" , location="/vm/user.vm" , name=SUCCESS)})
	public String center(){
		User user = service.queryByPrimaryKey(getUserId());
		setData(DigxyBoConverter.toUserModel(user));
		return SUCCESS;
	}
	
	@Action(value="login" , results={@Result(type="json" , name=SUCCESS)})
	public String login(){
		Map<String, Object> validateResult = ValidateUtils.validateEmpty(new String[]{"userName", "passowrd"}, new String[]{userModel.getUserName(), userModel.getPassword()});
		if(!validateResult.isEmpty()){
			setValidateInfo(validateResult);
			return SUCCESS;
		}
		
		User user = service.userLogin(userModel.getUserName(), userModel.getPassword());
		
		if( null == user){
			setStautsInfo("login failure , username or password is bad.");
			logger.info("login failure , username or password is bad.");
		}else{
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put(SessionHelper.SESSION_USER_ID, user.getId());
			session.put(SessionHelper.SESSION_USERNAME, user.getYhm());
			session.put(SessionHelper.SESSION_PASSWORD, user.getPwd());
			session.put(SessionHelper.SESSION_USER_ROLE, user.getRole());
		}
		
		return SUCCESS;
	}
	
	@Action(value="signout" , results={@Result(type="json" , name=SUCCESS)})
	public String signOut(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
	
	@Action(value="regist" , results={@Result(type="json" , name=SUCCESS)})
	public String regist(){
		String[] validateNames = new String[]{"userName", "password","petName" , "email"};
		String[] validateValues = new String[]{userModel.getUserName() , userModel.getPassword() , userModel.getPetName() , userModel.getEmail()};
		if(!validate(validateNames, validateValues)) return SUCCESS;
		User user = DigxyBoConverter.toUser(userModel);
		user.setZcsj(new Date());
		user.setRole(AuthorityType.MEMBER.getValue());
		user.setLev("1");
		service.addSelective(user);
		return SUCCESS;
	}
	
	@Action(value="m" , results={@Result(type="velocity" , location="/vm/user_manager.vm" , name=SUCCESS)})
	public String manage(){
		Map<String, Object> query = new HashMap<String , Object>();
		query.put("beginDate", getBeginDate());
		query.put("endDate", getEndDate());
		Long count =  service.queryUsersCount(query);
		
		List<User> users = new ArrayList<User>();
		if(count > 0){
			query.putAll(getPagination().toMap());
			users = service.queryUsers(query);
		}
		
		query.clear();
		query.put("count" , count);
		query.put("list", users);
		query.put("userTypes", DictionaryHelper.getDictionaryByTypeCode(DictConst.MEMBER_AUTHORITY_TYPE));
		
		setData(query);
		
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
		
		service.updateByPrimaryKeySelective(DigxyBoConverter.toUser(userModel));
		return SUCCESS;
		
	}
	
	@Action(value="updatePwd" , results={@Result(type="json" , name=SUCCESS)})
	public String updatePwd(){
		if(!getPassword().equals(userModel.getOldPassword())){
			return setStautsInfo("用户密码不正确");
		}
		userModel.setId(getUserId());
		
		service.updateByPrimaryKeySelective(DigxyBoConverter.toUser(userModel));
		
		return SUCCESS;
	}

	@Action(value="getById" , results={@Result(type="json" , name=SUCCESS)})
	public String getById(){
		if( null == userModel.getId()){
			return setStautsInfo("Query fail , id is null");
		}
		User user = service.queryByPrimaryKey(userModel.getId());
		setData(DigxyBoConverter.toUserModel(user));
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(type="json" , name=SUCCESS)})
	public String get(){
		service.query(DigxyBoConverter.toUser(userModel));
		return SUCCESS;
	}
	
	@Action(value="attentive" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/myattentive.vm")})
	public String attentive(){
		List<User> attentives = service.queryAttentions(getUserId());
		List<User> followers = service.queryFollowers(getUserId());
		
		Map<String , Object> result = new HashMap<String, Object>();
		result.put("attentives", attentives);
		result.put("followers", followers);
		
		setData(result);
		
		return SUCCESS;
	}
	
	
	public BasicModel getModel() {
		return getBasicModel();
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

}