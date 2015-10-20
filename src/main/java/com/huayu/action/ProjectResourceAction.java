package com.huayu.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huayu.bo.ProjectResource;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ProjectAttenderService;
import com.huayu.service.ProjectResourceService;

@Namespace("/pr")
public class ProjectResourceAction extends  BasicModelAction{

	private static final long serialVersionUID = 1L;

	private final static Logger logger = LoggerFactory.getLogger( ProjectResourceAction.class.getCanonicalName());
	
	private ProjectResource resource ;

	@Resource(name="projectResourceService")
	private ProjectResourceService service;
	
	@Resource(name="projectAttenderService")
	private ProjectAttenderService attenderService ;
	
	@Action(value="add" , results={@Result(type="json" , name=SUCCESS)})
	public String add(){
//		attenderService.isAttender(resource.getProjectId(), getUserId());
	
		resource.setUploader(getUserId());
		service.addOne(resource);
		return SUCCESS;
	}
	
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS)})
	public String del(){
		service.delete(resource.getId());
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(type="json" , name=SUCCESS)})
	public String get(){
		return SUCCESS;
	}
	
	@Action(value="list" , results={@Result(type="json" , name=SUCCESS)})
	public String list(){
		List<ProjectResource> result = service.query(resource);
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="audit" , results={@Result(type="json" , name=SUCCESS)})
	public String audit(){
		hasManagerAuthority();
		
		if(null == resource.getId() || resource.getStatus() == null){
			setValidateInfo("Audit failure!");
			logger.error("Audit failure , the  auditor is {}_{} , because id={} , status={}" ,getUserId() , getUserName() , resource.getId() , resource.getStatus());
		}
		service.updateByPrimaryKeySelective(resource);
		return SUCCESS;
	}
	
	public ProjectResource getResource() {
		return resource;
	}

	public void setResource(ProjectResource resource) {
		this.resource = resource;
	}
	
}
