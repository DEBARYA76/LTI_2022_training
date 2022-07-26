package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lti.*;
import com.lti.controller.UserController;
import com.lti.dao.UserDao;
import com.lti.dao.UserDaoImpl;
import com.lti.entity.User;
import com.lti.service.UserServiceImpl;

public class UserTest {

	UserDao dao;
	//UserController controller;

	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(UserDao.class);
		//=context.getBean(UserController.class);
	}

	@Test
	public void addNewUser() {
		User user = new User();
		user.setUserName("pukl");
		user.setEmail("piladj@gmail.com");
		user.setMobile("3557334549");
		user.setPassword("pulk4");

		User savedUser = dao.addOrUpdate(user);
		assertNotNull(savedUser);

	}

	@Test
	public void searchUserByIdTest() {
		User dbUser = dao.searchUserById(1);
		assertNotNull(dbUser);
	}

	@Test
	public void viewAllUsersTest() {
		assertEquals(3, dao.viewAllUsers().size());
	}

	@Test
	public void loginTest() {
		User dbUser = dao.searchUserById(1);
		assertTrue(dbUser.getPassword().equals("arya34"));
	}
	
}
