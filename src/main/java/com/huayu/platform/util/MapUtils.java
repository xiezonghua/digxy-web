package com.huayu.platform.util;

import java.util.Map;

public class MapUtils {
	public static Object getValue(Map<Integer, Object> data ,Object key){
		Object value =  data.get(key);
		return value;
	}
}
