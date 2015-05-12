package com.huayu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.User;
import com.huayu.dao.UserDao;
import com.huayu.platform.db.DBBasicDao;
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
		User user = new User();
		user.setYhm(userName);
		user.setPwd(password);
		List<User> users = userDao.selectUsers(user);

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

}
