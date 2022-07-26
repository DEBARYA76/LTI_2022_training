package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Transaction {

	@Id
	@SequenceGenerator(name = "tran_seq", initialValue = 1100, allocationSize = 1)
	@GeneratedValue(generator = "tran_seq", strategy = GenerationType.SEQUENCE)
	int TransactionId;
	LocalDate date;

	Transactiontype type;
	double amount;

	@ManyToOne
	@JoinColumn(name = "accountNo")
	Account account;

	public int getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Transactiontype getType() {
		return type;
	}

	public void setType(Transactiontype type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
