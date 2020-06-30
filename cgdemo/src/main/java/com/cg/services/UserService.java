package com.cg.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.User;
import com.cg.model.UserRole;
import com.cg.repository.RoleRepository;
import com.cg.repository.UserRepository;
import com.cg.security.util.SecurityUtility;
import com.cg.services.impl.UserServiceImpl;

@Service
public class UserService  implements UserServiceImpl{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
 
	@Autowired
	private UserRepository userRepository;


	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user) {
		Optional<User> localUser = userRepository.findByEmail(user.getEmail());
		if (localUser.isPresent()) {
			String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword);
			user = userRepository.save(user);
			LOG.info("User with user email {} created.", user.getEmail());
		}
		return user;

	}
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {

		User localUser = userRepository.findByUsername(user.getUsername());
		if (localUser != null) {
			LOG.info("User with name {} already exist.Nothing will be done." + user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
				roleRepository.flush();
			}
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
			userRepository.flush();
		}
		return localUser;
	}
	

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user, User localUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatePassword(User user, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
		@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
