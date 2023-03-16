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

import com.app.pojos.PermanentAddress;
import com.app.service.PermanentAddressServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping("/permanentaddresscontroller")
public class PermanentAddressController 
{
	@Autowired
	private PermanentAddressServiceI pai;
	
	@PostMapping("/permanentaddress")
	public PermanentAddress savePermanentAddress(@RequestBody PermanentAddress pd)
	{
		PermanentAddress peradd=pai.savePermanentAddress(pd);
		return peradd;
	}
	
	@GetMapping("/permanentaddress")
	public Iterable<PermanentAddress> getAllPermanentAddress()
	{
		Iterable<PermanentAddress> list=pai.getAllPermanentAddress();
		return list;
	}
	
	@PutMapping("/permanentaddress/{permanentAddressId}")
	public PermanentAddress updatePermanentAddress(@PathVariable Integer permanentAddressId,@RequestBody PermanentAddress add)
	{
		PermanentAddress permadd=pai.updatePermanentAddress(permanentAddressId,add);
		return permadd;
	}
	
	@GetMapping("/permanentaddress/{permanentAddressId}")
	public PermanentAddress getSinglePermanentAddress(@PathVariable Integer permanentAddressId)
	{
		PermanentAddress speradd=pai.getSinglePermanentAddress(permanentAddressId);
		return speradd;
	}
	
	@DeleteMapping("/permanentaddress/{permanentAddressId}")
	public String deletePermanentAddress(@PathVariable Integer permanentAddressId)
	{
		pai.deletePermanentAddress(permanentAddressId);
		return "Delete permanent Address Id";
	}

}
