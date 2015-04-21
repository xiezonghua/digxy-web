package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Mail;
import com.huayu.dao.MailDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.MailService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("mailService")
public class MailServiceImpl extends AbstractBasicService<Mail , Long> implements MailService{

	private final static Logger logger = LoggerFactory.getLogger(MailServiceImpl.class.getCanonicalName());

	@Resource
	private MailDao mailDao ;

	@Override
	public DBBasicDao<Mail, Long> getDao() {		
		return mailDao;
	}
}
