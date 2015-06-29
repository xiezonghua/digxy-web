package com.huayu.platform.exception;

public class ServiceRuntimeException extends HyRuntimeException{

	private static final long serialVersionUID = 1L;
	
	private int code = 2000;
	
	public ServiceRuntimeException(String msg) {
		super(msg);
	}
	
	public ServiceRuntimeException(String msg , ExceptionCode code) {
		super(msg);
		this.code = code.getCode();
	}
	
	public ServiceRuntimeException(String msg, Throwable paramThrowable) {
		super(msg, paramThrowable);
	}

	public ServiceRuntimeException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
