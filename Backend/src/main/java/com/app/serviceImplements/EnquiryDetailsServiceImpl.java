package com.app.serviceImplements;

import java.util.List;
import java.util.Optional;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.EnquiryDetails;
import com.app.repository.EnquiryDetailsRepository;
import com.app.service.EnquiryDetailsServiceI;

@Service
public class EnquiryDetailsServiceImpl implements EnquiryDetailsServiceI {

	@Autowired
	private EnquiryDetailsRepository edr;

	@Override
	public EnquiryDetails saveEnquiryDetails(EnquiryDetails enqury)
	{
		
		return edr.save(enqury);
	}

	@Override
	public EnquiryDetails getSingleEnquiryDetails(int id)
	{
	   Optional<EnquiryDetails> e1 = edr.findById(id);
		return e1.get();
	}

	@Override
	public List<EnquiryDetails> getAllEnquiryDetails()
	{
		
		return edr.findAll();
	}

	@Override
	public void deleteEnquiry(int id) 
	{
	    edr.deleteById(id);
		 
	}

	
}
