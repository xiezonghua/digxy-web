package com.huayu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.User;
import com.huayu.dao.UserDao;
import com.huayu.dao.mapper.UserMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("userDao")
public class UserDaoImpl extends AbstractDBBasicDao<User , Long> implements UserDao{
	@Autowired
	private UserMapper userMapper ;

	@Override
	public DaoMapper<User, Long> getDaoMapper() {		
		return userMapper;
	}

	@Override
	public List<User> selectUsers(User user) {
		return userMapper.selectUsers(user);
	}

	@Override
	public List<User> selectFollowers(User user) {
		return userMapper.selectFollowers(user);
	}

	@Override
	public List<User> selectAttentions(User user) {
		return userMapper.selectAttentions(user);
	}
}
