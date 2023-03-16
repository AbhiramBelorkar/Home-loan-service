package com.app.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.AllPersonalDocuments;
import com.app.pojos.Customer;
import com.app.pojos.EnquiryDetails;
import com.app.pojos.MortgageDetails;
import com.app.pojos.Profession;
import com.app.pojos.PropertyInfo;
import com.app.service.CustomerServiceInterface;
import com.app.service.EnquiryDetailsServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/CustomerController")
public class CustomerController {
	
	@Autowired
	private CustomerServiceInterface customerServiceInterface; 
	
	@Autowired
	private EnquiryDetailsServiceI enquiryDetailsServiceI;
	
//	@PostMapping(value="/onecustomer")
//	public Customer saveCustomer(@RequestBody Customer customer)
//	{
//		Customer cust=customerServiceInterface.saveCustomer(customer);
//		return cust;
//	}
	
//	The main difference is that when the method argument is not a Stringor raw MultipartFile / Part, 
//	@RequestParam relies on typeconversion via a registered Converter or PropertyEditor 
//	while RequestPart relies on HttpMessageConverterstaking into consideration the 'Content-Type' header of the request part.
//	RequestParam is likely to be used with name-value form fields 
//	while RequestPart is likely to be used with parts containing more complex contente.g. JSON, XML).
	
