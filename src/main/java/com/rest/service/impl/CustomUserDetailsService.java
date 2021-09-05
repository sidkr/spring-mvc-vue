package com.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rest.exceptions.ResourceNotFoundException;
import com.rest.filter.security.UserPrincipal;
import com.rest.model.User;
import com.rest.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		try {
			User user = userService.findByUsername(usernameOrEmail);

			return UserPrincipal.create(user);
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail);
		}
	}

	public UserDetails loadUserById(Long id) {
		User user = null;
		try {
			user = userService.findById(id);
			
		} catch (Exception e) {
			new ResourceNotFoundException("User", "id", id);
		}
		
		return UserPrincipal.create(user);
	}
	
	

}
