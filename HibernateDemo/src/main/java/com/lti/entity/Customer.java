package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
	int customerId;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	Address address;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	String name;
	int phone;
	int aadhaarNo;
	String email;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(int aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
