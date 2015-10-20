package com.huayu.service;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Project;
import com.huayu.platform.service.BasicService;

public interface ProjectService extends BasicService<Project, Long> {
	void addOne(Project project);
	
	/**
	 * query list
	 * @param query
	 * @return
	 */
	List<Project> queryList(Map<String, Object> query);
	
	/**
	 * query list count
	 * @param query
	 * @return
	 */
	Long queryListCount(Map<String , Object> query);
	
	/**
	 * query detail list
	 * @param query
	 * @return
	 */
	List<Project> queryDetailList(Map<String, Object> query);
	
}