	@PostMapping(value="/customer",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveCustomer(@RequestPart("addressProof")MultipartFile file1,
			@RequestPart("panCard")MultipartFile file2,
			@RequestPart("incomeTax")MultipartFile file3,
			@RequestPart("addharCard")MultipartFile file4,
			@RequestPart("photo")MultipartFile file5,
			@RequestPart("signature")MultipartFile file6,
			@RequestPart("thumb")MultipartFile file7,
			@RequestPart("bankCheque")MultipartFile file8,
			@RequestPart("salarySlips")MultipartFile file9,
			@RequestPart("mortgagePropertyProof")MultipartFile file10,
			@RequestPart("mortgagePropertyInsurance")MultipartFile file11,
			@RequestPart("professionsalaryslips")MultipartFile file12,
			@RequestPart("propertyDocuments")MultipartFile file13,
			@RequestPart("priceProofs")MultipartFile file14,
			@RequestPart("cust")String cust) throws JsonMappingException, JsonProcessingException
	{
		//ObjectMapper provides functionality for reading and writing JSON
		ObjectMapper objectMapper= new ObjectMapper();
		
		 Customer customer = objectMapper.readValue(cust, Customer.class);
		 
	    try {
	    	
	    	AllPersonalDocuments apd=new AllPersonalDocuments();
	    	apd.setAddharCard(file4.getBytes());
	    	apd.setAddressProof(file1.getBytes());
	    	apd.setPanCard(file2.getBytes());
	    	apd.setIncomeTax(file3.getBytes());
	    	apd.setPhoto(file5.getBytes());
	    	apd.setSignature(file6.getBytes());
	    	apd.setThumb(file7.getBytes());
	    	apd.setBankCheque(file8.getBytes());
	    	apd.setSalarySlips(file9.getBytes());
	    	System.out.println(apd);
	    	customer.setAllpersonalDoc(apd);
	    	
	    	MortgageDetails details= new MortgageDetails();
	    	details.setMortgageLoanOnProperty(customer.getMortgageDetails().getMortgageLoanOnProperty());
	    	details.setMortgagePropertyType(customer.getMortgageDetails().getMortgagePropertyType());
	    	details.setMortgagePropertyValue(customer.getMortgageDetails().getMortgagePropertyValue());
	    	details.setMortgagePropertyProof(file10.getBytes());
	    	details.setMortgagePropertyInsurance(file11.getBytes());
	    	
	    	customer.setMortgageDetails(details);
	    	
	    	Profession pro=new Profession();
	    	pro.setProfessionsalaryslips(file12.getBytes());
	    	pro.setProfessiontype(customer.getProfession().getProfessiontype());
	    	pro.setProfessionDesignation(customer.getProfession().getProfessionDesignation());
	    	pro.setProfessionsalaryType(customer.getProfession().getProfessionsalaryType());
	    	pro.setProfessionsalary(customer.getProfession().getProfessionsalary());
	    	pro.setProfessionworkingperiod(customer.getProfession().getProfessionworkingperiod());
	    	customer.setProfession(pro);
	    	
	    	PropertyInfo proinfo=new PropertyInfo();
	    	proinfo.setConstructionArea(customer.getPropertyinfo().getConstructionArea());
	    	proinfo.setConstructionPrice(customer.getPropertyinfo().getConstructionPrice());
	    	proinfo.setPropertyArea(customer.getPropertyinfo().getPropertyArea());
	    	proinfo.setPropertyPrice(customer.getPropertyinfo().getPropertyPrice());
	    	proinfo.setPropertyType(customer.getPropertyinfo().getPropertyType());
	    	proinfo.setPropertyAddress(customer.getPropertyinfo().getPropertyAddress());
	    	
	    	proinfo.setPropertyDocuments(file13.getBytes());
	    	proinfo.setPriceProofs(file14.getBytes());
	    	customer.setPropertyinfo(proinfo);
	    	
	    	
	    	System.out.println("ENQUIRY ID "+customer.getEnquiryDetails().getId());
	    	
	    	EnquiryDetails enq = enquiryDetailsServiceI.getSingleEnquiryDetails(customer.getEnquiryDetails().getId());
	    	customer.setEnquiryDetails(enq);
	    	
//			customer.getAllpersonalDoc().setAddressProof(file1.getBytes());
//			customer.getAllpersonalDoc().setPanCard(file2.getBytes());
//			customer.getAllpersonalDoc().setIncomeTax(file3.getBytes());
//			customer.getAllpersonalDoc().setAddharCard(file4.getBytes());
//			customer.getAllpersonalDoc().setPhoto(file5.getBytes());
//			customer.getAllpersonalDoc().setThumb(file7.getBytes());
//			customer.getAllpersonalDoc().setBankCheque(file8.getBytes());
//			customer.getAllpersonalDoc().setSalarySlips(file9.getBytes());
//			customer.getMortgageDetails().setMortgagePropertyProof(file10.getBytes());
//			customer.getMortgageDetails().setMortgagePropertyInsurance(file11.getBytes());
//			customer.getProfession().setProfessionsalaryslips(file12.getBytes());
//			customer.getPropertyinfo().setPropertyDocuments(file13.getBytes());
//			customer.getPropertyinfo().setPriceProofs(file14.getBytes());
	    	
			 Customer custom= customerServiceInterface.saveCustomer(customer);
			return "saved Successfully";
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
	@GetMapping(value="/allcustomer")
	public List<Customer> getAllCustomer()
	{
		List<Customer> cust=customerServiceInterface.getAllCustomer();
		return cust;
	}
	
	@GetMapping(value="/customer/{customerId}")
	public Customer getSingleCustomer(@PathVariable("customerId")Integer customerId)
	{
		Customer cust=customerServiceInterface.getSingleCustomer(customerId);
		
		return cust;
	}
	
	@DeleteMapping(value="/customer/{customerId}")
	public String deleteCustomer(@PathVariable ("customerId")Integer customerId)
	{
		customerServiceInterface.deleteCustomer(customerId);
		
		return "Deleted Successfully";
	}
	

	
	@PutMapping(value="/customer/{customerId}")
	public String updateCustomer(@RequestBody Customer customer, @PathVariable ("customerId") Integer customerId)
	{
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date date = new Date();  
		customer.getCustomerverification().setVerificationDate(formatter.format(date));
		Customer custom = customerServiceInterface.updateCustomer(customer,customerId);
		return "UPADATED SUCCEEFULLY";
	}
	
	
	@PutMapping(value="/sanctionloan/{customerId}")
	public ResponseEntity<Customer> sanctionLoan(@RequestBody Customer customer,@PathVariable("customerId")Integer customerId)
	{
		
		ResponseEntity<Customer> cust = customerServiceInterface.sanctionLoan(customer,customerId);
		return cust;
		
	}	
	
	@PutMapping(value="/loandisbursement/{customerId}")
	public String loanDisbursement(@RequestBody Customer customer,@PathVariable("customerId")Integer customerId)
	{
		Customer cust = customerServiceInterface.loanDisbursement(customer, customerId);
		return "SUCCESSFULLY DISBURST";
		
	}
	
	
	@PutMapping(value="/sanctionletteraccepted/{customerId}")
	public String sanctionletteraccepted(@RequestBody Customer customer, @PathVariable("customerId") Integer customerId)
	{
		

		Customer cust = customerServiceInterface.sactionletteraccepted(customer,customerId);
		
		return "Sanction Letter Accepted";
		
	}
	
	
	
	
	@PutMapping(value="/defaultcounter/{customerId}")
	public String defaulterCounter(@RequestBody Customer customer, @PathVariable ("customerId") Integer customerId)
	{
		Customer cust = customerServiceInterface.defaulterCounter(customer,customerId);
		return "ADDED IN DEFAULT COUNTER";
		
	}
	
	
	
//	@GetMapping(value ="/registrationapprovedlist" )
//	public  List<Customer> registrationApprovedList()
//	{
//		List<Customer> cust=customerServiceInterface.registrationApprovedList();
//		return cust;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
