package com.huayu.platform;

import java.util.HashMap;
import java.util.Map;

public class Pagination {
	private Integer pageNum = 1;
	private Integer offset = 10;
	private String orderBy;
	private String expectIds;

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
	
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getBeginNum() {
		return (pageNum - 1) * offset;
	}

	public String getExpectIds() {
		return expectIds;
	}

	public void setExpectIds(String expectIds) {
		this.expectIds = expectIds;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("beginNum", getBeginNum());
		pageMap.put("offset", offset);
		pageMap.put("orderBy", orderBy);
		pageMap.put("expectIds", expectIds);
		return pageMap;
	}

}

