package com.huayu.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.System;
import com.huayu.model.HelperModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.SystemService;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/helper")
public class HelperAction extends BasicModelAction{
	
	private static final long serialVersionUID = 1L;
	
	private HelperModel helperModel;
	
	@Resource(name="systemService")
	private SystemService service;
	
	@Action(value="resume" , results={@Result(type="velocity" , location="/vm/myhelper.vm")})
	public String resume(){
		System sys = getData();
		Map<String , Object> data = new HashMap<String , Object>();
		data.put("id", sys.getId());
		data.put("dataType", "resume");
		data.put("content", sys.getAboutmy());
		
		setData(data);
		return SUCCESS;
	}
	
	
	
	@Action(value="docLaw" , results={@Result(type="velocity" , location="/vm/myhelper.vm")})
	public String docLaw(){
		System sys = getData();
		Map<String , Object> data = new HashMap<String , Object>();
		data.put("id", sys.getId());
		data.put("dataType", "docLaw");
		data.put("content", sys.getDocupload());
		
		setData(data);
		return SUCCESS;
	}
	
	@Action(value="contact" , results={@Result(type="velocity" , location="/vm/myhelper.vm")})
	public String contact(){
		System sys = getData();
		Map<String , Object> data = new HashMap<String , Object>();
		data.put("id", sys.getId());
		data.put("dataType", "contact");
		data.put("content", sys.getLxwm());
		
		setData(data);
		return SUCCESS;
	}
	
	@Action(value="userLaw" , results={@Result(type="velocity" , location="/vm/myhelper.vm")})
	public String userLaw(){
		System sys = getData();
		Map<String , Object> data = new HashMap<String , Object>();
		data.put("id", sys.getId());
		data.put("dataType", "userLaw");
		data.put("content", sys.getHyzc());
		
		setData(data);
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(type="json" , name=SUCCESS)})
	public String get(){
		System sys = new System();
		List<System> sysList = service.queryAll();
		if(sysList.size() > 0){
			sys = sysList.get(0);
		}
		
		HelperModel model = new HelperModel();
		if(helperModel.getHelperType().equals("resume")){
			model.setResume(sys.getAboutmy());
		}else if(helperModel.getHelperType().equals("docLaw")){
			model.setDocLaw(sys.getDocupload());
		}else if(helperModel.getHelperType().equals("userLaw")){
			model.setUserLaw(sys.getHyzc());
		}else if(helperModel.getHelperType().equals("contact")){
			model.setContactInfo(sys.getLxwm());
		}
		
		setData(model);
		return SUCCESS;
	}
	
	private System getData(){
		System sys = new System();
		List<System> sysList = service.queryAll();
		if(sysList.size() > 0){
			sys = sysList.get(0);
		}else{
			sys.setLxwm("");
			service.addSelective(sys);
		}
		return sys;
	}
	
	@Action(value="update" , results={@Result(type="json" , name=SUCCESS)})
	public String update(){
		service.updateByPrimaryKeySelective(DigxyBoConverter.toSystem(helperModel));
		return SUCCESS;
	}


	public HelperModel getHelperModel() {
		return helperModel;
	}


	public void setHelperModel(HelperModel helperModel) {
		this.helperModel = helperModel;
	}
	
	
	
}
