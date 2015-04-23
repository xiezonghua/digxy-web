package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Resources;
import com.huayu.platform.db.DBBasicDao;

public interface ResourcesDao extends DBBasicDao<Resources, Long> {
	
	List<Resources> selectResources(Map<String, Object> query);
	
	List<Resources> selectResourcesDownload(Map<String , Object> query);
}