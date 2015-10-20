package com.huayu.service;

import java.util.List;
import java.util.Map;

import com.huayu.bo.ProjectAttender;
import com.huayu.platform.service.BasicService;

public interface ProjectAttenderService extends BasicService<ProjectAttender, Long> {
	 List<ProjectAttender> queryProjectAttenders(Map<String , Object> query);
	 
	 List<ProjectAttender> queryProjects(Map<String ,Object> query);
	 
	 Long queryProjectsCount(Map<String, Object> query);
	 
	 List<ProjectAttender> queryProjectsSub(Map<String, Object> query);
	 
	 void isAttender(Long projectId , Long userId);
}