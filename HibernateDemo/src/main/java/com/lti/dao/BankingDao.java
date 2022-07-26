package com.lti.dao;



import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.Address;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;

public interface BankingDao {
	Customer addOrUpdateCustomer(Customer customer);
	Customer addAddressForACustomer(int customerId, Address address);
	Customer addNewAccountForAnExistingCustomer(int customerId, Account account);
	Customer addNewCustomerWithNewAccount();
	Customer getCustomerDetailsByAccountNo(int accountNo);
	List<Account> getAllAccountsOfACustomer(int customerId);
	Account addNewTransactionForAnAccount(int accountNo, Transaction transaction);
	List<Transaction> viewAllTransactionsOfAnAccount(int accountNo);
	Account getAccountDetailsOfATransaction(int transactionId);
	Customer getCustomerDetailsOfATransaction(int transactionId);
}