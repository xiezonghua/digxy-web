package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Project;
import com.huayu.platform.db.DBBasicDao;

public interface ProjectDao extends DBBasicDao<Project, Long> {
	 List<Project> selectProjectAttenders(Map<String , Object> query);
	 
	 List<Project> selectProjects(Map<String ,Object> query);
	 
	 Long selectProjectsCount(Map<String, Object> query);
	 
	 List<Project> selectProjectsSub(Map<String, Object> query);
}
