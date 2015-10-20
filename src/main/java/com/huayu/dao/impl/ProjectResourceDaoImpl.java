package com.huayu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.ProjectResource;
import com.huayu.dao.ProjectResourceDao;
import com.huayu.dao.mapper.ProjectResourceMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("projectResourceDao")
public class ProjectResourceDaoImpl extends AbstractDBBasicDao<ProjectResource , Long> implements ProjectResourceDao{
	@Autowired
	private ProjectResourceMapper projectResourceMapper ;

	@Override
	public DaoMapper<ProjectResource, Long> getDaoMapper() {		
		return projectResourceMapper;
	}

	@Override
	public List<ProjectResource> selectList(Map<String, Object> query) {
		return projectResourceMapper.selectList(query);
	}

	@Override
	public Long selectListCount(Map<String, Object> query) {
		return projectResourceMapper.selectListCount(query);
	}
}
