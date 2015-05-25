package com.huayu.platform.util;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public final class DateUtils {
	public static String format(Date date){
		return format(date , DateFormatUtils.ISO_DATE_FORMAT.getPattern());
	}
	
	public static String format(Date date , String pattern){
		if(date == null){
			return "";
		}
		return DateFormatUtils.format(date,pattern);
	}
}
