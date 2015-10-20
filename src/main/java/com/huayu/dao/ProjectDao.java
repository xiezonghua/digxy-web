package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Project;
import com.huayu.platform.db.DBBasicDao;

public interface ProjectDao extends DBBasicDao<Project, Long> {
	List<Project> selectList(Map<String, Object> query);

	List<Project> selectDetailList(Map<String , Object> query);
	
	long selectListCount(Map<String, Object> query);
}