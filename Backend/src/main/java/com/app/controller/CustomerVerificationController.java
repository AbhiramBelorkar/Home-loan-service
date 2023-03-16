package com.app.controller;

import java.util.List;

import java.util.Optional;

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

import com.app.pojos.CustomerVerification;
import com.app.service.CustomerVerificationServiceI;


@CrossOrigin("*")
@RestController
@RequestMapping("/customerVerification")
public class CustomerVerificationController {
	
	@Autowired
	private CustomerVerificationServiceI svi;
	
	
	@PostMapping(value="/saveCustomerVerification")
	public CustomerVerification saveCustomerVerfication(@RequestBody CustomerVerification cv)
	{
		CustomerVerification cVerification=svi.saveCustomerVerfication(cv);
		
		return cVerification;
	}
	
	
	@GetMapping(value="/getcustomerVerification")
	public List<CustomerVerification> getAllCustomerVerfication()
	{
		List<CustomerVerification>customerverify=svi.getAllCustomerVerfication();
		return customerverify;
	}
	
	
	
	@GetMapping(value="/getSinglecustomerVerification/{verificationID}")
	public CustomerVerification getSingleCustomerVerification(@RequestBody CustomerVerification cv,@PathVariable Integer verificationID )
	{
		Optional<CustomerVerification> cvf= svi.getSingleCustomerVerification(cv,verificationID);
		return cvf.get();
	}
	
	
	
	@DeleteMapping("/deleteCustomerVerfication/{verificationID}")
	public void deleteCustomerVerfication(@PathVariable Integer verificationID)
	{
		svi.deleteCustomerVerfication(verificationID);
		
	}
	
	
	@PutMapping(value="updateCustomerVerfication/{verificationID}")
	public CustomerVerification updateCustomerVerification(@PathVariable Integer verificationID,@RequestBody CustomerVerification cv  )
	{
		CustomerVerification cvf=svi.updateCustomerVerification( verificationID,cv);
		return cvf;
	}
	

}
