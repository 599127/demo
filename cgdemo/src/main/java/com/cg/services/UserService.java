package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.User;
import com.cg.repository.UserRepository;
import com.cg.security.util.SecurityUtility;
import com.cg.services.impl.UserServiceImpl;

@Service
public class UserService  implements UserServiceImpl{
	
	//private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
 
	@Autowired
	private UserRepository userRepository;
 
	@Override
	public User createUser(User user) {
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
		user.setPassword(encryptedPassword);
		user = userRepository.save(user);
		//LOG.info("User with user email {} created.", user.getEmail());
		return user;

	}

	@Override
	public User getUserByEmail(String email) {
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		return null;
	}

	@Override
	public User updateUser(User user, User localUser) {
		return null;
	}

	@Override
	public User updatePassword(User user, String currentPassword, String newPassword) {
		return null;
	}

	@Override
	public User getUserById(Long id) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
