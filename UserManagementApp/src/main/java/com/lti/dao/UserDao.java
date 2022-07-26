package com.lti.dao;

import java.util.List;

import com.lti.entity.User;

public interface UserDao {

	User addOrUpdate(User user);
	User searchUserById(int userId);
	List<User> viewAllUsers();
	boolean login(int userId,String password);
	String getUserName(int userId);
}
