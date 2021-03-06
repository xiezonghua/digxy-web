package com.huayu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.User;
import com.huayu.dao.UserDao;
import com.huayu.platform.AuthorityType;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.exception.ServiceRuntimeException;
import com.huayu.platform.mail.MailProperties;
import com.huayu.platform.mail.MailServer;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.UserService;

@Service("userService")
public class UserServiceImpl extends AbstractBasicService<User, Long> implements
		UserService {

	private final static Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class.getCanonicalName());

	@Resource
	private UserDao userDao;

	@Override
	public DBBasicDao<User, Long> getDao() {
		return userDao;
	}

	@Override
	public User userLogin(String userName, String password) {
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("userName", userName);
		query.put("password", password);
		List<User> users = userDao.selectUsers(query);

		if (1 == users.size()) {
			return users.get(0);
		}

		logger.info("user ({}) login failure , query users size : {}",
				userName, users.size());

		return null;
	}

	@Override
	public List<User> queryFollowers(Long userId) {
		if(null == userId) return new ArrayList<User>();
		User user = new User();
		user.setId(userId);
		return userDao.selectFollowers(user);
	}

	@Override
	public List<User> queryAttentions(Long userId) {
		if(null == userId) return new ArrayList<User>();
		User user = new User();
		user.setId(userId);
		return userDao.selectAttentions(user);
	}

	@Override
	public List<User> queryUsers(Map<String, Object> query) {
		return userDao.selectUsers(query);
	}

	@Override
	public Long queryUsersCount(Map<String, Object> query) {
		return userDao.selectUsersCount(query);
	}

	@Override
	public void register(User user) {
		//邮箱确认
		MailProperties mailProp = MailServer.getDefaultProperties();
		mailProp.setReceiver(user.getEmail());
		try {
			MailServer.sendSimpleMail(mailProp);
		} catch (MessagingException e) {
			logger.warn("确认邮件发送失败，请确认邮箱地址。exception :{}" , e );
			throw new ServiceRuntimeException("确认邮件发送失败，请确认邮箱地址");
		}
		
		user.setZcsj(new Date());
		user.setRole(AuthorityType.MEMBER.getValue());
		user.setLev("1");
		userDao.addSelective(user);		
		
	}

}
