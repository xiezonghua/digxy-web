package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Zhuanjia;
import com.huayu.dao.ZhuanjiaDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.ZhuanjiaService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("zhuanjiaService")
public class ZhuanjiaServiceImpl extends AbstractBasicService<Zhuanjia , Long> implements ZhuanjiaService{

	private final static Logger logger = LoggerFactory.getLogger(ZhuanjiaServiceImpl.class.getCanonicalName());

	@Resource
	private ZhuanjiaDao zhuanjiaDao ;

	@Override
	public DBBasicDao<Zhuanjia, Long> getDao() {		
		return zhuanjiaDao;
	}
}
