package com.huayu.service;

import java.util.List;

import com.huayu.bo.Share;
import com.huayu.platform.service.BasicService;

public interface ShareService extends BasicService<Share, Long> {
	
	List<Share> queryShared(Long sharerId);
	
}