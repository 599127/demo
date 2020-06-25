package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.cg.enums.RoleEnum;
import com.cg.model.User;
import com.cg.security.util.SecurityUtility;
import com.cg.services.UserService;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CgdemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CgdemoApplication.class, args);
	}
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
	User user1 = new User();
	user1.setFirstName("Amit");
	user1.setLastName("Kumar");
	user1.setUsername("amit");
	user1.setPassword(SecurityUtility.passwordEncoder().encode("amit"));
	user1.setEmail("amitQ.kumar@gmail.com");
	user1.setRole(RoleEnum.ADMIN.getCode());
	
	userService.createUser(user1);

	User user2 = new User();
	user2.setFirstName("Anu");
	user2.setLastName("Bhardwaj");
	user2.setUsername("anu");
	user2.setPassword(SecurityUtility.passwordEncoder().encode("a"));
	user2.setEmail("anu.bhardwaj@gmail.com");
	user1.setRole(RoleEnum.ADMIN.getCode());
	userService.createUser(user1);
	}
}
