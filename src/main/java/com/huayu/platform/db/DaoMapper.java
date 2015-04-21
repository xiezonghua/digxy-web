package com.huayu.platform.db;

import java.io.Serializable;
import java.util.List;

public interface DaoMapper<T, ID extends Serializable> {

	int deleteByPrimaryKey(ID id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	long count();

	List<T> selectAll();
	
	List<T> select(T record);
}
