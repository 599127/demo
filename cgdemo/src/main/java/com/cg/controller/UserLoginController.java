package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.User;
import com.cg.repository.UserRepository;
import com.cg.security.util.SecurityUtility;
import com.cg.services.UserService;

@RestController
@CrossOrigin
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
	
	
	
	@PutMapping(value = "/user/resetProfile/{email}")
	public ResponseEntity<User> updateUser(@PathVariable("userName") String id, @RequestBody User user) {
		System.out.println("Updating User " + id);

		Optional<User> currentUser = userRepository.findByEmail(user.getEmail());

		if (!currentUser.isPresent()) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		User userInfo = currentUser.get();
		userInfo.setFirstName(user.getFirstName());
		userInfo.setLastName(user.getLastName());
		userInfo.setPassword(SecurityUtility.passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		return new ResponseEntity<User>(userInfo, HttpStatus.OK);
	}
	
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> listUser = userService.getAllUsers();
		
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}
	
	

}
