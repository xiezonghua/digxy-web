package com.huayu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.huayu.bo.User;
import com.huayu.dao.UserDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.UserService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	public List<User> selectFollowers(User user) {
		return userDao.selectFollowers(user);
	}

	@Override
	public List<User> selectAttentions(User user) {
		return userDao.selectAttentions(user);
	}

}
