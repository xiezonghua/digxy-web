package com.huayu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Notification;
import com.huayu.dao.NotificationDao;
import com.huayu.dao.mapper.NotificationMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("notificationDao")
public class NotificationDaoImpl extends AbstractDBBasicDao<Notification , Long> implements NotificationDao{
	@Autowired
	private NotificationMapper notificationMapper ;

	@Override
	public DaoMapper<Notification, Long> getDaoMapper() {		
		return notificationMapper;
	}

	@Override
	public List<Notification> selectList(Map<String, Object> query) {
		
		return notificationMapper.selectList(query);
	}

	@Override
	public Long selectListCount(Map<String, Object> query) {
		
		return notificationMapper.selectListCount(query);
	}

	@Override
	public int updateSection(Map<String, Object> param) {
		return notificationMapper.updateSection(param);
	}
}
