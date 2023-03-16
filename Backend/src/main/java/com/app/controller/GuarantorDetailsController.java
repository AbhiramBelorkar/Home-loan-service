package com.app.controller;

import java.util.List;

import java.util.Optional;

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

import com.app.pojos.GuarantorDetails;
import com.app.service.GuarantorDetailsServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping("/GuarantorDetails")
public class GuarantorDetailsController {
	
	@Autowired
	private GuarantorDetailsServiceI guarantordetailsserviceInterface;
	
	
	@PostMapping(value="/guarantordetails")
	public GuarantorDetails saveGuarantorDetails(@RequestBody GuarantorDetails guarantordetails)
	{
		
		
		GuarantorDetails guarantorDetails=guarantordetailsserviceInterface.saveGuarantorDetails(guarantordetails);
		
		
		return guarantorDetails;
	}
	
	
	@GetMapping(value="/guarantordetails")
	public List<GuarantorDetails> getAllGuarantorDetails()
	{
		List<GuarantorDetails>GuarantorDetails=guarantordetailsserviceInterface.getAllGuarantorDetails();
		return GuarantorDetails;
	}
	
	@GetMapping(value="/guarantordetails/{GuarantorId}")
	public Optional<GuarantorDetails> getSingleGuarantorDetails(@RequestBody GuarantorDetails GuarantorDetails,@PathVariable Integer GuarantorId )
	{
		Optional<GuarantorDetails> guarantorDetails= guarantordetailsserviceInterface.getGuarantorDetails(GuarantorDetails,GuarantorId);
		return guarantorDetails;
	}
	
	@DeleteMapping("/guarantordetails/{GuarantorId}")
	public void deleteGuarantorDetails(@PathVariable Integer GuarantorId)
	{
		guarantordetailsserviceInterface.deleteGuarantorDetails(GuarantorId);
		
	}
	
	@PutMapping(value="guarantordetails/{GuarantorId}")
	public GuarantorDetails updateGuarantorDetails(@PathVariable Integer GuarantorId,@RequestBody GuarantorDetails guarantordetails  )
	{
		GuarantorDetails guarantor=guarantordetailsserviceInterface.updateGuarantorDetails( GuarantorId,guarantordetails);
		return guarantor;
	}
	

}
