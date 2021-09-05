package com.rest.DAO;

import java.util.List;

import com.rest.model.User;

public interface UserDAO {
	
	User addUser(User user);

	User findByUsername(String username);
	
	User findById(Long id);

	User findByEmail(String email);

	User findByUsernameOrEmail(String username, String email);

	List<User> findByIdIn(List<Long> userIds);

	User findByIdIn(Long id);

}
