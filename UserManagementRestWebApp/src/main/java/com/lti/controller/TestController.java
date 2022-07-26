package com.lti.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	//http://localhost:8181/UserManagementRestWebApp/test/hello
	
	
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "hello world";
	}
	

	//http://localhost:8181/UserManagementRestWebApp/test/hello/arya

//	@RequestMapping("/helloname/{name}")
//	public String sayHelloNme(@PathVariable String name)
//{
//	return "hello   "+name;
//}
	//http://localhost:8181/UserManagementRestWebApp/test/hello/arya/pal

@RequestMapping("/helloname/{fname}/{lname}")
public String sayHelloNme(@PathVariable("fname") String firstName,@PathVariable("lname") String lastName )
{
return "hello   "+firstName+" "+lastName;
}

	//http://localhost:8181/UserManagementRestWebApp/myapp/test/hellofullname?fname=arya&lname=pal

	@RequestMapping("/hellofullname")
	public String sayHelloFullNme(@RequestParam("fname") String firstName,@RequestParam("lname") String lastName )
{
	return "hello   "+firstName+" "+lastName;
}



}
