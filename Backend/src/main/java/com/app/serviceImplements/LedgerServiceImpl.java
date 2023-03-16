package com.app.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.pojos.Ledger;
import com.app.repository.LedgerRepository;
import com.app.service.LedgerInterface;



@Service
public class LedgerServiceImpl implements LedgerInterface {
	
	@Autowired
	private LedgerRepository lr;

	@Override
	public Ledger ledgerSaveData(Ledger l) {
		
		return lr.save(l);
	}

	@Override
	public Iterable<Ledger> getAllLedgerData() {
		
		return lr.findAll();
	}

	@Override
	public Ledger updateLedgerData(Ledger ledger, Integer ledgerId) {
		       ledger.setLedgerId(ledgerId); 
		       
		return lr.save(ledger);
	}

	@Override
	public Ledger getSingleLedgerData(Integer ledgerId) {
		         
		Ledger led=lr.findById(ledgerId).get();
		
		return led;
	}

	@Override
	public void deleteLEdgerData(Integer ledgerId) {
		   
		lr.deleteById(ledgerId);
		
	}

	
	

	
}
