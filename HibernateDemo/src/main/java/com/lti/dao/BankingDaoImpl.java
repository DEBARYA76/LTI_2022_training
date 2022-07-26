package com.lti.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.entity.Account;
import com.lti.entity.Address;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;


public class BankingDaoImpl implements BankingDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public BankingDaoImpl() {
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Customer addOrUpdateCustomer(Customer customer) {
		tx.begin();
		Customer customerPersisted = em.merge(customer);
		tx.commit();
		return customerPersisted;
	}

	public Customer addAddressForACustomer(int customerId, Address address) {
		tx.begin();
		Customer customer = em.find(Customer.class, customerId);
		address.setCustomer(customer);
		customer.setAddress(address);
		Customer customerPersisted = em.merge(customer);
		tx.commit();
		return customerPersisted;
	}

	public Customer addNewAccountForAnExistingCustomer(int customerId, Account account) {
		tx.begin();
		Customer customer = em.find(Customer.class, customerId);
		List<Account> updatedAccount = customer.getAccounts();
		updatedAccount.add(account);
		customer.setAccounts(updatedAccount);
		Customer customerPersisted = em.merge(customer);
		tx.commit();
		return customerPersisted;
	}

	public Customer addNewCustomerWithNewAccount() {
		
		return null;
	}

	public Customer getCustomerDetailsByAccountNo(int accountNo) {
		return em.find(Customer.class, accountNo);
	}

	public List<Account> getAllAccountsOfACustomer(int customerId) {
		String jpql = "select acc from Account acc where acc.customerId=:cid";
		TypedQuery<Account> qry = em.createQuery(jpql, Account.class);
		qry.setParameter("cid", customerId);
		List<Account> accounts = qry.getResultList();
		return accounts;
	}

	public Account addNewTransactionForAnAccount(int accountNo, Transaction transaction) {
		tx.begin();
		Account account = em.find(Account.class, accountNo);
		List<Transaction> updatedTransactions = account.getTransaction();
		updatedTransactions.add(transaction);
		account.setTransaction(updatedTransactions);
		tx.commit();
		return account;
	}

	public List<Transaction> viewAllTransactionsOfAnAccount(int accountNo) {
		String jpql = "select trx from Transaction trx where trx.accountNo=:ano";
		TypedQuery<Transaction> qry = em.createQuery(jpql, Transaction.class);
		qry.setParameter("ano", accountNo);
		List<Transaction> transactions = qry.getResultList();
		return transactions;
	}

	public Account getAccountDetailsOfATransaction(int transactionId) {
		return em.find(Transaction.class, transactionId).getAccount();
	}

	public Customer getCustomerDetailsOfATransaction(int transactionId) {
		return em.find(Customer.class, em.find(Transaction.class, transactionId).getAccount().getAccountNo());
	}
}
