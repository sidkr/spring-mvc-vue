package com.rest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.DAO.UserDAO;
import com.rest.model.User;
import com.rest.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired UserDAO userDao;

	@Transactional
	public User addUser(User user) {
		userDao.addUser(user);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		User user = userDao.findByUsername(username);
		return user;
	}

	@Override
	public User findById(Long id) {
		User user = userDao.findById(id);
		return user;
	}
	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsernameOrEmail(String username, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByIdIn(List<Long> userIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByIdIn(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
