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

import com.app.pojos.PropertyInfo;
import com.app.service.PropertyInfoServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@Slf4j //Simple Logging Facade for Java
@RestController
@RequestMapping("/PropertyInfoController")
public class PropertyInfoController {
	
	@Autowired
	private PropertyInfoServiceI propertyInfoServiceInterface;
	
	//http://localhost:8080/PropertyInfoController/propertyinfo
	
	@PostMapping(value="/propertyinfo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String  savePropertyInfo(
			@RequestPart("propertyDocuments")MultipartFile file1,
			
			@RequestPart("priceProofs")MultipartFile file2,
			
			@RequestPart("cust")String cust) throws JsonMappingException, JsonProcessingException
	{
		    ObjectMapper objectMapper= new ObjectMapper();
		    
		    PropertyInfo propertyinfo = objectMapper.readValue(cust, PropertyInfo.class);
		    
//		    {"propertyId": 0,"propertyType": "Land","propertyArea": 1200,"constructionArea": 1000,"propertyPrice": 300000000,"constructionPrice":300000,"propertyAddress":{"propertyAddressId": 0,"areaname": "akurdi","cityname": "Pune","district": "Pune","state": "Maharastra","pincode": 44000123,"streetName": "Main Road"}}
		    
		    try {
		    	
		    	propertyinfo.setPropertyDocuments(file1.getBytes());
		    	
		    	propertyinfo.setPriceProofs(file2.getBytes());
				
		    	PropertyInfo property= propertyInfoServiceInterface.savePropertyInfo(propertyinfo);
		    	
				return "saved Successfully";
				
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		
		
	}
	
	@GetMapping(value="/propertyinfo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<PropertyInfo> getAllPropertyInfo()
	{
		List<PropertyInfo> info= propertyInfoServiceInterface.getAllPropertyInfo();
		     return info;
	}
	
	@GetMapping(value="/propertyinfo/{propertyId}")
	public PropertyInfo getSinglePropertyInfo(@PathVariable ("propertyId")Integer propertyId)
	{
		PropertyInfo proprty = propertyInfoServiceInterface.getSinglePropertyInfo(propertyId);
		return proprty;
		
	}
	
	@DeleteMapping(value="/propertyinfo/{propertyId}")
	public String deletePropertyInfo(@PathVariable("propertyId") Integer propertyId)
	{
		propertyInfoServiceInterface.deletePropertyInfo(propertyId);
		
		return "delete Successfully";
		
	}
	
	@PutMapping(value="/propertyinfo/{propertyId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String  updatePropertyInfo(
			@RequestPart("propertyDocuments")MultipartFile file1,
			@RequestPart("priceProofs")MultipartFile file2,
			@RequestPart("cust")String cust, @PathVariable("propertyId")Integer propertyId) throws JsonMappingException, JsonProcessingException
	{
		    ObjectMapper objectMapper= new ObjectMapper();
		    PropertyInfo property = objectMapper.readValue(cust, PropertyInfo.class);
		    
		    try {
		    	property.setPropertyDocuments(file1.getBytes());
		    	property.setPriceProofs(file2.getBytes());
				
		    	PropertyInfo info= propertyInfoServiceInterface.updatePropertyInfo(property);
		    	
		    	property.setPropertyId(propertyId);
		    	
				return "update Successfully";
				
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		
		
	}
	
	
	
}
