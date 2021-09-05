package com.rest.story.controller;

import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.dto.ApiResponse;
import com.rest.dto.JwtAuthenticationResponseDto;
import com.rest.exceptions.ResourceNotFoundException;
import com.rest.filter.security.JwtTokenProvider;
import com.rest.model.Role;
import com.rest.model.RoleName;
import com.rest.model.User;
import com.rest.payloads.LoginPayload;
import com.rest.payloads.SignUpPayload;
import com.rest.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {
	
	private static final Logger logger = Logger.getLogger(AuthController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginPayload loginPayload) throws ResourceNotFoundException{

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginPayload.getUsernameOrEmail(), loginPayload.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwtToken = jwtTokenProvider.generateToken(authentication);

		logger.info(" >>> Succesfull Sign in for username " + loginPayload.getUsernameOrEmail());
		return ResponseEntity.ok(new JwtAuthenticationResponseDto(jwtToken));

	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody SignUpPayload payload) {
		
		//Some validations before proceeding with signup
		// 1. Check if the username is already taken
		
//		if(userRepository.existsByUsername(payload.getUsername())) {
//			return  ResponseEntity.badRequest().body("Username is already taken");
//		}
		if(payload.getEmail().isEmpty() || payload.getEmail() == null) {
			payload.setEmail(""); //setting empty string in db
		}
		//Creating user account and adding in db
		User user = new User(payload.getName(), payload.getUsername(), payload.getEmail(), payload.getPassword());
		
		//Encode the password
		user.setPassword(passwordEncoder.encode(payload.getPassword()));
		Role userRole = new Role();
		userRole.setName(RoleName.USER);
		
		user.setRoles(Collections.singleton(userRole));

		
		try {
			userService.addUser(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{username}")
				 .buildAndExpand(user.getUsername()).toUri();
		
		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
		
	}

}
