package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Message;
import com.huayu.platform.db.DBBasicDao;

public interface MessageDao extends DBBasicDao<Message, Long> {
	List<Message> selectList(Map<String, Object> query);
	
	Long selectCount(Map<String, Object> query);
}