package com.app.serviceImplements;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Cibil;
import com.app.pojos.EnquiryDetails;
import com.app.repository.CibilRepository;
import com.app.repository.EnquiryDetailsRepository;
import com.app.service.CibilIService;


@Service
public class CibilServiceImpl implements CibilIService {
	
	@Autowired
	private CibilRepository cr;
	
	@Autowired
	private EnquiryDetailsRepository edr;

	@Override
	public Cibil saveData(Cibil c) {
		
		EnquiryDetails enquiryDetails=edr.findById(c.getCibilId()).orElse(null);
		
		//CIbil Score
		int min=600;
		int max=900;
		int a	=(int) (Math.random()*(max-min+1)+min);
		
		c.setCibilScore(a);
		
		// Set Date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
	    
		c.setCibilScoreDateTime(formatter.format(date));
		
		c.setRemark("PENDING");
		System.out.println("CIBIL SCORE = "+a+"     From Object = "+c.getCibilScore());
		
		if(a>=750) {
		c.setStatus("Valid");
		enquiryDetails.setCibil(c);
		
		edr.save(enquiryDetails);
		
		System.out.println("IN CIBIL Serviceimpl = "+enquiryDetails);
		return c;
		}
		else{
			c.setStatus("Invalid");
			enquiryDetails.setCibil(c);
			edr.save(enquiryDetails);
			System.out.println("IN CIBIL Serviceimpl = "+enquiryDetails);
			return c;
		}
	
	
		
	}

	@Override
	public Iterable<Cibil> getAllCibilData() {
	Iterable<Cibil> c	=cr.findAll();
		return c;
	}

	@Override
	public Cibil getSingleData(Integer cibilId) {
	Cibil c	=cr.findById(cibilId).get();
		return c;
	}

	

	

	
	
}
