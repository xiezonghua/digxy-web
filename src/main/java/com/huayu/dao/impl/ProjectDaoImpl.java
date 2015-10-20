package com.huayu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Project;
import com.huayu.dao.ProjectDao;
import com.huayu.dao.mapper.ProjectMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("projectDao")
public class ProjectDaoImpl extends AbstractDBBasicDao<Project , Long> implements ProjectDao{
	@Autowired
	private ProjectMapper projectMapper ;

	@Override
	public DaoMapper<Project, Long> getDaoMapper() {		
		return projectMapper;
	}

	@Override
	public List<Project> selectList(Map<String, Object> query) {
		return projectMapper.selectList(query);
	}

	@Override
	public long selectListCount(Map<String, Object> query) {
		return projectMapper.selectListCount(query);
	}

	@Override
	public List<Project> selectDetailList(Map<String, Object> query) {
		return projectMapper.selectDetailList(query);
	}
}
