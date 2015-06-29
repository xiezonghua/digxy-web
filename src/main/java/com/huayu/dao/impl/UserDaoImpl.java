package com.huayu.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<User> selectUsers(Map<String , Object> query) {
		List<User> users = new ArrayList<User>();
		if(query != null){
			users = userMapper.selectUsers(query);
		}
		return users; 
	}

	@Override
	public List<User> selectFollowers(User user) {
		return userMapper.selectFollowers(user);
	}

	@Override
	public List<User> selectAttentions(User user) {
		return userMapper.selectAttentions(user);
	}

	@Override
	public Long selectUsersCount(Map<String, Object> query) {
		return userMapper.selectUsersCount(query);
	}
}
