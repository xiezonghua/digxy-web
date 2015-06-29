package com.huayu.platform.exception;

public enum ExceptionCode {
	PARAM(2000) , VALIDATE(2001), CONVERT(2002) ,NOT_AUTHORITY(2003);

	private int code;

	private ExceptionCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
