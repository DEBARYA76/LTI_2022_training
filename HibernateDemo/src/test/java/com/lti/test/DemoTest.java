package com.lti.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.PersonDao;
import com.lti.dao.PersonDaoImpl;
import com.lti.dao.PersonPassportDto;
import com.lti.entity.Passport;
import com.lti.entity.Person;

public class DemoTest {

	PersonDao dao = new PersonDaoImpl();

	@Test
	public void testFindPersonById() {
		Person p = dao.findPersonById(4);
		assertNotNull(p);
		System.out.println(p.getPersonId() + " " + p.getPersonName());
	}

	@Test
	public void findPersonByPhoneNo() {

		Person p = dao.findPersonByPhoneNo("845784");
		assertNotNull(p);
	}

	@Test
	public void viewAllPersons() {
		List<Person> persons = dao.viewAllPersons();
		assertFalse(persons.isEmpty());

	}

	@Test
	public void addNewPassportForAPerson() {
		Person p = dao.findPersonById(5001);
		if (p != null) {
			if (dao.findPassportByPersonId(3) != null) {
				System.out.println("This person has already passport");
			} else {
				Passport passport = new Passport();
				passport.setValidFrom(LocalDate.of(1986, 10, 12));
				passport.setValidTo(LocalDate.of(2016, 10, 11));
				passport.setPlaceOfIssue("Mumbai");

				passport.setPerson(p);
				// p.setPassport(passport);

				dao.addNewPassportForAPerson(passport);
			}
		} else {
			System.out.println("Not Found");
		}

	}
	
	@Test
	public void showPersonandPassport()
	{
		dao.showPersonandPassportDetials() ;
	}
	
	@Test
	public void showPersonAndPassportDetails() {
		List<PersonPassportDto> dtos =dao.showPersonAndPassportDetails();
		
		for(PersonPassportDto dto:dtos) {
			System.out.println(dto.getPersonId()+" "+dto.getPersonName()+" "+dto.getPassportNo()+" "+dto.getValidFrom());
		}
	}
}
