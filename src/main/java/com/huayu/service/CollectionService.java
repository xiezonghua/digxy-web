package com.huayu.service;

import java.util.List;

import com.huayu.bo.Collection;
import com.huayu.platform.Pagination;
import com.huayu.platform.service.BasicService;

public interface CollectionService extends BasicService<Collection, Long> {
	List<Collection> queryCollection(Long collecterId , Pagination pageInfo);
}