package com.huayu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Resources;
import com.huayu.model.ResourceModel;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ResourcesService;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/res")
public class ResourceAction extends BasicModelAction {
	
	private static final long serialVersionUID = 1L;
	private ResourceModel  resModel = new ResourceModel();
	
	@Resource(name="resourcesService")
	private ResourcesService serivce;
	
	@Action(value="new" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/upload.vm")})
	public String index(){
		return SUCCESS;
	}
	
	@Action(value="add" , results={@Result(type="json" , name=SUCCESS)})
	public String add(){
		Resources res = DigxyBoConverter.toResources(resModel);
		res.setUploaderid(getUserId());
		res.setUploaddate(new Date());
		res.setResstatus((byte)1);//wait for judgement.
		serivce.addSelective(res);
		return SUCCESS;
	}
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS)})
	public String del(){
		serivce.delete(resModel.getId());
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(type="json" , name=SUCCESS)})
	public String get(){
		return SUCCESS;
	}
	
	@Action(value="list" , results={@Result(type="json" , name=SUCCESS)})
	public String list(){
		Resources res = DigxyBoConverter.toResources(resModel);
		List<Resources> result = serivce.query(res);
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="list.slef" , results={@Result(type="json" , name=SUCCESS)})
	public String slef(){
		Resources res = new Resources();
		res.setUploaderid(getUserId());
		res.setResstatus(resModel.getResStatus());
		List<Resources> result = serivce.query(res);
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="list.downloads" , results={@Result(type="json" , name=SUCCESS)})
	public String downloads(){
		Resources res = new Resources();
		res.setUploaderid(getUserId());
		res.setResstatus(resModel.getResStatus());
		List<Resources> result = serivce.query(res);
		setData(result);
		return SUCCESS;		
	}
	
	
	@Override
	public BasicModel getModel() {
		return getBasicModel();
	}

	public ResourceModel getResModel() {
		return resModel;
	}

	public void setResModel(ResourceModel resModel) {
		this.resModel = resModel;
	}

	
}
