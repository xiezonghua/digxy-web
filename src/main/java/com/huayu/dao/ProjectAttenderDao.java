package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.ProjectAttender;
import com.huayu.platform.db.DBBasicDao;

public interface ProjectAttenderDao extends DBBasicDao<ProjectAttender, Long> {
	 List<ProjectAttender> selectProjectAttenders(Map<String , Object> query);
	 
	 List<ProjectAttender> selectProjects(Map<String ,Object> query);
	 
	 Long selectProjectsCount(Map<String, Object> query);
	 
	 List<ProjectAttender> selectProjectsSub(Map<String, Object> query);
}