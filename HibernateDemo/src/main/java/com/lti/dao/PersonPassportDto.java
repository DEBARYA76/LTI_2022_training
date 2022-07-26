package com.lti.dao;

import java.time.LocalDate;

public class PersonPassportDto {
	int personId;

	String personName;
	int passportNo;

	LocalDate validFrom;

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

	public int getPassportNo() {

	return  passportNo;
	}
	public void setPassportNo(int passportNo) {

		this.passportNo = passportNo;

	}

	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}

	public LocalDate getValidFrom() {

		return validFrom;
	}
}
