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

import com.huayu.bo.Resources;
import com.huayu.constant.DictConst;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.platform.Pagination;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ResourcesService;
import com.huayu.utils.DictionaryHelper;

@Namespace("/res")
public class ResourcePageAction extends BasicModelAction {
	
	private static final long serialVersionUID = 1L;

	private String searchKey;
	
	private Byte resStatus;
	
	private Byte[] resType;
	
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
	
	@Action(value="manage" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/resourcemanager.vm")})
	public String manage(){
		hasManagerAuthority();
		Map<String , Object> query = new HashMap<String , Object>();
		if(StringUtils.isNotBlank(searchKey)){
			query.put("queryCondition", searchKey);
		}
		query.put("resStauts", resStatus );
		query.put("includeTypes", getResType());
		
		Long count = serivce.queryResourcesCount(query);
		
		List<Resources> queryList = new ArrayList<Resources>();
		if(count > 0){
			Pagination pageInfo = getPagination();
			pageInfo.setOrderBy("uploadDate");	
			query.putAll(pageInfo.toMap());
			queryList = serivce.queryResources(query);
		}
		
		Map<String , Object> result = new HashMap<String,Object>();
		result.put("count", count);
		result.put("list", queryList);
		
		result.put("auditStatus", DictionaryHelper.getDictionaryByTypeCode(DictConst.RESOURCE_AUDIT_STATUS));
		
		result.put("resTypes", DictionaryHelper.getDictionaryByTypeCode(DictConst.RESOURCE_TYPE));
		
		
		setData(result);
		return SUCCESS;
	}
	

	
	@Override
	public BasicModel getModel() {
		return getBasicModel();
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Byte[] getResType() {
		return resType;
	}

	public void setResType(Byte[] resType) {
		this.resType = resType;
	}

	public Byte getResStatus() {
		return resStatus;
	}

	public void setResStatus(Byte resStatus) {
		this.resStatus = resStatus;
	}
	
}
 