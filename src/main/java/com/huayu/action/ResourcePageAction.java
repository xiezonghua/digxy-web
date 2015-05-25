package com.huayu.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Resources;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ResourcesService;

@Namespace("/res")
public class ResourcePageAction extends BasicModelAction {
	
	private static final long serialVersionUID = 1L;
	
	@Resource(name="resourcesService")
	private ResourcesService serivce;
	
	
	@Action(value="new" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/upload.vm")})
	public String add(){
		return SUCCESS;
	}
	
	@Action(value="passed" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/myupload.vm")})
	public String passed(){
		List<Resources> queryList  = serivce.queryResources(getUserId(), ResourceAuditStatusEnum.PASSED, getPagination());
		setData(queryList);
		return SUCCESS;
	}

	@Action(value="nopass" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mynopass.vm")})
	public String nopass(){
		List<Resources> queryList  = serivce.queryResources(getUserId(), ResourceAuditStatusEnum.NO_PASS, getPagination());
		setData(queryList);
		return SUCCESS;
	}
	
	@Action(value="pending" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mypending.vm")})
	public String pending(){
		List<Resources> queryList  = serivce.queryResources(getUserId(), ResourceAuditStatusEnum.PENDING, getPagination());
		setData(queryList);
		return SUCCESS;
	}
	
	@Action(value="downloaded" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mydownloaded.vm")})
	public String downloaded(){
		List<Resources> queryList = serivce.queryResourcesDownload(getUserId(), ResourceAuditStatusEnum.PASSED, getPagination());
		setData(queryList);
		return SUCCESS;
	}
	
	@Action(value="mydownload" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mydownload.vm")})
	public String download(){
		List<Resources> queryList = serivce.queryWhoDownload(getUserId(), getPagination());
		setData(queryList);
		return SUCCESS;
	}
	

	
	@Override
	public BasicModel getModel() {
		return getBasicModel();
	}

}
 