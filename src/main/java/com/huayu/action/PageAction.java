package com.huayu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Resources;
import com.huayu.bo.Share;
import com.huayu.bo.Yqlink;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.constant.ResourceTypeEnum;
import com.huayu.platform.Pagination;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ResourcesService;
import com.huayu.service.ShareService;
import com.huayu.service.YqlinkService;

@Namespace("/")
public class PageAction extends BasicModelAction {
	private Long id ;
	
	private String searchKey;
	
	private Byte type;
	
	private Byte[] resType;
	
	private static final long serialVersionUID = 1L;

	@Resource(name = "resourcesService")
	private ResourcesService service;

	@Resource(name="yqlinkService")
	private YqlinkService linkService;
	
	@Resource(name="shareService")
	private ShareService sharedService;
	
	
	
	@Action(value="index" , results = { @Result(type = "velocity", location = "/vm/index.vm") })
	@Override
	public String execute() throws Exception {
		Pagination pageInfo = new Pagination();
		pageInfo.setOffset(5);
		pageInfo.setOrderBy("clickTimes");
		
		List<Resources> resHots = service.queryResources(pageInfo , null);
		List<Resources> resStudys = service.queryResources(pageInfo, ResourceTypeEnum.STUDY.getCode());
		List<Resources> resResearchs = service.queryResources(pageInfo, ResourceTypeEnum.RESEARCH.getCode());
		List<Resources> resGrowers = service.queryResources(pageInfo, ResourceTypeEnum.GROWER.getCode());

		List<Yqlink> links = linkService.queryAll();
		
		Map<String , Object> result = new HashMap<String , Object>(3);
		result.put("hots", resHots);
		result.put("studys", resStudys);
		result.put("researchs", resResearchs);
		result.put("growers", resGrowers);
		
		result.put("links", links);
		
		setData(result);
		return SUCCESS;
	}

	@Action(value = "result", results = { @Result(type = "velocity", location = "/vm/result.vm") })
	public String result() {
		Resources res = service.queryByPrimaryKey(id);
		
		Pagination pageInfo = getPagination();
		pageInfo.setOffset(5);
		pageInfo.setOrderBy("clickTimes");
		pageInfo.setExpectIds(getId().toString());
		List<Resources> relationHots = service.queryResources(pageInfo , res.getRestype());
		List<Share> sharedHots = sharedService.queryShared(getUserId());
		List<Resources> uploaderHots = service.queryResources(getUserId(), ResourceAuditStatusEnum.PASSED, pageInfo);
		
		Map<String , Object> result = new HashMap<String , Object>(3);
		result.put("sharedHots",  sharedHots );
		result.put("relationHots", relationHots );
		result.put("uploaderHots", uploaderHots );	
		result.put("res", res);
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value = "search", results = { @Result(type = "velocity", location = "/vm/page.vm") })
	public String search(){
		Long count = service.queryResourcesCount(getSearchKey(), null, getResType(), ResourceAuditStatusEnum.PASSED);
		List<Resources> searchs= new ArrayList<Resources>();
		if(count > 0){
			searchs= service.queryResources(getSearchKey(), getResType(), getPagination());
		}
		
		Map<String , Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("results", searchs);
		setData(result);
		return SUCCESS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte[] getResType() {
		return resType;
	}

	public void setResType(Byte[] resType) {
		this.resType = resType;
	}
	
}
