package com.huayu.platform.action;

public enum ResponseStatusEnum {
	VALIDATE_FAILURE(120), QUERY_FAILURE(130), SUCCESS(200);

	private int statusCode;

	private ResponseStatusEnum(int statusCode) {
		this.statusCode = statusCode;

	}

	public int getStatusCode() {
		return statusCode;
	}
}
