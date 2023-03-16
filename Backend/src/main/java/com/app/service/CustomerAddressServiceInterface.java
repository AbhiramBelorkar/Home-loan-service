package com.app.service;

import java.util.List;

import com.app.pojos.CustomerAddress;



public interface CustomerAddressServiceInterface {

	public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress);

	public List<CustomerAddress> getAllCustomerAddress();

	public CustomerAddress getSingleCustomerAddress(Integer customerAddressId);

	public void deleteCustomerAddress(Integer customerAddressId);

	public CustomerAddress updateCustomerAddress(Integer customerAddressId, CustomerAddress customer);

	

	

}
