package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.CustomerVerification;



public interface CustomerVerificationServiceI {

	public CustomerVerification saveCustomerVerfication(CustomerVerification cv);

	public List<CustomerVerification> getAllCustomerVerfication();

	public void deleteCustomerVerfication(Integer verificationID);

	public Optional<CustomerVerification> getSingleCustomerVerification(CustomerVerification cv,Integer verificationID);

	public CustomerVerification updateCustomerVerification(Integer verificationID, CustomerVerification cv);

}
