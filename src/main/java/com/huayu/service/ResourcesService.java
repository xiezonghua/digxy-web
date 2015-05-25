package com.huayu.service;

import java.util.List;

import com.huayu.bo.Resources;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.platform.Pagination;
import com.huayu.platform.service.BasicService;

public interface ResourcesService extends BasicService<Resources, Long> {
	
	public List<Resources> queryResources(String queryCondition ,Byte[] includeTypes, Pagination pageInfo);
	
	public List<Resources> queryResources(Long userId , ResourceAuditStatusEnum resStaus , Pagination pageInfo);
	
	public List<Resources> queryResources( Pagination pageInfo , Byte resType );
	
	public List<Resources> queryResourcesDownload(Long userId , ResourceAuditStatusEnum resStaus , Pagination pageInfo);
	
	public List<Resources> queryWhoDownload(Long userId , Pagination pageInfo );
	
	public List<Resources> queryWhoCollect(Long collecterId , Pagination pageInfo);
	
	public Long queryResourcesCount(String queryCondition , Long userId , Byte resType ,  ResourceAuditStatusEnum auditStatus);
	
	public Long queryResourcesCount(String queryCondition , Long userId , Byte[] includeTypes,  ResourceAuditStatusEnum auditStatus);
}