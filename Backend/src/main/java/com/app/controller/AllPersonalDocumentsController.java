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

import com.app.pojos.AllPersonalDocuments;
import com.app.service.AllPersonalDocumentsServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("/AllPersonalDocuments")
public class AllPersonalDocumentsController {
	
	@Autowired
	private AllPersonalDocumentsServiceI documentsServiceInterface;
	
	@PostMapping(value="/allpersonaldocuments",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String  saveMortgageDetails(
			@RequestPart("addressProof")MultipartFile file1,
			@RequestPart("panCard")MultipartFile file2,
			@RequestPart("incomeTax")MultipartFile file3,
			@RequestPart("addharCard")MultipartFile file4,
			@RequestPart("photo")MultipartFile file5,
			@RequestPart("signature")MultipartFile file6,
			@RequestPart("thumb")MultipartFile file7,
			@RequestPart("bankCheque")MultipartFile file8,
			@RequestPart("salarySlips")MultipartFile file9,
			
			@RequestPart("cust")String cust) throws JsonMappingException, JsonProcessingException
	{
		    ObjectMapper objectMapper= new ObjectMapper();
		    
		    AllPersonalDocuments documents = objectMapper.readValue(cust,AllPersonalDocuments.class);
		
//		    {"documentID":0}		    
		    
		    
		    try {
		    	
		    	documents.setAddressProof(file1.getBytes());
		    	documents.setPanCard(file2.getBytes());
		    	documents.setIncomeTax(file3.getBytes());
		    	documents.setAddharCard(file4.getBytes());
		    	documents.setPhoto(file5.getBytes());
		    	documents.setSignature(file6.getBytes());
		    	documents.setThumb(file7.getBytes());
		    	documents.setBankCheque(file8.getBytes());
		    	documents.setSalarySlips(file9.getBytes());
		    	
		    	AllPersonalDocuments doc= documentsServiceInterface.saveAllPersonalDocuments(documents);
		    
				return "saved Successfully";
		    }
				
		    catch (IOException e) {
				e.printStackTrace();
				return null;
			}
	
}
	
	@GetMapping(value="/allpersonaldocuments",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<AllPersonalDocuments> getAllPersonalDocuments()
	{
		List<AllPersonalDocuments> doc =documentsServiceInterface.getAllPersonalDocuments();
		return doc;
	}
	
	@GetMapping(value="/allpersonaldocuments/{documentID}")
	public AllPersonalDocuments getSinglePersonalDocuments(@PathVariable Integer documentID)
	{
		AllPersonalDocuments doc = documentsServiceInterface.getSinglePersonalDocuments(documentID);
		return doc;
		
	}
	
	@DeleteMapping(value="/allpersonaldocuments/{documentID}")
	public String deleteAllPersonalDocuments(@PathVariable Integer documentID)
	{
		documentsServiceInterface.deleteAllPersonalDocuments(documentID);
		
		return "Delete Successfully";
		
	}
	
	@PutMapping(value="/allpersonaldocuments/{documentID}",consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
	public  String updateAllPersonalDocuments(@RequestPart("addressProof")MultipartFile file1,
			@RequestPart("panCard")MultipartFile file2,
			@RequestPart("incomeTax")MultipartFile file3,
			@RequestPart("addharCard")MultipartFile file4,
			@RequestPart("photo")MultipartFile file5,
			@RequestPart("signature")MultipartFile file6,
			@RequestPart("thumb")MultipartFile file7,
			@RequestPart("bankCheque")MultipartFile file8,
			@RequestPart("salarySlips")MultipartFile file9,
			
			@RequestPart("cust")String cust,@PathVariable ("documentID")Integer documentID) throws JsonMappingException, JsonProcessingException
	{
		 ObjectMapper objectMapper= new ObjectMapper();
		 
		    AllPersonalDocuments documents = objectMapper.readValue(cust,AllPersonalDocuments.class);
		    
		    try {
		    	
		    	documents.setAddressProof(file1.getBytes());
		    	documents.setPanCard(file2.getBytes());
		    	documents.setIncomeTax(file3.getBytes());
		    	documents.setAddharCard(file4.getBytes());
		    	documents.setPhoto(file5.getBytes());
		    	documents.setSignature(file6.getBytes());
		    	documents.setThumb(file7.getBytes());
		    	documents.setBankCheque(file8.getBytes());
		    	documents.setSalarySlips(file9.getBytes());
		    	
		    	AllPersonalDocuments doc= documentsServiceInterface.updateAllPersonalDocuments(documents);
		    	doc.setDocumentID(documentID);
				return "Update Successfully";
		    }
				
		    catch (IOException e) {
				e.printStackTrace();
				return null;
			}
	
	}
}
