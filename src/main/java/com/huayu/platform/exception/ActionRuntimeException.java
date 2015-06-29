package com.huayu.platform.exception;

public class ActionRuntimeException extends HyRuntimeException{

	private static final long serialVersionUID = 1L;
	
	private int code = 2000;
	
	public ActionRuntimeException(String msg) {
		super(msg);
	}
	
	public ActionRuntimeException(String msg, ExceptionCode code) {
		super(msg);
		this.code = code.getCode();
	}
	
	public ActionRuntimeException(String msg, Throwable paramThrowable) {
		super(msg, paramThrowable);
	}

	public ActionRuntimeException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}

