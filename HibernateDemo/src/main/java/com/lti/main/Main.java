package com.lti.main;

import com.lti.dao.GeneralInsuranceDao;
import com.lti.dao.GeneralInsuranceDaoImpl;
import com.lti.dao.PersonDao;
import com.lti.dao.PersonDaoImpl;
import com.lti.entity.Person;
import com.lti.entity.Vehicle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		PersonDao dao= new PersonDaoImpl();
//		Person person=new Person();
//	/*	person.setPersonName("Rick");
//		person.setPersonAge(23);
//		person.setPhoneNo("76058");
//		dao.addNewPerson(person);
//		person.setPersonName("Ri");
//		person.setPersonAge(5);
//		person.setPhoneNo("845784");
//		dao.addNewPerson(person);*/
//		
//		person.setPersonId(400);
//		person.setPersonName("umlpoka");
//		person.setPersonAge(30);
//		person.setPhoneNo("7654675848");
//		
//		Person p=dao.updateAPerson(person);
//		System.out.println(p.getPersonAge());
//		System.out.println(p.getPersonId());
//		System.out.println(p.getPersonName());
//		System.out.println(p.getPhoneNo());
//	}
		GeneralInsuranceDao dao = new GeneralInsuranceDaoImpl();
		Vehicle vehicle = new Vehicle();
		vehicle.setBrand("Toyota");
		vehicle.setModelNo("Tiago");
		vehicle.setVehicleType("road");
		//vehicle.setInsurance(insurance);
		//vehicle.setRegistrationNo(registrationNo);
		//vehicle.setVehicleId(vehicleId);
		
		vehicle.setBrand("Maruti suzuki");
		vehicle.setModelNo("Dzire");
		vehicle.setVehicleType("road");
//		vehicle.setInsurance(insurance);
//		vehicle.setRegistrationNo(registrationNo);
//		vehicle.setVehicleId(vehicleId);
		
		
		vehicle.setBrand("Hyundai");
		vehicle.setModelNo("Grand i10");
		vehicle.setVehicleType("road");
//		vehicle.setInsurance(insurance);
//		vehicle.setRegistrationNo(registrationNo);
//		vehicle.setVehicleId(vehicleId);

	}
}
