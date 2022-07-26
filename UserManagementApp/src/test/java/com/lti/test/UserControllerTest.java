package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.UserController;
import com.lti.dao.UserDao;
import com.lti.entity.User;

public class UserControllerTest {

	UserController controller;

		@Before
		public void initializeDao() {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
			
			controller=context.getBean(UserController.class);
		}

		
		@Test
		public void signupTest()
		{
//			String expectedMessage="enexpected error occured";
//			String actualMessage=controller.signUp(null);
//			assertTrue(expectedMessage.equals(actualMessage));
			
			User user=new User();
			user.setUserName("treia");
			user.setEmail("trial@g.vom");
			user.setMobile("83974545");
			user.setPassword("hur3");
			String actualMessage=controller.signUp(user);
			System.out.println(actualMessage);
			user.setUserId(4);
			user.setUserName("Michael");
			user.setEmail("Michael@lti.com");
			user.setPassword("Michael@12345");
			user.setMobile("8888888888");
			controller.signUp(user);
		}
		@Test
		public void updateProfile()
		{
		
			User us=new User();
			us.setUserId(7);
			us.setUserName("dejak");
			us.setEmail("djnej@g.vom");
			us.setMobile("83974545");
			us.setPassword("hdnjer3");
			String message=controller.updateProfile(us);
			System.out.println(message);
	
		}
		
		@Test
		public void findUserTest() {
			assertNotNull(controller.findUser(1));
		}
		
		@Test
		public void viewAllUsersTest() {
			assertEquals(5, controller.viewAllUsers().size());
		}
		
		@Test
		public void userLoginTest() {
			assertTrue(controller.userLogin(1, "arya34"));
		}
		
		@Test
		public void getUserName() {
			assertEquals("Arya", controller.getUserName(1));
		}

		
}
