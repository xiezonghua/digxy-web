package com.huayu.utils;

import java.util.ArrayList;
import java.util.List;

import com.huayu.bo.Expert;

public class ExpertHelper {
	private final static List<Expert> expertCache = new ArrayList<Expert>(); 
	
	public static void load(List<Expert> data){
		expertCache.clear();
		expertCache.addAll(data);
	}
	
	public static List<Expert> getData(){
		List<Expert> tmpExperts = new ArrayList<Expert>();
		tmpExperts.addAll(expertCache);
		return tmpExperts; 
	}
}
