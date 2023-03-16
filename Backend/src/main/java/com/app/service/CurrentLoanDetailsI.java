package com.app.service;

import com.app.pojos.CurrentLoanDetails;

public interface CurrentLoanDetailsI {
	
	public CurrentLoanDetails saveCurrentLoanDetailsData(CurrentLoanDetails cld);
	
	public Iterable<CurrentLoanDetails> getAllCurrentLoanDetailsData();
	
	
	
	public CurrentLoanDetails getSinglecurrentLoanDetailsData(Integer loanId);
	
	public String deleteCurrentLoanDetailsData(Integer loanId);

	public CurrentLoanDetails updateData(CurrentLoanDetails c, Integer loanId);

}
