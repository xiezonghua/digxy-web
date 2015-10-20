package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.platform.db.DaoMapper;
import com.huayu.bo.ProjectResource;

public interface ProjectResourceMapper extends DaoMapper<ProjectResource , Long>{
	List<ProjectResource> selectList(Map<String , Object> query);
	
	Long selectListCount(Map<String , Object> query);	
}