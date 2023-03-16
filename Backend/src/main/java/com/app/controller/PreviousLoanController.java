package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.PreviousLoan;
import com.app.service.PreviousLoanServiceInterface;


@CrossOrigin("*")
@RestController
@RequestMapping("/PreviousLoanController")
public class PreviousLoanController {
	
	@Autowired
	private PreviousLoanServiceInterface previousLoanServiceInterface;
	
	@PostMapping(value="/previousloan")
	public PreviousLoan savePreviousLoan(@RequestBody PreviousLoan previousloan)
	{
		PreviousLoan loan = previousLoanServiceInterface.savePreviousLoan(previousloan);
		
		return loan;
	}
	
	@GetMapping(value="/previousloan")
	public List<PreviousLoan> getAllPreviousLoan()
	{
		List<PreviousLoan> loan=previousLoanServiceInterface.getAllPreviousLoan();
		return loan;
		
	}
	
	@GetMapping(value="/previousloan/{previousLoanId}")
	public PreviousLoan getSinglePreviousLoan(@PathVariable("previousLoanId")Integer previousLoanId)
	{
		PreviousLoan loan=previousLoanServiceInterface.getSinglePreviousLoan(previousLoanId);
		return loan;
	}
	
	@DeleteMapping(value="/previousloan/{previousLoanId}")
	public String deletePreviousLoan(@PathVariable("previousLoanId")Integer previousLoanId)
	{
		 previousLoanServiceInterface.deletePreviousLoan(previousLoanId);
		return "deleted Successfully";
	}

	 @PutMapping(value="/previousloan/{previousLoanId}")
	 public PreviousLoan updatePreviousLoan(@RequestBody PreviousLoan loan,@PathVariable("previousLoanId")Integer previousLoanId)
	 { 
		  PreviousLoan pre =  previousLoanServiceInterface.updatePreviousLoan(loan,previousLoanId);
		  return pre;
		  
	 }
}
