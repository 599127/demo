package com.cg;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.model.Role;
import com.cg.model.User;
import com.cg.model.UserRole;
import com.cg.security.util.SecurityUtility;
import com.cg.services.UserService;


@SpringBootApplication
public class CgdemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CgdemoApplication.class, args);
	}
	
	@Autowired
	private UserService userService;
	

	@Override
	public void run(String... args) throws Exception {
//	User user1 = new User();
//	user1.setFirstName("Amit");
//	user1.setLastName("Kumar");
//	user1.setUsername("amit");
//	user1.setPassword(SecurityUtility.passwordEncoder().encode("amit"));
//	user1.setEmail("amitQ.kumar@gmail.com");
//	user1.setRole(RoleEnum.ADMIN.getCode());
//	
//	userService.createUser(user1);
//
//	User user2 = new User();
//	user2.setFirstName("Anu");
//	user2.setLastName("Bhardwaj");
//	user2.setUsername("anu");
//	user2.setPassword(SecurityUtility.passwordEncoder().encode("a"));
//	user2.setEmail("anu.bhardwaj@gmail.com");
//	user1.setRole(RoleEnum.ADMIN.getCode());
//	userService.createUser(user1);
		
		
		User user1 = new User();
		user1.setFirstName("Amit");
		user1.setLastName("Kumar");
		user1.setUsername("amit");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("amit"));
		user1.setEmail("amitQ.kumar@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);
		userRoles.clear();

		User user2 = new User();
		user2.setFirstName("Anu");
		user2.setLastName("Bhardwaj");
		user2.setUsername("anu");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("a"));
		user2.setEmail("anu.bhardwaj@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));
		userService.createUser(user2, userRoles);
		
	}
}
