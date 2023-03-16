package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.CustomerAddress;
import com.app.service.CustomerAddressServiceInterface;


@CrossOrigin("*")
@RestController
@RequestMapping("/CustomerAddressController")
public class CustomerAddressController {
	
	@Autowired
	private CustomerAddressServiceInterface customerAddressServiceInterface;
	
	
	
	@PostMapping(value="/customeraddress")
	public CustomerAddress saveCustomerAddress(@RequestBody CustomerAddress CustomerAddress)
	{
		System.out.println("LOCAL ADDRESS "+CustomerAddress.getLocalAddress().getState());
		System.out.println("PERMANENT ADDRESS "+CustomerAddress.getPermanentAddress().getCityname());
		
		CustomerAddress addr = customerAddressServiceInterface.saveCustomerAddress(CustomerAddress);
		  return addr;
		  
	}
	
	@GetMapping(value="/customeraddress")
	public List<CustomerAddress> getAllCustomerAddress()
	{
		 List<CustomerAddress>list = customerAddressServiceInterface.getAllCustomerAddress();
		 return list;
	}

	@GetMapping(value="/customeraddress/{customerAddressId}")
	public CustomerAddress getSingleCustomerAddress(@PathVariable ("customerAddressId")Integer customerAddressId)
	{
		CustomerAddress addr= customerAddressServiceInterface.getSingleCustomerAddress(customerAddressId);
		return addr;
		
	}
	
	@DeleteMapping(value="/customeraddress/{customerAddressId}")
	public String deleteCustomerAddress(@PathVariable("customerAddressId")Integer customerAddressId)
	{
		customerAddressServiceInterface.deleteCustomerAddress(customerAddressId);
		return "Delete successfully";
	}
	
	@PutMapping(value="/customeraddress/{customerAddressId}")
	public CustomerAddress updateCustomerAddress(@PathVariable("customerAddressId")Integer customerAddressId,@RequestBody CustomerAddress customer)
	{
		CustomerAddress cust = customerAddressServiceInterface.updateCustomerAddress(customerAddressId,customer);
		 return cust;
	}
}
