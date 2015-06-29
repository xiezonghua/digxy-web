package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.User;
import com.huayu.platform.db.DBBasicDao;

public interface UserDao extends DBBasicDao<User, Long> {
	List<User> selectUsers(Map<String , Object> query);
	
	Long selectUsersCount(Map<String , Object> query);

	List<User> selectFollowers(User user);

	List<User> selectAttentions(User user);
}