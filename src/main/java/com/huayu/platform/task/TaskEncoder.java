package com.huayu.platform.task;


/**
 * @author v_xiezonghua
 */
public class TaskEncoder {
	/**
	 * 位置     	时间域名		允许值			允许的特殊字符
	 * 1		秒			0-59			, - * /
	 * 2		分钟			0-59			, - * /
	 * 3		小时			0-23			, - * /
	 * 4		日期			1-31			, - * ? / L W C
	 * 5		月份			1-12			, - * /
	 * 6		星期			1-7				, - * ? / L C #
	 */
	private final static int TASK_LEN  = 6 ;
	private String[] taskModel = new String[6]; //不用年
	
	public TaskEncoder(){
		for (int i = 0 ; i < TASK_LEN; i++) {
			if( i < 3){
				taskModel[i] = "0";
			}else{
				taskModel[i] = "*";
			}
		}
	}

	public void compileHour(Integer startHour, Integer endHour, Integer frequency) {
		taskModel[3] = compile(startHour, endHour, frequency);
	}
	
	public void compileNonsequenceHour(Object[] execHour) {
		taskModel[3] = compileNosequence(execHour);
	}
	
	public void compileDay(Integer startDay, Integer endDay, Integer frequency) {
		taskModel[3] = compile(startDay, endDay, frequency);
	}

	public void compileNonsequenceDay(Object[] execDay) {
		taskModel[3] = compileNosequence(execDay);
	}

	public void compileMonth(Integer startMonth, Integer endMonth,
			Integer frequency) {
		taskModel[4] = compile(startMonth, endMonth, frequency);
	}

	public void compileNonsequenceMonth(Object[] execMonth) {
		taskModel[4] = compileNosequence(execMonth);
	}

	public void compileWeekly(Integer startWeek, Integer endWeek,
			Integer frequency) {
		taskModel[5] = compile(startWeek, endWeek, frequency);
	}

	public void compileNonsequenceWeekly(Object[] execWeekly) {
		taskModel[5] = compileNosequence(execWeekly);
	}
	
	/**
	 * 不连续的时间点
	 * @param execValue
	 * @return
	 */
	public String compileNosequence(Object[] execValue){
		StringBuffer buffer = new StringBuffer();		
		for (int i = 0 , _len = execValue.length ; i < _len ; i++) {
			if( i < _len -1 ){
				buffer.append(execValue[i]).append(",");
			}else{
				buffer.append(execValue[i]);
			}	
		}
		return buffer.toString();
	}
	
	/**
	 * 连续有规律的时间
	 * @param start
	 * @param end
	 * @param frequency
	 * @return
	 */
 	public String compile(Integer start , Integer end , Integer frequency){	
		StringBuffer buffer = new StringBuffer();		
		if (null != start) {
			buffer.append(start);
			if(null != end){
				buffer.append("-").append(end);				
			}
			if( null != frequency){
				buffer.append("/").append(frequency);
			}
		}else{
			buffer.append("?");
		}
		return buffer.toString();
	}
 	public String toCompileStr ( String defaultValue){
 		StringBuffer buffer = new StringBuffer();
 		for (String item : taskModel) { 			
			buffer.append(item).append(" ");
		}
 		return buffer.toString() ;
 	}
 	public static void main (String[] args){
 		TaskEncoder encoder = new TaskEncoder();
 		System.out.println(encoder.toCompileStr(null));
 	}
}
