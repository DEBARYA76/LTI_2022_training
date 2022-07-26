package com.lti.entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_person")

public class Person {

	@Id
	@Column(name="person_id")
	@GeneratedValue
	int personId;
	@Column(name="person_name")
	String  personName;
	
	@Column(name="person_age")
	int personAge;
	
	@Column(name="person_phone")
	String phoneNo;
	
    @OneToOne(mappedBy ="person")
    Passport passport;
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	
	
}
