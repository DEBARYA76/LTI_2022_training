package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.UserDao;
import com.lti.entity.User;
import com.lti.exception.UserIdMissingException;
import com.lti.exception.UserNoFoundException;
@Component
public class UserServiceImpl implements UserService {

	
	
	@Autowired
	UserDao userDao;
	public String signUp(User user) {
		
		User user2;
		try {
			user2 = userDao.addOrUpdate(user);
			return "Sign up suceesful.your userid is: "+user2.getUserId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "unexpected error";
		}
		    
		
	}

	public String updateProfile(User user) {
		try {
	if(user.getUserId()==0)
	{throw new UserIdMissingException("please mention userId");
	
	}
	else if(userDao.searchUserById(user.getUserId())==null) {
		throw new UserNoFoundException("user not found");
	}
	else {	
			User	user2 = userDao.addOrUpdate(user);
			return  "user ID:"+user.getUserId();
					
					}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}

	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return  userDao.searchUserById(userId);
	}

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return userDao.viewAllUsers();
	}

	public boolean userlogin(int userId, String password) {
		// TODO Auto-generated method stub
		return userDao.login(userId, password);
	}

	public String getUserName(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserName(userId);
	}

}
