package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Project;
import com.huayu.platform.db.DaoMapper;

public interface ProjectMapper extends DaoMapper<Project , Long>{
	 List<Project> selectList(Map<String , Object> query);
	 
	 long selectListCount(Map<String , Object> query);
	 
	 List<Project> selectDetailList(Map<String , Object> query);
	
}