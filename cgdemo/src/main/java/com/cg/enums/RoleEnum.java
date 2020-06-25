package com.cg.enums;

public enum RoleEnum {
	
	USER("USER"), ADMIN("ADMIN"), MERCHANT ("MERCHANT "), CUSTOMER("CUSTOMER");

	private final String code;

	RoleEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
 

}
