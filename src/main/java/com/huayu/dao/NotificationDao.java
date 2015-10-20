package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Notification;
import com.huayu.platform.db.DBBasicDao;

public interface NotificationDao extends DBBasicDao<Notification, Long> {
	List<Notification> selectList(Map<String, Object> query);

	Long selectListCount(Map<String, Object> query);	
	
	int updateSection(Map<String , Object> param);
}