package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Revert;
import com.huayu.dao.RevertDao;
import com.huayu.dao.mapper.RevertMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("revertDao")
public class RevertDaoImpl extends AbstractDBBasicDao<Revert , Long> implements RevertDao{
	@Autowired
	private RevertMapper revertMapper ;

	@Override
	public DaoMapper<Revert, Long> getDaoMapper() {		
		return revertMapper;
	}
}
