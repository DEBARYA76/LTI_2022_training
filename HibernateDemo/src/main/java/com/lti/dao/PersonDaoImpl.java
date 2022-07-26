package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.entity.Passport;
import com.lti.entity.Person;

public class PersonDaoImpl implements PersonDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	Query qry;

	public PersonDaoImpl() {
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
	}

	public Person addNewPerson(Person person) {
		// TODO Auto-generated method stub
		tx = em.getTransaction();
		tx.begin();
		em.persist(person);
		tx.commit();

		return null;
	}

	public Person findPersonById(int personId) {
		// TODO Auto-generated method stub

		Person p = em.find(Person.class, personId);
		return p;

	}

	public List<Person> viewAllPersons() {
		// TODO Auto-generated method stub

		String jpql = "select p from Person p";
		qry = em.createQuery(jpql);
		List<Person> persons = qry.getResultList();
		return persons;
	}

	public Person updateAPerson(Person person) {
		tx = em.getTransaction();
		tx.begin();
		Person persistedPerson = em.merge(person);
		tx.commit();
		return persistedPerson;
	}

	public Person findPersonByPhoneNo(String phoneNo) {
		// TODO Auto-generated method stub

		String jpql = "select p from Person p where p.phoneNo:=phno";
		qry = em.createQuery(jpql);
		qry.setParameter("phno", phoneNo);
		Person p = (Person) qry.getSingleResult();
		return p;
	}

	public Passport addNewPassportForAPerson(Passport passport) {

		tx = em.getTransaction();
		tx.begin();
		Passport passport2 = em.merge(passport);
		tx.commit();
		return passport2;
	}

	public Passport findPassportByPersonId(int personId) {
		Passport passport = null;
		// Person person=findPersonById(personId);
		String jpql = "select ps from Passport ps where ps.person.personId=:pid";

		try {
			qry = em.createQuery(jpql);
			qry.setParameter("pid", personId);
			passport = (Passport) qry.getSingleResult();
		} catch (Exception e) {
			return passport;
		}

		return passport;
	}

	public void showPersonandPassportDetials() {
		String jpql = "select p,ps from Person p join Passport ps on p.personId=ps.person";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		List<Object[]> allObjects = query.getResultList();

		for (Object[] obj : allObjects) {
			Person p = (Person) obj[0];
			Passport ps = (Passport) obj[1];
			System.out.println(p.getPersonId() + " " + p.getPersonName());
		}

	}

	public List<PersonPassportDto> showPersonAndPassportDetails()

	{
		String jpql = "select p,ps from Person p join Passport ps on p.personId=:ps.person.personId";

		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

		List<Object[]> allobjects = query.getResultList();

		List<PersonPassportDto> personPassportDetails = new ArrayList<>();

		PersonPassportDto dto = null;
		for (Object[] obj : allobjects) {

			Person p = (Person) obj[0];

			Passport ps = (Passport) obj[1];
			System.out.println(p.getPersonId() + " " + p.getPersonName() + " " +

					ps.getPassportNo() + " " + ps.getValidFrom());

			dto = new PersonPassportDto();

			dto.setPersonId(p.getPersonId());

			dto.setPersonName(p.getPersonName());
			dto.setPassportNo(ps.getPassportNo());
			dto.setValidFrom(ps.getValidFrom());

			personPassportDetails.add(dto);

			
			
		}
		
			return personPassportDetails;
		}
	
}
