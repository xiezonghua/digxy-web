package com.huayu.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Yqlink;
import com.huayu.model.LinkModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.YqlinkService;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/link")
public class LinkAction extends BasicModelAction {

	private static final long serialVersionUID = 1L;
	private LinkModel linkModel;
	
	@Resource(name="yqlinkService")
	private YqlinkService service ;
	
	@Action(value="index" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mylink.vm")})
	public String index(){
		setData(service.queryAll());
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(type="json" , name=SUCCESS)})
	public String get(){
		Yqlink link = service.queryByPrimaryKey(linkModel.getId());
		setData(DigxyBoConverter.toLinkModel(link));
		return SUCCESS;
	}

	@Action(value="add" , results={@Result(type="json" , name=SUCCESS)})
	public String add(){
		service.addSelective(DigxyBoConverter.toLink(linkModel));
		return SUCCESS;
	}
		
	@Action(value="update" , results={@Result(type="json" , name=SUCCESS)})
	public String update(){
		service.updateByPrimaryKeySelective(DigxyBoConverter.toLink(linkModel));
		return SUCCESS;
	}
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS)})
	public String del(){
		service.delete(linkModel.getId());
		return SUCCESS;
	}
	
	public LinkModel getLinkModel() {
		return linkModel;
	}

	public void setLinkModel(LinkModel linkModel) {
		this.linkModel = linkModel;
	}


}
