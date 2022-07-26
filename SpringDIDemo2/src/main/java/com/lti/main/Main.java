package com.lti.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.entity.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Vehicle vehicle = new Car();
//		vehicle.run();
//		

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Laptop laptop = context.getBean(AcerLaptop.class);
		laptop.details();

	}

}
