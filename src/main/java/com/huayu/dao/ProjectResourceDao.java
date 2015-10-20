package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.ProjectResource;
import com.huayu.platform.db.DBBasicDao;

public interface ProjectResourceDao extends DBBasicDao<ProjectResource, Long> {
	List<ProjectResource> selectList(Map<String , Object> query);
	
	Long selectListCount(Map<String , Object> query);
}