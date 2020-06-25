package com.cg.security.util;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Pass encoder util class
 * @author Amit Kumar
 *
 */

@Component
public class SecurityUtility {
	private static final String SALT="salt";//Mandatory to use salt only.
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12,new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randommPassword() {
		String SALTCHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer salt= new StringBuffer();
		
		Random random= new Random();
		while (salt.length()<18) {
			int index=(int)(random.nextFloat()*SALTCHAR.length());
			salt.append(SALTCHAR.charAt(index));
		}
		
		String saltStr=salt.toString();
		return saltStr;
	}

}