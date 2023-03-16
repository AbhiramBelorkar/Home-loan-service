package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.LoanDisbursement;



public interface LoanDisbursementServiceInterface {

	 public LoanDisbursement saveLoanDisbursement(LoanDisbursement loandisbursement);

	public List<LoanDisbursement> getAllLoanDisbursement();

	public Optional<LoanDisbursement> getLoanDisbursement(LoanDisbursement loanDisbursement, Integer agreementId);

	
}
