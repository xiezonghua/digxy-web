package com.huayu.service;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Project;
import com.huayu.platform.service.BasicService;

public interface ProjectService extends BasicService<Project, Long> {
	
	 List<Project> queryProjectAttenders(Map<String , Object> query);
	 
	 List<Project> queryProjects(Map<String ,Object> query);
	 
	 Long queryProjectsCount(Map<String, Object> query);
	 
	 List<Project> queryProjectsSub(Map<String, Object> query);
}