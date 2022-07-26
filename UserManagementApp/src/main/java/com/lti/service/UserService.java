package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.entity.User;

@Component
public interface UserService {

	String signUp(User user);

String updateProfile(User user);

	User findUser(int userId);

	User registerUser(User user);

	List<User> viewAllUsers();

	boolean userlogin(int userId, String password);

	String getUserName(int userId);
}
