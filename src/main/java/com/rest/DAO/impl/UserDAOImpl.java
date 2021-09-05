package com.rest.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.DAO.UserDAO;
import com.rest.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	
	@Autowired SessionFactory sessionFactory;

	@Override
	public User addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	@Override
	@SuppressWarnings("deprecation")
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class, "user");
		
		
		
		criteria.add(Restrictions.eq("user.username", username));
		User user = (User) criteria.uniqueResult();		
		
		return user;
	}
	
	@Override
	public User findById(Long id) {
		User user = sessionFactory.getCurrentSession().get(User.class, id);
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
