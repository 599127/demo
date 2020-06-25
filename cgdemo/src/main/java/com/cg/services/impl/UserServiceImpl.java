package com.cg.services.impl;

import com.cg.model.User;


public interface UserServiceImpl {


	User createUser(User user);

	User getUserByEmail(String email);

	User getUserByUsername(String username);

	User updateUser(User user, User localUser);

	User updatePassword(User user, String currentPassword, String newPassword);

	User getUserById(Long id);

}
