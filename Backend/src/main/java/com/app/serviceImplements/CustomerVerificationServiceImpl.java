package com.app.serviceImplements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CustomerVerification;
import com.app.repository.CustomerVerificationRepository;
import com.app.service.CustomerVerificationServiceI;



@Service
public class CustomerVerificationServiceImpl implements CustomerVerificationServiceI
{

	@Autowired
	private CustomerVerificationRepository cvr;

	@Override
	public CustomerVerification saveCustomerVerfication(CustomerVerification cv) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
	    cv.setVerificationDate(sdf.format(date));
	    
		CustomerVerification cVerication=cvr.save(cv);
		
		return cVerication;
	}

	@Override
	public List<CustomerVerification> getAllCustomerVerfication() {
		
		return cvr.findAll();
	}

	@Override
	public void deleteCustomerVerfication(Integer verificationID) {
		cvr.deleteById(verificationID);
		
	}

	@Override
	public Optional<CustomerVerification> getSingleCustomerVerification(CustomerVerification cv,Integer verificationID) {
		     
		Optional<CustomerVerification> cvf= cvr.findById(verificationID);
		return cvf;
	}

	@Override
	public CustomerVerification updateCustomerVerification(Integer verificationID, CustomerVerification cv) {
		      
		      cv.setVerificationID(verificationID);
		      
		     return  cvr.save(cv);
		
	}
}
