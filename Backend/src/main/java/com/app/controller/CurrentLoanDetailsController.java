package com.app.controller;

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

import com.app.pojos.CurrentLoanDetails;
import com.app.service.CurrentLoanDetailsI;




@CrossOrigin("*")
@RequestMapping(value="/currentloandetailscontroller")
@RestController
public class CurrentLoanDetailsController {
	
	
	@Autowired
	private CurrentLoanDetailsI cls;
	
	
	
	@PostMapping("/currentLoanDetails")
	public CurrentLoanDetails saveCurrentLoanDetailsData(@RequestBody CurrentLoanDetails cld ) {
		
		
		CurrentLoanDetails cu = cls.saveCurrentLoanDetailsData(cld);
		return cu;
	}
	
	
	
	@GetMapping("/currentLoanDetails")
	public  Iterable<CurrentLoanDetails> getAllCurrentLoanDetailsData(){
		
	Iterable<CurrentLoanDetails> cldlist = cls.getAllCurrentLoanDetailsData();
	
	return cldlist;
		
	}
	
	
	
	
	@PutMapping("/currentLoanDetails/{loanId}")
	public String updateCurrentLoanDetailsData(@PathVariable("loanId") Integer loanId, @RequestBody CurrentLoanDetails c ) {
		
		 cls.updateData(c,loanId);
		
		return "update successfully";
	}
	
	
	
	
	@GetMapping("/currentLoanDetails/{loanId}")
	public CurrentLoanDetails getSinglecurrentLoanDetailsData(@PathVariable Integer loanId) {
		
		 CurrentLoanDetails loanSingle	=cls.getSinglecurrentLoanDetailsData(loanId);
		return loanSingle;
	}
	
	
	
	
	
	@DeleteMapping("/currentLoanDetails/{loanId}")
	public String deleteCurrentLoanDetailsData(@PathVariable Integer loanId) {
		
		cls.deleteCurrentLoanDetailsData(loanId);
		return "Delete Succefully...!!";
		
	}

}
