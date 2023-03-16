package com.app.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.pojos.CurrentLoanDetails;
import com.app.repository.CurrentLoanDetailsRepository;
import com.app.service.CurrentLoanDetailsI;



@Service
public class CurrentLoanDetailsServiceImpl implements CurrentLoanDetailsI {
	
	@Autowired
	private CurrentLoanDetailsRepository cldr;

	@Override
	public CurrentLoanDetails saveCurrentLoanDetailsData(CurrentLoanDetails cld) {
		CurrentLoanDetails cur	= cldr.save(cld);
		return cur;
	}

	@Override
	public Iterable<CurrentLoanDetails> getAllCurrentLoanDetailsData() {
		
	Iterable<CurrentLoanDetails> list=cldr.findAll();
	
		return list;
	}
	
	
	@Override
	public CurrentLoanDetails getSinglecurrentLoanDetailsData(Integer loanId) {
		CurrentLoanDetails singleData = cldr.findById(loanId).get();
		return  singleData;
	}

	
	@Override
	public String deleteCurrentLoanDetailsData(Integer loanId) {
		cldr.deleteById(loanId);
		return "Successfully Deleted...";
		
	}

	
	@Override
	public CurrentLoanDetails updateData(CurrentLoanDetails c, Integer loanId) {
		      c.setCurrentloanId(loanId);
		      
		return cldr.save(c);
	}

	
	
	

	

	}
