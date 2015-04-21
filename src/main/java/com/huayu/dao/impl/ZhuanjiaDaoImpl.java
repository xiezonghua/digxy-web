package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Zhuanjia;
import com.huayu.dao.ZhuanjiaDao;
import com.huayu.dao.mapper.ZhuanjiaMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("zhuanjiaDao")
public class ZhuanjiaDaoImpl extends AbstractDBBasicDao<Zhuanjia , Long> implements ZhuanjiaDao{
	@Autowired
	private ZhuanjiaMapper zhuanjiaMapper ;

	@Override
	public DaoMapper<Zhuanjia, Long> getDaoMapper() {		
		return zhuanjiaMapper;
	}
}
