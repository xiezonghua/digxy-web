package com.huayu.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Keyword;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.KeywordService;

@Namespace("/key")
public class KeywordAction extends BasicModelAction{

	private static final long serialVersionUID = 1L;
		
	@Resource(name="keywordService")
	private KeywordService service;
	
	private Keyword keywordModel = new Keyword();

	@Action(value="m" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/keyword_manager.vm" )})
	public String manager(){
		List<Keyword> list = service.queryAll();
		setData(list);
		return SUCCESS;
	}
	
	@Action(value="list" , results={@Result(type="json" , name=SUCCESS )})
	public String list(){
		List<Keyword> list = service.queryAll();
		setData(list);
		return SUCCESS;
	}

	@Action(value="add" , results={@Result(type="json" , name=SUCCESS )})
	public String add(){
		hasManagerAuthority();
		service.addSelective(keywordModel);
		return SUCCESS;
	}

	@Action(value="update" , results={@Result(type="json" , name=SUCCESS )})
	public String update(){
		hasManagerAuthority();
		service.updateByPrimaryKeySelective(keywordModel);
		return SUCCESS;
	}
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS )})
	public String del(){
		hasManagerAuthority();
		service.delete(keywordModel.getId());
		return SUCCESS;
	}
	

	@Action(value="get" , results={@Result(type="json" , name=SUCCESS )})
	public String get(){
		hasManagerAuthority();
		Keyword word = service.queryByPrimaryKey(keywordModel.getId());
		setData(word);
		return SUCCESS;
	}

	public Keyword getKeywordModel() {
		return keywordModel;
	}

	public void setKeywordModel(Keyword keywordModel) {
		this.keywordModel = keywordModel;
	}
	
}
