package com.huayu.service;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Message;
import com.huayu.platform.service.BasicService;

public interface MessageService extends BasicService<Message, Long> {
	List<Message> queryList(Map<String, Object> query);
	
	Long queryCount(Map<String, Object> query);
	
}