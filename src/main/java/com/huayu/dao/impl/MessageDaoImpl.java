package com.huayu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Message;
import com.huayu.dao.MessageDao;
import com.huayu.dao.mapper.MessageMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("messageDao")
public class MessageDaoImpl extends AbstractDBBasicDao<Message , Long> implements MessageDao{
	@Autowired
	private MessageMapper messageMapper ;

	@Override
	public DaoMapper<Message, Long> getDaoMapper() {		
		return messageMapper;
	}

	@Override
	public List<Message> selectList(Map<String, Object> query) {
		return messageMapper.selectList(query);
	}

	@Override
	public Long selectCount(Map<String, Object> query) {
		return messageMapper.selectCount(query);
	}
}
