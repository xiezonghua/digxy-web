package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Mail;
import com.huayu.dao.MailDao;
import com.huayu.dao.mapper.MailMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("mailDao")
public class MailDaoImpl extends AbstractDBBasicDao<Mail , Long> implements MailDao{
	@Autowired
	private MailMapper mailMapper ;

	@Override
	public DaoMapper<Mail, Long> getDaoMapper() {		
		return mailMapper;
	}
}
