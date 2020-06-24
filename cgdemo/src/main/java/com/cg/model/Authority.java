package com.cg.model;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority,Serializable{
	//TODO what is GrantedAuthority?

	 
	private static final long serialVersionUID = 1423423423L;
	private final String authority;
	
	public Authority(String authority) {
		this.authority=authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	

}
