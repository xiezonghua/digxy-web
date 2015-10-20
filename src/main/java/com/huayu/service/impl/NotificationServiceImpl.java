package com.huayu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.Notification;
import com.huayu.dao.NotificationDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.NotificationService;

@Service("notificationService")
public class NotificationServiceImpl extends AbstractBasicService<Notification , Long> implements NotificationService{

	private final static Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class.getCanonicalName());

	@Resource
	private NotificationDao notificationDao ;

	@Override
	public DBBasicDao<Notification, Long> getDao() {		
		return notificationDao;
	}

	@Override
	public List<Notification> queryList(Map<String, Object> query) {
		return notificationDao.selectList(query);
	}

	@Override
	public Long queryListCount(Map<String, Object> query) {
		return notificationDao.selectListCount(query) ;
	}

	@Override
	public int updateSection(Map<String, Object> param) {
		return notificationDao.updateSection(param);
	}

	@Override
	public int addNotification(Notification notify) {
		notify.setAddDate(new Date());
		notify.setStatus((byte) 1);
		
		if( notify.getIsMain() != null && 1 == notify.getIsMain()){
			Map<String ,Object> param = new HashMap<String,Object>();
			param.put("busId", notify.getBusId());
			param.put("isMainParam", 1);
			param.put("isMain", 0);
			notificationDao.updateSection(param);
		}
		
		return notificationDao.addSelective(notify);
		
	}
}
