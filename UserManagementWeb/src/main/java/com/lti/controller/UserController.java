package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.entity.User;
import com.lti.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUp(User user) {
		String message = userService.signUp(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/welcome.jsp");
		mv.addObject("msg", message);
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProfile(User u) {

		return userService.updateProfile(u);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public User findUser(int userId) {
		return userService.findUser(userId);
	}

	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	public List<User> viewAllUsers() {
		return userService.viewAllUsers();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean userLogin(int userId, String password) {
		return userService.userlogin(userId, password);

	}

	public String getUserName(int i) {

		return userService.getUserName(i);
	}
}
