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

import com.app.pojos.Ledger;
import com.app.service.LedgerInterface;


@CrossOrigin("*")
@RequestMapping(value="/ledgercontroller")
@RestController
public class LedgerController {
	
	
	@Autowired
	private LedgerInterface lsi;
	
	
	
	@PostMapping("/ledgerData")
	public Ledger saveLedgerData(@RequestBody Ledger l) {
		
	Ledger ledger = lsi.ledgerSaveData(l);
		
		return ledger;
		
	}
	
	
	@GetMapping("/ledgerData")
	public Iterable<Ledger> getAllLedgerData(){
		
	Iterable<Ledger> ledger = lsi.getAllLedgerData();
		return ledger ;
	}
	
	
	
	@PutMapping("/ledgerData/{ledgerId}")
	public  Ledger updateLedgerData(@PathVariable("ledgerId") Integer ledgerId,@RequestBody Ledger ledger) {
	Ledger led = lsi.updateLedgerData(ledger,ledgerId);
	return led;
	}
	
	
	
	@GetMapping("/ledgerData/{ledgerId}")
	public Ledger getSingleLedgerData(@PathVariable Integer ledgerId) {
	Ledger le = lsi.getSingleLedgerData(ledgerId);
	return le;
		
	}
	
	
	@DeleteMapping("/delete/{ledgerId}")
	public String deleteLedgerData(@PathVariable Integer ledgerId) {
		lsi.deleteLEdgerData(ledgerId);
		return "delete ledger Successfully...!";
	}

}
