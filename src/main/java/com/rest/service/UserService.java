package com.rest.service;

import java.util.List;

import com.rest.model.User;

public interface UserService {
	
	User addUser(User user);
	
	User findByUsername(String username);
	
    User findByEmail(String email);
    
    User findById(Long id);

    User findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

	User findByIdIn(Long id);
}
