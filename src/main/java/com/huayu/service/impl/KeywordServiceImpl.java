package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Keyword;
import com.huayu.dao.KeywordDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.KeywordService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("keywordService")
public class KeywordServiceImpl extends AbstractBasicService<Keyword , Long> implements KeywordService{

	private final static Logger logger = LoggerFactory.getLogger(KeywordServiceImpl.class.getCanonicalName());

	@Resource
	private KeywordDao keywordDao ;

	@Override
	public DBBasicDao<Keyword, Long> getDao() {		
		return keywordDao;
	}
}
