package com.huayu.platform.util.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(ValidateUtils.class.getCanonicalName());
	
	private static final String DEFAULT_SEPARATOR = ";";

	//private static final String EMAIL_PATTTERN_DEFAULT = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@baidu.com$";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" ;

	private static final String MOBILE_PATTERN = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

	/**
	 * 验证Baidu邮箱
	 * 
	 * @param mailStr
	 * @return
	 */
	public static String validateBaiduMail(String mailStr) {
		return validate(mailStr, EMAIL_PATTERN);
	}

	/**
	 * 验证手机号
	 */
	public static String validateMobile(String mobileStr) {
		return validate(mobileStr, MOBILE_PATTERN);
	}

	/**
	 * 验证
	 * @param compStr
	 * @param patternStr
	 * @return
	 */
	public static String validate(String compStr, String patternStr) {
		return validate(compStr, patternStr, DEFAULT_SEPARATOR);
	}

	/**
	 * 基础验证
	 * @param compStr
	 * @param patternStr
	 * @param separator
	 * @return
	 */
	private static String validate(String compStr, String patternStr,
			String separator) {
		StringBuffer msg = new StringBuffer();
		Pattern pattern = Pattern.compile(patternStr);
		String[] compStrs = compStr.split(separator);
		Matcher mat = null;
		for (String comp : compStrs) {
			if (StringUtils.isNotBlank(comp)) {
				mat = pattern.matcher(comp);
				if (!mat.find()) {
					msg.append(comp).append(separator);
				}
			}
		}
		return msg.toString();
	}
	
	private static Map<String , String> validate(String[] names , String[] values , ValidateSupportEnum[] validateTypes){
		Map<String , String> result = new HashMap<String , String>();
		if(ArrayUtils.isEmpty(names) || ArrayUtils.isEmpty(values) || ArrayUtils.isEmpty(validateTypes)){
			logger.warn("names or values , validateTypes is empty.");
			return result;
		}
		
		if(names.length != values.length || values.length != validateTypes.length){
			logger.warn("names[{}] length don't equals to the values[{}] length , validateTypes[{}] length." , names.length , values.length , validateTypes.length);
			return result;
		}
		
		for(int i = 0 ; i < values.length ; i++){
			if(StringUtils.isEmpty(values[i])){
				result.put(names[i], names[i] + " must type a value.");
			}
		}
		
		return result;
	}
	
	public static Map<String , Object> validateEmpty(String[] names , String[] values ){
		Map<String , Object> result = new HashMap<String , Object>();
		if(ArrayUtils.isEmpty(names) || ArrayUtils.isEmpty(values)){
			logger.warn("names or values , validateTypes is empty.");
			return result;
		}
		
		if(names.length != values.length){
			logger.warn("names[{}] length don't equals to the values[{}] length , validateTypes[{}] length." , names.length , values.length);
			return result;
		}
		
		for(int i = 0 ; i < values.length ; i++){
			if(StringUtils.isEmpty(values[i])){
				result.put(names[i], names[i] + " must type a value.");
			}
		}
		
		return result;
	}
	
	
}
