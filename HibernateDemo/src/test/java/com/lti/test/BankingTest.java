package com.lti.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.lti.dao.BankingDao;
import com.lti.dao.BankingDaoImpl;
import com.lti.entity.Address;
import com.lti.entity.Customer;

public class BankingTest {
	
	BankingDao dao = new BankingDaoImpl();

	@Test
	public void addOrUpdateCustomer(){
		Customer customer = new Customer();
		customer.setName("Arya");
		customer.setAadhaarNo(25857895);;
		customer.setEmail("pal.arya@gmail.com");
		customer.setPhone(1234567890);
		
		Customer persistedCustomer = dao.addOrUpdateCustomer(customer);
		
		System.out.println(persistedCustomer.getName() + " " + persistedCustomer.getCustomerId() + " " +persistedCustomer.getAadhaarNo());
		
		assertNotNull(persistedCustomer);
	}
	
	@Test
	public void addAddressForACustomer(){
		Address address = new Address();
		address.setHouseNo(452);
		address.setBuildingName("DB, Sector 11");
		address.setCity("SALT LAKE");
		address.setState("KOKKTAA");
		Customer persistedCustomer = dao.addAddressForACustomer(2001, address);
		System.out.println(persistedCustomer.getName() + " " + persistedCustomer.getCustomerId() + " " +persistedCustomer.getAadhaarNo()  + persistedCustomer.getAddress());
		assertNotNull(persistedCustomer);
	}
	
	@Test
	public void addNewAccountForAnExistingCustomer(){
		
	}
	
	@Test
	public void addnewCustomerWithNewAccount(){
		
	}
	
	@Test
	public void getCustomerDetailsByAccountNo(){
		
	}
	
	@Test
	public void getAllAccountsOfACustomer(){
		
	}
	
	@Test
	public void addnewTransactionForAnAccount(){
		
	}
	
	@Test
	public void viewAllTransactionsOfAnAccount(){
		
	}
	
	@Test
	public void getAccountDetailsOfATransaction(){
		
	}
	
	@Test
	public void getCustomerDetailsOfATransaction(){
		
	}

}