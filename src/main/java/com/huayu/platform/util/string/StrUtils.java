package com.huayu.platform.util.string;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONWriter;

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
	
	public static String contain(Byte[] data , String subStr, String returnValue){
		if(null == data){
			return "";
		}
		
		return StringUtils.join(data, ',').contains(subStr)?returnValue:"";
	}
	
	
	public static String isNull(Object data , String value){
		return data == null?value:"";
	}
	
	public static String toJson(Object obj){
		JSONWriter jsonWriter = new JSONWriter();
		String result = "";
		try {
			result = jsonWriter.write(obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] arg){
		Byte[] data = new Byte[]{1,2};
		System.out.println(StringUtils.join(data, ','));
	}
}
