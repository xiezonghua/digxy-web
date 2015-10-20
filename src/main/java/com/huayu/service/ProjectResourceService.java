package com.huayu.service;

import java.util.List;
import java.util.Map;

import com.huayu.bo.ProjectResource;
import com.huayu.platform.service.BasicService;

public interface ProjectResourceService extends BasicService<ProjectResource, Long> {
	
	void addOne(ProjectResource pResource);
	
	List<ProjectResource> queryList(Map<String , Object> query);
	
	Long queryListCount(Map<String , Object> query);
}