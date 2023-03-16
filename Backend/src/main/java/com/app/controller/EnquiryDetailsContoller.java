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

import com.app.pojos.EnquiryDetails;
import com.app.service.EnquiryDetailsServiceI;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EnquiryDetailsContoller {
	
	
	
	@Autowired
	private EnquiryDetailsServiceI edi;
	
	
	//http://localhost:8080/api/enquiry
	@PostMapping("/enquiry")
	public EnquiryDetails saveEnquiryDetails(@RequestBody EnquiryDetails enqury)
	{
		EnquiryDetails eq=edi.saveEnquiryDetails(enqury);
		return eq;
	}
	
	@GetMapping("/enquiry/{id}")
	public EnquiryDetails getSingleEnquiryDetails(@PathVariable int id)
	{
		EnquiryDetails e=edi.getSingleEnquiryDetails(id);
		return e;
	}
	
	@GetMapping("/enquiry")
	public List <EnquiryDetails> getAllEnquiryDetails()
	{
		List<EnquiryDetails> enquirys=edi.getAllEnquiryDetails();
		return enquirys;
	}
	
	@DeleteMapping("/enquiry/{id}")
	public void deleteEnquiry(@PathVariable("id") int id)
	{
		edi.deleteEnquiry(id);	 
	}
	
	@PutMapping("/enquiry/{id}")
	public void editEnquiryApprove(@PathVariable ("id") int id)
	{
		
       EnquiryDetails enq = edi.getSingleEnquiryDetails(id);
		
		enq.getCibil().setRemark("APPROVED");
		
		System.out.println(edi.saveEnquiryDetails(enq)); 
		System.out.println("put method approve enq "+id);
	}
	
	@PutMapping("/enquiryreject/{id}")
	public void editEnquiryReject(@PathVariable ("id") int id)
	{
		
		EnquiryDetails enq = edi.getSingleEnquiryDetails(id);
		
		enq.getCibil().setRemark("REJECT");
		
		edi.saveEnquiryDetails(enq);
		System.out.println("put method reject enq "+id);	
	}
}
