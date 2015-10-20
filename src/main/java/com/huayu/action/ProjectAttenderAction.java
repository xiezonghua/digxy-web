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

import com.huayu.bo.ProjectAttender;
import com.huayu.bo.Resources;
import com.huayu.bo.User;
import com.huayu.constant.DictConst;
import com.huayu.constant.ProjectConst;
import com.huayu.model.ProjectModel;
import com.huayu.model.UserModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ProjectAttenderService;
import com.huayu.service.ResourcesService;
import com.huayu.service.UserService;
import com.huayu.utils.DictionaryHelper;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/pa")
public class ProjectAttenderAction extends BasicModelAction{

	private static final long serialVersionUID = 1L;
	private Long id ;
	private String name;
	
	private ProjectModel projectModel = new ProjectModel();
	
	private UserModel userModel = new UserModel();
	
	@Resource(name="projectAttenderService")
	private ProjectAttenderService service;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="resourcesService")
	private ResourcesService resService;
	
	/**
	 * apply for the project
	 * @return
	 */
	@Action(value="apply" , results={@Result(name=SUCCESS , type="velocity"  , location="/vm/addApplyerInfo.vm")})
	public String apply(){
		Map<String,Object> result = new HashMap<String , Object>();
		result.put("projectId", id);
		result.put("projectName",name);
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="join" , results={@Result(name=SUCCESS , type="json" )})
	public String join(){
		ProjectAttender project = new ProjectAttender();
		project.setAttenderId(getUserId());
		project.setProjectId(projectModel.getProjectId());
		project.setApplyDate(new Date());
		project.setRole(ProjectConst.RoleType.PARTICIPANT.getValue());
		project.setState(ProjectConst.ApplyerStatus.APPLYING.getValue());
		service.addSelective(project);
		
		User user = DigxyBoConverter.toUser(userModel);
		user.setId(getUserId());
		userService.updateByPrimaryKeySelective(user);
		
		return SUCCESS;
	}
	@Action(value="applyer" , results={@Result(name=SUCCESS , type="velocity"  , location="/vm/applyerInfo.vm")})
	public String applyer(){
		User user = userService.queryByPrimaryKey(userModel.getId());
		setData(DigxyBoConverter.toUserModel(user));
		return SUCCESS;
	}
	
	@Action(value="me" , results={@Result(name=SUCCESS , type="velocity" , location="/vm/myproject.vm" )})
	public String me(){
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("attenderId", getUserId());
		query.put("role", ProjectConst.RoleType.SPONSOR.getValue());
		
		Long count = service.queryProjectsCount(query);
		List<ProjectAttender> list = new ArrayList<ProjectAttender>();
		if(count > 0 ){
			query.putAll(getPagination().toMap());
			list = service.queryProjectsSub(query);
		}
		
		query.clear();
		query.put("count", count);
		query.put("list", list);
		query.put("resTypes", DictionaryHelper.getDictionaryByTypeCode(DictConst.RESOURCE_TYPE));
		query.put("projectStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_STATUS));
		query.put("projectRoles",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PREJECT_ATTENDER_ROLE_TYPE));
		query.put("projectAttenderStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_APPLYER_STATUS));
		
		setData(query);
		return SUCCESS;
	}
	
	@Action(value="attend" , results={@Result(name=SUCCESS , type="velocity" , location="/vm/myapplyproject.vm" )})
	public String attend(){
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("attenderId", getUserId());
		query.put("role", ProjectConst.RoleType.PARTICIPANT.getValue());
		
		Long count = service.queryProjectsCount(query);
		List<ProjectAttender> list = new ArrayList<ProjectAttender>();
		if(count > 0 ){
			query.putAll(getPagination().toMap());
			list = service.queryProjectsSub(query);
		}
		
		query.clear();
		query.put("count", count);
		query.put("list", list);
		query.put("resTypes", DictionaryHelper.getDictionaryByTypeCode(DictConst.RESOURCE_TYPE));
		query.put("projectStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_STATUS));
		query.put("projectRoles",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PREJECT_ATTENDER_ROLE_TYPE));
		query.put("projectAttenderStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_APPLYER_STATUS));
		
		setData(query);
		return SUCCESS;
	}
		@Action(value="m" , results={@Result(name=SUCCESS , type="velocity" , location="/vm/project_manager.vm" )})
	public String m(){
		hasManagerAuthority();
		
		Map<String , Object> query = new HashMap<String , Object>();
		Long count = service.queryProjectsCount(query);
		
		List<ProjectAttender> list = new ArrayList<ProjectAttender>();
		if(count > 0 ){
			query.putAll(getPagination().toMap());
			list = service.queryProjects(query);
		}
		
		query.clear();
		query.put("count", count);
		query.put("list", list);
		query.put("resTypes", DictionaryHelper.getDictionaryByTypeCode(DictConst.RESOURCE_TYPE));
		query.put("projectStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_STATUS));
		query.put("projectRoles",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PREJECT_ATTENDER_ROLE_TYPE));
		query.put("projectAttenderStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_APPLYER_STATUS));
		setData(query);
		return SUCCESS;
	}
	
	@Action(value="g" , results={@Result(name=SUCCESS , type="json")})
	public String get(){
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("resId", projectModel.getProjectId());
		List<ProjectAttender> list = service.queryProjectAttenders(query);
		setData(list);
		return SUCCESS;
	}
	
	@Action(value="verify" , results={@Result(name=SUCCESS , type="json")})
	public String verify(){
		ProjectAttender project = new ProjectAttender();
		project.setId(projectModel.getId());
		project.setState(projectModel.getStatus());
		project.setMsg(projectModel.getMsg());
		
		service.updateByPrimaryKeySelective(project);
		return SUCCESS;
	}
	
	@Action(value="update" , results={@Result(name=SUCCESS , type="json")})
	public String update(){
		Resources res = new Resources();
		res.setId(projectModel.getProjectId());
		res.setPstate(projectModel.getPstatus().intValue());
		
		resService.updateByPrimaryKeySelective(res);
		return SUCCESS;
	}
	
	

	public void setProjectModel(ProjectModel projectModel) {
		this.projectModel = projectModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public ProjectModel getProjectModel() {
		return projectModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
