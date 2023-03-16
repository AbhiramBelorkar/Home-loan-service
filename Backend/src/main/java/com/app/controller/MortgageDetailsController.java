package com.app.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.MortgageDetails;
import com.app.service.MortgageDetailsServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
@RequestMapping("/MortgageDetails")
public class MortgageDetailsController {
	
	@Autowired
	private MortgageDetailsServiceI mDetailsServiceInterface;
	
	//http://localhost:9595/MortgageDetails/mortgagedetails
	@PostMapping(value="/mortgagedetails", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String  saveMortgageDetails(
			@RequestPart("mortgagePropertyProof")MultipartFile file1,
			@RequestPart("mortgagePropertyInsurance")MultipartFile file2,
			@RequestPart("cust")String cust) throws JsonMappingException, JsonProcessingException
	{
		    ObjectMapper objectMapper= new ObjectMapper();
		    
		    MortgageDetails mortgage = objectMapper.readValue(cust, MortgageDetails.class);
		    
//{"mortgageId": 0,"mortgagePropertyValue": 300000000,"mortgagePropertyType": "Land","mortgageLoanOnProperty":100000}		    
		    
		    try {
				mortgage.setMortgagePropertyProof(file1.getBytes());
				mortgage.setMortgagePropertyInsurance(file2.getBytes());
				
				MortgageDetails mdata= mDetailsServiceInterface.saveMortgageDetails(mortgage);
				return "saved Successfully";
				
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		
		
	}
	
	@GetMapping(value="/mortgagedetails",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<MortgageDetails> getAllMortgageDetails()
	{
		List<MortgageDetails> mortgage= mDetailsServiceInterface.getAllMortgageDetails();
		     return mortgage;
	}
	
	@GetMapping(value="/mortgagedetails/{mortgageId}")
	public MortgageDetails getSingleMortgageDetails(@PathVariable ("mortgageId")Integer mortgageId)
	{
		MortgageDetails doc	=mDetailsServiceInterface.getSingleMortgageDetails(mortgageId);
		return doc;
		
	}
	
	@DeleteMapping(value="/mortgagedetails/{mortgageId}")
	public String deleteMortgageDetails(@PathVariable Integer mortgageId)
	{
		mDetailsServiceInterface.deleteMortgageDetails(mortgageId);
		
		return "delete Successfully";
		
	}
	
	@PutMapping(value="/mortgagedetails/{mortgageId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String  updateMortgageDetails(
			@RequestPart("mortgagePropertyProof")MultipartFile file1,
			@RequestPart("mortgagePropertyInscurance")MultipartFile file2,
			@RequestPart("cust")String cust, @PathVariable("mortgageId")Integer mortgageId) throws JsonMappingException, JsonProcessingException
	{
		    ObjectMapper objectMapper= new ObjectMapper();
		    MortgageDetails mortgage = objectMapper.readValue(cust, MortgageDetails.class);
		    try {
				mortgage.setMortgagePropertyProof(file1.getBytes());
				mortgage.setMortgagePropertyInsurance(file2.getBytes());
				
				MortgageDetails mdata= mDetailsServiceInterface.updateMortgageDetails(mortgage);
				mortgage.setMortgageId(mortgageId);
				return "update Successfully";
				
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		
		
	}
	


}

