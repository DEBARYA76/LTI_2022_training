package com.lti.dao;

import java.util.List;

import com.lti.entity.Passport;
import com.lti.entity.Person;

public interface PersonDao {

	
	Person addNewPerson(Person person);
	Person findPersonById(int PersonId);
	Person findPersonByPhoneNo(String phoneNo);
	List<Person> viewAllPersons();
	Person updateAPerson(Person person);
  Passport	addNewPassportForAPerson(Passport passport);
  Passport findPassportByPersonId(int PersonId);
void showPersonandPassportDetials();
List<PersonPassportDto> showPersonAndPassportDetails();
}
