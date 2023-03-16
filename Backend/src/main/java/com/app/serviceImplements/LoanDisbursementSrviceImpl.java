package com.app.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.LoanDisbursement;
import com.app.repository.LoanDisbursementRepository;
import com.app.service.LoanDisbursementServiceInterface;


@Service
public class LoanDisbursementSrviceImpl implements LoanDisbursementServiceInterface {
	
	@Autowired
	private LoanDisbursementRepository loandisbursementRepository;

	@Override
	public LoanDisbursement saveLoanDisbursement(LoanDisbursement loandisbursement) {
		       
		return loandisbursementRepository.save(loandisbursement);
	}

	@Override
	public List<LoanDisbursement> getAllLoanDisbursement() {
		
		return loandisbursementRepository.findAll();
	}

	

	@Override
	public Optional<LoanDisbursement> getLoanDisbursement(LoanDisbursement loanDisbursement, Integer agreementId) {
		Optional<LoanDisbursement> op=loandisbursementRepository.findById(agreementId);
		
		return op ;
	}

}
