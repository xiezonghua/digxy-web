package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Recorder;
import com.huayu.dao.RecorderDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.RecorderService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("recorderService")
public class RecorderServiceImpl extends AbstractBasicService<Recorder , Long> implements RecorderService{

	private final static Logger logger = LoggerFactory.getLogger(RecorderServiceImpl.class.getCanonicalName());

	@Resource
	private RecorderDao recorderDao ;

	@Override
	public DBBasicDao<Recorder, Long> getDao() {		
		return recorderDao;
	}
}
