package com.huayu.platform;

public enum AuthorityType {
	SUPER_MAN((byte) 101), MANAGER((byte) 100), MEMBER((byte) 1);

	private Byte type;

	AuthorityType(Byte type) {
		this.type = type;
	}

	public Byte getValue() {
		return type;
	}
}
