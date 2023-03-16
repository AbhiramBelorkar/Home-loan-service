package com.app.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.MortgageDetails;
import com.app.repository.MortgageDetailsRepository;
import com.app.service.MortgageDetailsServiceI;


@Service
public class MortgageDetailsServiceIml  implements MortgageDetailsServiceI{
	
	@Autowired
	private MortgageDetailsRepository mDetailsRepository;

	@Override
	public MortgageDetails saveMortgageDetails(MortgageDetails mortgage) {
		
		MortgageDetails details = mDetailsRepository.save(mortgage);
		return details;
	}

	@Override
	public List<MortgageDetails> getAllMortgageDetails() {
		
		return mDetailsRepository.findAll();
	}

	@Override
	public MortgageDetails getSingleMortgageDetails(Integer mortgageId) {
		
		return mDetailsRepository.findById(mortgageId).get();
	}

	@Override
	public void deleteMortgageDetails(Integer mortgageId) {
		
		mDetailsRepository.deleteById(mortgageId);
		
		
	}

	@Override
	public MortgageDetails updateMortgageDetails(MortgageDetails mortgage) {
		
		
		  
		return mDetailsRepository.save(mortgage);
	}

	

	

	

	
}
