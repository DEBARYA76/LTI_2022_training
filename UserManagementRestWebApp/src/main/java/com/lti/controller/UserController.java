package com.lti.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lti.dto.LoginDto;
import com.lti.dto.UpdateUser;
import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	// http://localhost:8181/UserManagementRestWebApp/myapp/users/signup

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@RequestBody User user) {
		String message = userService.signUp(user);

		return message;
	}

	@PutMapping("/update")
	public UpdateUser updateProfile(@RequestBody User user)

	{
		return userService.updateProfile(user);
	}

	@GetMapping("/user/{userId}")
	//@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_XML_VALUE)
	public User searchUser(@PathVariable int userId)

	{
		return userService.findUser(userId);
	}

	@GetMapping("/viewall")
	//@GetMapping(value = "/viewall", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<User> viewAllUsers() {
		return userService.viewAllUsers();
	}

//	@PostMapping("/login")
//	public String login(@RequestBody LoginDto loginData) {
//		boolean isValid = userService.userlogin(loginData.getUserId(), loginData.getPassword());
//		return isValid ? "Login Successfull" : "userId or Password not found";
//
//	}
	@PostMapping("/login")
	public boolean login(@RequestBody LoginDto loginData) {
		boolean isValid = userService.userlogin(loginData.getUserId(), loginData.getPassword());
		// return isValid ? "Login Successfull" : "userId or Password not found";
		return isValid;
	}
}
