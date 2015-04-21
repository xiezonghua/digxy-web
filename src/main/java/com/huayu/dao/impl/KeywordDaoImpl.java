package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Keyword;
import com.huayu.dao.KeywordDao;
import com.huayu.dao.mapper.KeywordMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("keywordDao")
public class KeywordDaoImpl extends AbstractDBBasicDao<Keyword , Long> implements KeywordDao{
	@Autowired
	private KeywordMapper keywordMapper ;

	@Override
	public DaoMapper<Keyword, Long> getDaoMapper() {		
		return keywordMapper;
	}
}
