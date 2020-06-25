package com.cg.enums;

public enum UserActive {
	
	ACTIVE("A"), INACTIVE("U");

	private final String code;

	UserActive(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
 

}
