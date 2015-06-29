package com.huayu.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huayu.bo.SystemDictionary;

public class DictionaryHelper {
	private final static Map<Byte, Map<Byte, SystemDictionary>> dictionaryMap = new HashMap<Byte, Map<Byte, SystemDictionary>>();

	/**
	 * Just use to initialization data , don't called by your self.
	 * 
	 * @param data
	 */
	public static void loadData(List<SystemDictionary> data) {
		for (SystemDictionary elem : data) {
			if (dictionaryMap.containsKey(elem.getTypeCode())) {
				Map<Byte, SystemDictionary> map = dictionaryMap.get(elem.getTypeCode());
				map.put(elem.getTypeId(), elem);
			} else {
				Map<Byte, SystemDictionary> map = new HashMap<Byte, SystemDictionary>();
				map.put(elem.getTypeId(), elem);
				dictionaryMap.put(elem.getTypeCode(), map);
			}
		}
	}

	public static Map<Byte, SystemDictionary> getDictionaryByTypeCode(
			Byte typeCode) {
		return dictionaryMap.get(typeCode);
	}
}
