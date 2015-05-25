package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Resources;
import com.huayu.platform.db.DBBasicDao;

public interface ResourcesDao extends DBBasicDao<Resources, Long> {
	
	List<Resources> selectResources(Map<String, Object> query);
	
	List<Resources> selectWhoDownload(Map<String , Object> query);
	
	List<Resources> selectWhoCollect(Map<String, Object> query);
	
	Long selectResourcesCount(Map<String, Object> query);
}