package com.app.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.LoanDisbursement;
import com.app.service.LoanDisbursementServiceInterface;



@CrossOrigin("*")
@RestController
@RequestMapping("/LoanDisbursement")
public class LoanDisbursementController {
	
	@Autowired
	private LoanDisbursementServiceInterface loandisbursementserviceInterface ;
	


	@PostMapping(value="/loandisbursement")
	public LoanDisbursement saveLoanDisbursement(@RequestBody LoanDisbursement loandisbursement)
	{
		LoanDisbursement ld = loandisbursementserviceInterface.saveLoanDisbursement(loandisbursement);
		
		return ld;
	}
	
	
	@GetMapping(value="/loandisbursement")
	public List<LoanDisbursement> getAllLoanDisbursement()
	{
		List<LoanDisbursement>loanDisbursement = loandisbursementserviceInterface.getAllLoanDisbursement();
		return loanDisbursement
				;
	}
	
	@GetMapping(value="/loandisbursement/{agreementId}")
	public Optional<LoanDisbursement> getSingleLoanDisbursement(@RequestBody LoanDisbursement LoanDisbursement,@PathVariable Integer agreementId )
	{
		Optional<LoanDisbursement> loan= loandisbursementserviceInterface.getLoanDisbursement(LoanDisbursement,agreementId);
		return loan;
	}
	
	
}
