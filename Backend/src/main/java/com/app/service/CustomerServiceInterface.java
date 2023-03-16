package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Customer;





public interface CustomerServiceInterface {

	//public Customer saveCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Customer getSingleCustomer(Integer customerId);

	public void deleteCustomer(Integer customerId);


	public Customer saveCustomer(Customer customer);

	public Customer updateCustomer(Customer customer,Integer customerId);

	public ResponseEntity<Customer> sanctionLoan(Customer customer,Integer customerId);

	public Customer loanDisbursement(Customer customer,Integer customerId);

	public Customer sactionletteraccepted(Customer customer,Integer customerId);

	public Customer defaulterCounter(Customer customer, Integer customerId);

	
	
	
	
}
