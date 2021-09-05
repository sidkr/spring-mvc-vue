//package com.rest.DAO.impl;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.rest.model.User;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//	
//	
//    User findByEmail(String email);
//
//    User findByUsernameOrEmail(String username, String email);
//
//    List<User> findByIdIn(List<Long> userIds);
//
//    User findByUsername(String username);
//
//
//	User findByIdIn(Long id);
//}
