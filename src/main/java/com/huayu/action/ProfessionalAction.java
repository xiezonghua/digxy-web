package com.huayu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Expert;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ExpertService;
import com.huayu.utils.ExpertHelper;

@Namespace("/expert")
public class ProfessionalAction extends BasicModelAction{
	
	private static final long serialVersionUID = 1L;
	
	@Resource(name="expertService")
	private ExpertService service;
	
	private Expert expertModel = new Expert();

	@Action(value="m" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/expert_manager.vm" )})
	public String manager(){
		List<Expert> list = service.queryAll();
		setData(list);
		return SUCCESS;
	}
	
	@Action(value="list" , results={@Result(type="json" , name=SUCCESS )})
	public String list(){
		List<Expert> list = service.queryAll();
		setData(list);
		return SUCCESS;
	}

	@Action(value="add" , results={@Result(type="json" , name=SUCCESS )})
	public String add(){
		hasManagerAuthority();
		expertModel.setAddDate(new Date());
		service.addSelective(expertModel);
		
		List<Expert> data = service.queryAll();
		ExpertHelper.load(data);
		return SUCCESS;
	}

	@Action(value="update" , results={@Result(type="json" , name=SUCCESS )})
	public String update(){
		hasManagerAuthority();
		service.updateByPrimaryKeySelective(expertModel);
		
		List<Expert> data = service.queryAll();
		ExpertHelper.load(data);
		return SUCCESS;
	}
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS )})
	public String del(){
		hasManagerAuthority();
		service.delete(expertModel.getId());
		
		List<Expert> data = service.queryAll();
		ExpertHelper.load(data);
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(type="json" , name=SUCCESS )})
	public String get(){
		hasManagerAuthority();
		Expert expert = service.queryByPrimaryKey(expertModel.getId());
		setData(expert);
		return SUCCESS;
	}

	public void setExpertModel(Expert expertModel) {
		this.expertModel = expertModel;
	}

	public Expert getExpertModel() {
		return expertModel;
	}
	
	
}
