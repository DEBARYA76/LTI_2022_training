package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
public class Passport {

	@Id
	@SequenceGenerator(name="pass_seq",initialValue=5005, allocationSize=1)
	@GeneratedValue(generator = "pass_seq",strategy=GenerationType.SEQUENCE)
	int passportNo;
	
	
	LocalDate validFrom;
	LocalDate validTo;
	String placeOfIssue;
	
	
//	@OneToOne
//	@JoinColumn(name="person_id")
//	Person  person ;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	Person person;

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public LocalDate getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}
	public LocalDate getValidTo() {
		return validTo;
	}
	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}
	public String getPlaceOfIssue() {
		return placeOfIssue;
	}
	public void setPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}
	
}
