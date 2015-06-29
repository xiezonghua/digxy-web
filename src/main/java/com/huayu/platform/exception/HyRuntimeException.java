package com.huayu.platform.exception;

public class HyRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
	
	private int code = 2000;
	
	public HyRuntimeException(String msg) {
		super(msg);
	}
	
	public HyRuntimeException(String msg, ExceptionCode code) {
		super(msg);
		this.code = code.getCode();
	}
	
	public HyRuntimeException(String msg, Throwable paramThrowable) {
		super(msg, paramThrowable);
	}

	public HyRuntimeException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
