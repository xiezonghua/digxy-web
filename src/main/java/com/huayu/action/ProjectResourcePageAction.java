package com.huayu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.ProjectResource;
import com.huayu.constant.DictConst;
import com.huayu.platform.Pagination;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ProjectResourceService;
import com.huayu.utils.DictionaryHelper;

@Namespace("/pr")
public class ProjectResourcePageAction extends BasicModelAction {

	private static final long serialVersionUID = 1L;
	
	//project Id
	private Long id ;
	//project name
	private String name;
	
	private String searchKey;
	private String status;
	
	@Resource(name="projectResourceService")
	private ProjectResourceService service;
	
	@Action(value="new" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/project_resource_upload.vm")})
	public String add(){
		Map<String,Object> result = new HashMap<String , Object>();
		result.put("projectId", id);
		result.put("projectName",name);
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="manage" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/project_resource_manager.vm")})
	public String manage(){
		hasManagerAuthority();
		Map<String , Object> query = new HashMap<String , Object>();
		if(StringUtils.isNotBlank(searchKey)){
			query.put("queryCondition", searchKey);
		}
		query.put("stauts", status );
		query.put("projectId", id);
		
		queryResourceList(query);
		return SUCCESS;
	}
	
	
	@Action(value="me" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/project_resource_me.vm")})
	public String me(){
		
		Map<String , Object> query = new HashMap<String , Object>();
		if(StringUtils.isNotBlank(searchKey)){
			query.put("queryCondition", searchKey);
		}
		query.put("stauts", status );
		query.put("projectId", id);
		query.put("uploader", getUserId());
		
		queryResourceList(query);
		return SUCCESS;
	}

	private void queryResourceList(Map<String, Object> query) {
		Long count = service.queryListCount(query);
		
		List<ProjectResource> queryList = new ArrayList<ProjectResource>();
		if(count > 0){
			Pagination pageInfo = getPagination();
			pageInfo.setOrderBy("uploadDate");	
			query.putAll(pageInfo.toMap());
			queryList = service.queryList(query);
		}
		
		Map<String , Object> result = new HashMap<String,Object>();
		result.put("count", count);
		result.put("list", queryList);
		
		result.put("auditStatus", DictionaryHelper.getDictionaryByTypeCode(DictConst.RESOURCE_AUDIT_STATUS));
		result.put("resTypes", DictionaryHelper.getDictionaryByTypeCode(DictConst.RESOURCE_TYPE));
		
		setData(result);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
}
