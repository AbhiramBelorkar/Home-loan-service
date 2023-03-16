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

import com.app.pojos.EMIDetails;
import com.app.service.EMIDetailsServiceI;


@CrossOrigin("*")
@RestController
@RequestMapping("/emidetailscontroller")
public class EMIDetailsController {

	@Autowired
	private EMIDetailsServiceI edi;
	
	
	
	@PostMapping("/emidetails")
	public EMIDetails saveEMIDetails(@RequestBody EMIDetails ed)
	{
		EMIDetails emid = edi.saveEMIDetails(ed);
		return emid;
	}
	
	
	@GetMapping("/emidetails")
	public Iterable<EMIDetails> getAllEMIDetails()
	{
		Iterable<EMIDetails> list = edi.getAllEMIDetails();
		return list;
	}
	
	@PutMapping("/emidetails/{emiID}")
	public EMIDetails updateEMIDetails(@PathVariable Integer emiID,@RequestBody EMIDetails ed)
	{
		EMIDetails emidet = edi.updateEMIDetails(emiID,ed);
		return emidet;
	}
	
	@GetMapping("/emidetails/{emiID}")
	public EMIDetails getSingleEMIDetails(@PathVariable Integer emiID)
	{
		EMIDetails semid = edi.getSingleEMIDetails(emiID);
		return semid;
	}
	

	@DeleteMapping("/emidetails/{emiID}")
	public String deleteEMIDetails(@PathVariable Integer emiID)
	{
		edi.deleteEMIDetails(emiID);
		return "Delete EMI Details Id";
	}

}
