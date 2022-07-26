package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.entity.User;
import com.lti.service.UserService;
@Component
public class UserController {

	@Autowired
	UserService userService;

	public String signUp(User user) {
		String message = userService.signUp(user);
		return message;
	}
	
	public String updateProfile(User u) {
		
		return userService.updateProfile(u);
	}
	
	public User findUser(int userId)
	{
		return userService.findUser(userId);
	}
	
	public List<User> viewAllUsers()
	{
		return userService.viewAllUsers();
	}
	
	public  boolean userLogin(int userId,String password)
	{
		return userService.userlogin(userId, password);
		
	}

	public String getUserName(int i) {
		
		return userService.getUserName(i);
	}
}
