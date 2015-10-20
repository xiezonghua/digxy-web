package com.huayu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.ProjectAttender;
import com.huayu.dao.ProjectAttenderDao;
import com.huayu.dao.mapper.ProjectAttenderMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("projectAttenderDao")
public class ProjectAttenderDaoImpl extends AbstractDBBasicDao<ProjectAttender , Long> implements ProjectAttenderDao{
	@Autowired
	private ProjectAttenderMapper projectAttenderMapper ;

	@Override
	public DaoMapper<ProjectAttender, Long> getDaoMapper() {		
		return projectAttenderMapper;
	}
	
	@Override
	public List<ProjectAttender> selectProjectAttenders(Map<String, Object> query) {
		return projectAttenderMapper.selectProjectAttenders(query);
	}

	@Override
	public List<ProjectAttender> selectProjects(Map<String, Object> query) {
		return projectAttenderMapper.selectProjects(query);
	}

	@Override
	public Long selectProjectsCount(Map<String, Object> query) {
		return projectAttenderMapper.selectProjectsCount(query);
	}

	@Override
	public List<ProjectAttender> selectProjectsSub(Map<String, Object> query) {
		return projectAttenderMapper.selectProjectsSub(query);
	}
}
