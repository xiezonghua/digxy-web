package com.huayu.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.model.AttentiveModel;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.GuanzhuService;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/attentive")
public class AttentiveAction  extends BasicModelAction{
	
	private static final long serialVersionUID = 1L;

	private AttentiveModel attentiveModel;

	@Resource(name="guanzhuService")
	private GuanzhuService service ;
	
	@Action(value="add" , results={@Result(name=SUCCESS , type="json")})
	public String add(){
		if(attentiveModel.getFollowerId() == null){
			setStautsInfo("attentive add failure! because followerId is null");
			return SUCCESS;
		}
		
		service.add(DigxyBoConverter.toGuanzhu(attentiveModel));
		
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(name=SUCCESS , type="velocity" , location="vm/attentive.vm")})
	public String get(){
		
		return SUCCESS;
	}
	
	@Override
	public BasicModel getModel() {
		return getBasicModel();
	}
	
}
