package com.cg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.User;
import com.cg.repository.UserRepository;
import com.cg.services.UserService;

@RestController
public class UserLoginController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	private UserRepository userRepository;
 
	public UserLoginController() {
		System.out.println("-----------------------------------");
	}
	
	@PostMapping("/user/signup")
	public ResponseEntity<User> signup(@RequestBody User user) {
		Optional<User> localUser = userRepository.findByEmail(user.getEmail());
		if (localUser.isPresent()) {
			return new ResponseEntity<User>(localUser.get(), HttpStatus.CONFLICT);
		} else {
			userService.createUser(user);
		}

		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/login/{email}")
	public ResponseEntity<User> login(@PathVariable String email){
		Optional<User> localUser = userRepository.findByEmail(email);
		if (localUser.isPresent()) {
			//TODO LOGIN functionality
			return new ResponseEntity<User>(localUser.get(), HttpStatus.OK);
		}
		return new ResponseEntity<User>(localUser.get(), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("-----------------------------------");
		return "Test working";
	}

}
