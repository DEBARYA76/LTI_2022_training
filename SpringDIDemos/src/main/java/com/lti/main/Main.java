package com.lti.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.config.Config;
import com.lti.entity.Car;
import com.lti.entity.Tyre;

public class Main {

	public static void main(String[] args) {
//		Car car=getBeans("car");
//		car.start();

		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		// Car car = (Car) context.getBean("car");
       ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Car car = (Car) context.getBean(Car.class);
		car.start();
		car.showCarDetails();

//		Tyre tyre = (Tyre) context.getBean("tr");
		// tyre.showTyreDetails();
	}

}
