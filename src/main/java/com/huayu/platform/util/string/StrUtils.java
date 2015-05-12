package com.huayu.platform.util.string;

import org.apache.commons.lang3.StringUtils;

public class StrUtils {
	public static String toStr(String str){
		return StringUtils.isEmpty(str)? "":str;
	}
	
	
	public static String toStr(String str , String defaultValue){
		return StringUtils.isEmpty(str)? defaultValue:str;
	}
	
	public static String equalsReturn(String myValue , String curValue , String returnValue){
		return myValue.equals(curValue) ? returnValue : "";
	}
}
