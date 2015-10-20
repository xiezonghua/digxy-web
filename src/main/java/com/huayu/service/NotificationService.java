package com.huayu.service;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Notification;
import com.huayu.platform.service.BasicService;

public interface NotificationService extends BasicService<Notification, Long> {
	List<Notification> queryList(Map<String, Object> query);

	Long queryListCount(Map<String, Object> query);
	
	int updateSection(Map<String , Object> param);
	
	int addNotification(Notification notify );
}