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
	public List<Project> selectProjectAttenders(Map<String, Object> query) {
		return projectMapper.selectProjectAttenders(query);
	}

	@Override
	public List<Project> selectProjects(Map<String, Object> query) {
		return projectMapper.selectProjects(query);
	}

	@Override
	public Long selectProjectsCount(Map<String, Object> query) {
		return projectMapper.selectProjectsCount(query);
	}

	@Override
	public List<Project> selectProjectsSub(Map<String, Object> query) {
		return projectMapper.selectProjectsSub(query);
	}
}
