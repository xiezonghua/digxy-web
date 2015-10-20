package com.huayu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.ProjectAttender;
import com.huayu.constant.ProjectConst;
import com.huayu.dao.ProjectAttenderDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.exception.ServiceRuntimeException;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.ProjectAttenderService;

@Service("projectAttenderService")
public class ProjectAttenderServiceImpl extends AbstractBasicService<ProjectAttender , Long> implements ProjectAttenderService{

	private final static Logger logger = LoggerFactory.getLogger(ProjectAttenderServiceImpl.class.getCanonicalName());

	@Resource
	private ProjectAttenderDao projectAttenderDao ;

	@Override
	public DBBasicDao<ProjectAttender, Long> getDao() {		
		return projectAttenderDao;
	}
	
	@Override
	public List<ProjectAttender> queryProjectAttenders(Map<String, Object> query) {
		return projectAttenderDao.selectProjectAttenders(query);
	}

	@Override
	public List<ProjectAttender> queryProjects(Map<String, Object> query) {
		return projectAttenderDao.selectProjects(query);
	}

	@Override
	public Long queryProjectsCount(Map<String, Object> query) {
		return projectAttenderDao.selectProjectsCount(query);
	}

	@Override
	public List<ProjectAttender> queryProjectsSub(Map<String, Object> query) {
		return projectAttenderDao.selectProjectsSub(query);
	}

	@Override
	public void isAttender(Long projectId, Long userId) {
		ProjectAttender obj = new ProjectAttender();
		obj.setProjectId(projectId);
		obj.setAttenderId(userId);
		obj.setState(ProjectConst.ApplyerStatus.PARTICIPATING.getValue());
		List<ProjectAttender> attends = projectAttenderDao.query(obj);		
		if(attends.size() != 1 ){
			logger.info("the user {} is not attend in project {}" , userId , projectId);
			throw new ServiceRuntimeException("您还不是参与者，不能上传文档");
		}
	}
}
