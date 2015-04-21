package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Recorder;
import com.huayu.dao.RecorderDao;
import com.huayu.dao.mapper.RecorderMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("recorderDao")
public class RecorderDaoImpl extends AbstractDBBasicDao<Recorder , Long> implements RecorderDao{
	@Autowired
	private RecorderMapper recorderMapper ;

	@Override
	public DaoMapper<Recorder, Long> getDaoMapper() {		
		return recorderMapper;
	}
}
