package com.app.service;

import java.util.List;

import com.app.pojos.MortgageDetails;


public interface MortgageDetailsServiceI{

	public MortgageDetails saveMortgageDetails(MortgageDetails mortgage);

	public List<MortgageDetails> getAllMortgageDetails();

	public MortgageDetails getSingleMortgageDetails(Integer mortgageId);

	public void deleteMortgageDetails(Integer mortgageId);

	public MortgageDetails updateMortgageDetails(MortgageDetails mortgage);

	

	
	

}
