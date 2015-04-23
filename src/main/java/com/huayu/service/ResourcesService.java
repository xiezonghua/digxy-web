package com.huayu.service;

import java.util.List;

import com.huayu.bo.Resources;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.platform.Pagination;
import com.huayu.platform.service.BasicService;

public interface ResourcesService extends BasicService<Resources, Long> {
	
	public List<Resources> queryResources(String resouceName , Pagination pageInfo);
	
	public List<Resources> queryResources(Long userId , ResourceAuditStatusEnum resStaus , Pagination pageInfo);
	
	public List<Resources> queryResourcesDownload(Long userId , ResourceAuditStatusEnum resStaus , Pagination pageInfo);
	
}