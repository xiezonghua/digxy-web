package com.huayu.platform.task;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class TaskDecoder {
	private final static int TASK_LEN  = 6 ;//不用年
	private String[] taskModel = null ;
	
	private static final String DEFAULT_SEPARATE = " " ;
	
	private static final String EXP_SLASH_SEPARATE = "/" ; 
	
	private static final String EXP_COMMA_SEPARATE = "," ;
	
	public TaskDecoder(String taskExpression){		
		loadTaskExp(taskExpression);
	}
	
	public void loadTaskExp(String taskExpression){
		if(StringUtils.isBlank(taskExpression)){
			throw new NullPointerException("Instantiation of TaskDecoder failure ");
		}
		taskModel = taskExpression.split(DEFAULT_SEPARATE);
	}
	
	public Date decode(){
		
		return null;		
	}
	
	public Date decode(String taskExpression){
		loadTaskExp(taskExpression);
		return decode();
	}
	
	public String decodeCompile(String express , Integer compValue){
		//频率模式
		String[] decStr = express.split(EXP_SLASH_SEPARATE);
		int len = decStr.length ;
		if(len == 2){
			int frequency = Integer.valueOf(decStr[1]);
			if( 0 == (compValue%frequency)){
				return "" ;
			}
		}
		
		//枚举模式
		decStr = express.split(EXP_COMMA_SEPARATE);
		
		return null ;
	}

}
