package com.huayu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.Resources;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.dao.ResourcesDao;
import com.huayu.platform.Pagination;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.ResourcesService;

@Service("resourcesService")
public class ResourcesServiceImpl extends AbstractBasicService<Resources , Long> implements ResourcesService{

	private final static Logger logger = LoggerFactory.getLogger(ResourcesServiceImpl.class.getCanonicalName());

	@Resource
	private ResourcesDao resourcesDao ;

	@Override
	public DBBasicDao<Resources, Long> getDao() {		
		return resourcesDao;
	}

	@Override
	public List<Resources> queryResources(String queryCondition,
			Pagination pageInfo) {
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("queryCondition", queryCondition);
		query.put("resStauts", ResourceAuditStatusEnum.PASSED.getValue());
		query.putAll(pageInfo.toMap());
		
		List<Resources> queryList = resourcesDao.selectResources(query) ; 
		return queryList ;
	}

	@Override
	public List<Resources> queryResources(Long userId,
			ResourceAuditStatusEnum resStaus,  Pagination pageInfo) {
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("uploaderid", userId);
		query.put("resStatus", resStaus.getValue());
		query.putAll(pageInfo.toMap());
		
		List<Resources> queryList =  resourcesDao.selectResources(query) ; 
		return queryList;
	}
	
	@Override
	public List<Resources> queryResourcesDownload(Long userId,
			ResourceAuditStatusEnum resStaus,  Pagination pageInfo) {
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("uploaderid", userId);
		query.put("resStatus", resStaus.getValue());
		query.put("isDownLoad" , true);
		query.putAll(pageInfo.toMap());
		
		List<Resources> queryList =  resourcesDao.selectResources(query) ; 
		return queryList;
	}

}
