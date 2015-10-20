package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Notification;
import com.huayu.platform.db.DaoMapper;

public interface NotificationMapper extends DaoMapper<Notification, Long> {
	List<Notification> selectList(Map<String, Object> query);

	long selectListCount(Map<String, Object> query);
	
	int updateSection(Map<String , Object> param);
	
}