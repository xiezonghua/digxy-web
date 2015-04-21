package com.huayu.platform.service.impl;

import java.io.Serializable;
import java.util.List;

import com.huayu.platform.db.DBBasicDao;

public abstract class AbstractBasicService<T , ID extends Serializable> {
	
	public abstract DBBasicDao<T , ID> getDao();
	
	public int delete(ID id){
		return getDao().delete(id);
	}
	
	public int add(T obj){
		return getDao().add(obj);
	}

	public int addSelective(T obj){
		return getDao().addSelective(obj);
	}

	public T queryByPrimaryKey(ID id){
		return getDao().queryByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(T obj){
		return getDao().updateByPrimaryKeySelective(obj);
	}

	public int updateByPrimaryKey(T record){
		return getDao().updateByPrimaryKey(record);
	}

	public long count(){
		return getDao().count();
	}

	public List<T> queryAll(){
		return getDao().queryAll();
	}
	
	public List<T> query(T obj){
		return getDao().query(obj);
	}
}
