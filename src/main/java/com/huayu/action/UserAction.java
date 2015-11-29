package com.huayu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huayu.bo.User;
import com.huayu.constant.DictConst;
import com.huayu.model.UserModel;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.platform.exception.ActionRuntimeException;
import com.huayu.platform.mail.MailProperties;
import com.huayu.platform.mail.MailServer;
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
	
	private Long resetTime ;
	private String oldPwd ;
	
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
		
		Map<String , Object> query = new HashMap<String,Object>();
		query.put("email", user.getEmail());
		Long userCount = service.queryUsersCount(query);
		if(userCount > 0 ){
			throw new ActionRuntimeException("邮箱已经被注册过了，请使用其他邮箱。");
		}
		service.register(user);
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
	
	@Action(value="findPwd" , results={@Result(type="json" , name=SUCCESS)})
	public String findPwd(){
		Map<String , Object> query = new HashMap<String,Object>();
		query.put("email", userModel.getEmail());
		List<User> user = service.queryUsers(query);
		if(user.size() != 1 ){
			logger.warn("Find {} user by the email " , user.size());
			throw new ActionRuntimeException("邮箱存在问题，请确认；否则请联系管理员。");
		}
		MailProperties mailProp = MailServer.getDefaultProperties();
		mailProp.setReceiver(userModel.getEmail());
		mailProp.setSubject("迪格学苑密码找回");
		String resetUrl = "http://www.digxy.cn/page/up_reset.html?email="+userModel.getEmail() +"&t="+System.currentTimeMillis() +"&p=" + user.get(0).getPwd() ;
		mailProp.setContent("请使用当前地址一个小时内重置密码, <a href='"+resetUrl+"'>"+resetUrl+"</a>");
		
		try {
			MailServer.sendSimpleMail(mailProp);
		} catch (MessagingException e) {
			logger.info("The mail {} send failure , In password find action , exception: {}" , userModel.getEmail() , e);
			throw new ActionRuntimeException("邮件发送失败，请重试！");
		}
		return SUCCESS;
	}
	
	@Action(value="resetPwd" , results={@Result(type="json" , name=SUCCESS)})
	public String resetPwd(){
		if(System.currentTimeMillis() - this.getResetTime() > 60*60*1000){
			logger.info("the user{} modify password url have outtime.", userModel.getEmail());
		}
		Map<String, Object> query = new HashMap<String,Object>();
		query.put("email", userModel.getEmail());
		query.put("password", oldPwd);
		List<User> userList = service.queryUsers(query);
		
		if(userList.size() != 1){
			logger.warn("the user{} exist more than one" , userModel.getEmail());
			throw new ActionRuntimeException("该用户存在安全问题，暂时无法修改密码，请联系管理员");
		}
		
		User user = new User();
		user.setPwd(userModel.getPassword());
		user.setId(userList.get(0).getId());
		
		service.updateByPrimaryKeySelective(user);
		
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

	public Long getResetTime() {
		return resetTime;
	}

	public void setResetTime(Long resetTime) {
		this.resetTime = resetTime;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	
	

}