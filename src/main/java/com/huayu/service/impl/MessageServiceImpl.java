package com.huayu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.huayu.bo.Message;
import com.huayu.dao.MessageDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.MessageService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("messageService")
public class MessageServiceImpl extends AbstractBasicService<Message , Long> implements MessageService{

	private final static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class.getCanonicalName());

	@Resource
	private MessageDao messageDao ;

	@Override
	public DBBasicDao<Message, Long> getDao() {		
		return messageDao;
	}

	@Override
	public List<Message> queryList(Map<String, Object> query) {
		return messageDao.selectList(query);
	}

	@Override
	public Long queryCount(Map<String, Object> query) {
		return messageDao.selectCount(query);
	}
}
