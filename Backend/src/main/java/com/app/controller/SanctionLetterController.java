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

import com.app.pojos.SanctionLetter;
import com.app.service.SanctionLetterServiceI;



@CrossOrigin("*")
@RestController
@RequestMapping("/sanctionLetter")
public class SanctionLetterController {
	
	@Autowired
	private SanctionLetterServiceI sanctionLetterserviceinterface;
	
	
	
	
	@PostMapping(value="/sanctionletter")
	public SanctionLetter saveSanctionLetter(@RequestBody SanctionLetter sl)
	{
		SanctionLetter sanctionLetter =sanctionLetterserviceinterface.saveSanctionLetter(sl);
		
		return sanctionLetter;
	}
	
	@GetMapping(value="/sanctionletter")
	public List<SanctionLetter> getSanctionLetter()
	{
		List<SanctionLetter> sanctionletter = sanctionLetterserviceinterface.getSanctionLetter();
		return sanctionletter;
		
	}
	
	@DeleteMapping("/sanctionletter/{sanctionId}")
	public void deleteSanctionLetter(@PathVariable Integer sanctionId)
	{
		sanctionLetterserviceinterface.deleteSanctionLetter(sanctionId);
		
	}
	
	@PutMapping(value="sanctionletter/{sanctionId}")
	public SanctionLetter updateSanctionLetter(@PathVariable Integer sanctionId,@RequestBody SanctionLetter sl  )
	{
		SanctionLetter sanctionletter=sanctionLetterserviceinterface. updateSanctionLetter( sanctionId,sl);
		return sanctionletter;
	}
	
	
	@GetMapping(value="/sanctionletter/{sanctionId}")
	public Optional<SanctionLetter> getSingleSanctionLetter(@PathVariable Integer sanctionId )
	{
		Optional<SanctionLetter> sanctionletter= sanctionLetterserviceinterface.getSingleSanctionLetter(sanctionId);
		
		return sanctionletter;
	}
	
	

}
