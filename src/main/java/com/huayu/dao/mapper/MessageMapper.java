package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Message;
import com.huayu.platform.db.DaoMapper;

public interface MessageMapper extends DaoMapper<Message , Long>{
	List<Message> selectList(Map<String, Object> query);
	
	Long selectCount(Map<String, Object> query);	
	
}