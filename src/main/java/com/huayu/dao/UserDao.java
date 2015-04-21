package com.huayu.dao;

import java.util.List;

import com.huayu.bo.User;
import com.huayu.platform.db.DBBasicDao;

public interface UserDao extends DBBasicDao<User, Long> {
	List<User> selectUsers(User user);

	List<User> selectFollowers(User user);

	List<User> selectAttentions(User user);
}