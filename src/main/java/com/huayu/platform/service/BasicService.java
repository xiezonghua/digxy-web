package com.huayu.platform.service;

import java.io.Serializable;
import java.util.List;

public interface BasicService<T, ID extends Serializable> {
	public int delete(ID id);

	public int add(T obj);

	public int addSelective(T obj);

	public T queryByPrimaryKey(ID id);

	public int updateByPrimaryKeySelective(T obj);

	public int updateByPrimaryKey(T record);

	public long count();

	public List<T> queryAll();
	
	public List<T> query(T record);
}
