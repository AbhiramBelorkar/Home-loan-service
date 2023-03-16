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

import com.app.pojos.PropertyAddress;
import com.app.service.PropertyAddressServiceInterface;

@CrossOrigin("*")
@RestController
@RequestMapping("/PropertyAddress")
public class PropertyAddressController {
	
	@Autowired
	private PropertyAddressServiceInterface  propertyaddressserviceinterface;
	
	
	@PostMapping(value="/propertyaddress")
	public PropertyAddress savePropertyAddress(@RequestBody PropertyAddress pd)
	{
		PropertyAddress propertyAddress=propertyaddressserviceinterface.savePropertyAddress(pd);
		
		return propertyAddress;
	}
	
	
	@GetMapping(value="/propertyaddress")
	public List<PropertyAddress> getAllPropertyAddress()
	{
		List<PropertyAddress>propertyAddress=propertyaddressserviceinterface.getAllPropertyAddress();
		return propertyAddress;
	}
	
	@GetMapping(value="/propertyaddress/{propertyAddressId}")
	public Optional<PropertyAddress> getSinglePropertyAddress(@PathVariable Integer PropertyAddressId )
	{
		Optional<PropertyAddress> property= propertyaddressserviceinterface.getSinglePropertyAddress(PropertyAddressId);
		return property;
	}
	
	@DeleteMapping("/propertyaddress/{propertyAddressId}")
	public void deletePropertyAddress(@PathVariable Integer PropertyAddressId)
	{
		propertyaddressserviceinterface.deletePropertyAddress(PropertyAddressId);
		
	}
	
	@PutMapping("/propertyaddress/{propertyAddressId}")
	public PropertyAddress updatePropertyAddress(@PathVariable("propertyAddressId") Integer propertyAddressId,@RequestBody PropertyAddress pa)
	{
		PropertyAddress property       =propertyaddressserviceinterface.updatePropertyAddress(propertyAddressId,pa);
		return property;
		
	}
	
	
	
	
	
	

}
