package com.app.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CustomerAddress;
import com.app.repository.CustomerAddressRepository;
import com.app.service.CustomerAddressServiceInterface;


@Service
public class CustomerAddressSeviceImpl implements CustomerAddressServiceInterface{
	
	@Autowired
	private CustomerAddressRepository cuRepository;

	@Override
	public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress) {
		    
		return cuRepository.save(customerAddress);
	}

	@Override
	public List<CustomerAddress> getAllCustomerAddress() {
		
		return cuRepository.findAll();
	}

	@Override
	public CustomerAddress getSingleCustomerAddress(Integer customerAddressId) {
		
		return cuRepository.findById(customerAddressId).get();
	}

	@Override
	public void deleteCustomerAddress(Integer customerAddressId) {
		
		cuRepository.deleteById(customerAddressId);
		
		
	}

	@Override
	public CustomerAddress updateCustomerAddress(Integer customerAddressId, CustomerAddress customer) {
		      customer.setCustomerAddressId(customerAddressId);
		return cuRepository.save(customer);
	}

}
