package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Project;
import com.huayu.platform.db.DaoMapper;

public interface ProjectMapper extends DaoMapper<Project , Long>{
	 List<Project> selectProjectAttenders(Map<String , Object> query);
	 
	 List<Project> selectProjects(Map<String ,Object> query);
	
	 Long selectProjectsCount(Map<String, Object> query);
	 
	 List<Project> selectProjectsSub(Map<String, Object> query);
}
