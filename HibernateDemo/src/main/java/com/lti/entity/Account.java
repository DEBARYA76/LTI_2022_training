package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {

	@Id
	@SequenceGenerator(name = "acc_seq", initialValue = 400, allocationSize = 1)
	@GeneratedValue(generator = "acc_seq", strategy = GenerationType.SEQUENCE)
	int accountNo;

	AccountType type;
	double balance;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;

	@OneToMany(mappedBy="account")
	List<Transaction> transaction;
	
	
	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
