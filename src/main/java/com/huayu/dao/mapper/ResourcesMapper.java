package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Resources;
import com.huayu.platform.db.DaoMapper;

public interface ResourcesMapper extends DaoMapper<Resources , Long>{
	
	List<Resources> selectResources(Map<String, Object> query);
	
	List<Resources> selectResourcesDownload(Map<String , Object> query);
}