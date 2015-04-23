package com.huayu.platform;

import java.util.HashMap;
import java.util.Map;

public class Pagination {
	private Integer pageNum = 0;
	private Integer offset = 10;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getBeginNum() {
		return pageNum * offset;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("beginNum", getBeginNum());
		pageMap.put("offset", offset);
		return pageMap;
	}

}
