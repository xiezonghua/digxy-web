package com.huayu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.huayu.bo.Project;
import com.huayu.dao.ProjectDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.ProjectService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("projectService")
public class ProjectServiceImpl extends AbstractBasicService<Project , Long> implements ProjectService{

	private final static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class.getCanonicalName());

	@Resource
	private ProjectDao projectDao ;

	@Override
	public DBBasicDao<Project, Long> getDao() {		
		return projectDao;
	}

	@Override
	public List<Project> queryProjectAttenders(Map<String, Object> query) {
		return projectDao.selectProjectAttenders(query);
	}

	@Override
	public List<Project> queryProjects(Map<String, Object> query) {
		return projectDao.selectProjects(query);
	}

	@Override
	public Long queryProjectsCount(Map<String, Object> query) {
		return projectDao.selectProjectsCount(query);
	}

	@Override
	public List<Project> queryProjectsSub(Map<String, Object> query) {
		return projectDao.selectProjectsSub(query);
	}
}
