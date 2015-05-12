package com.huayu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Collection;
import com.huayu.model.CollectionModel;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.CollectionService;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/collecter")
public class CollecterAction extends BasicModelAction{
	private CollectionModel collecterModel;
	
	@Resource(name="collectionService")
	private CollectionService service ;
	
	@Action(value="my" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mycollection.vm")})
	public String collect(){
		List<Collection> queryList = service.queryCollection(getUserId(), getPagination());
		setData(queryList);
		return SUCCESS;
	}
	
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS)})
	public String delete(){
		service.delete(collecterModel.getId());
		return SUCCESS;
	}
	
	@Action(value="add" , results={@Result(type="json" , name=SUCCESS)})
	public String add(){
		Collection co = DigxyBoConverter.toCollection(collecterModel);
		co.setCollectionId(getUserId());
		co.setCollectioner(getUserName());
		co.setCollectiondate(new Date());
		
		service.add(co);
		return SUCCESS;
	}
	
	@Override
	public BasicModel getModel() {
		return getBasicModel();
	}


	public CollectionModel getCollecterModel() {
		return collecterModel;
	}


	public void setCollecterModel(CollectionModel collecterModel) {
		this.collecterModel = collecterModel;
	}

}
