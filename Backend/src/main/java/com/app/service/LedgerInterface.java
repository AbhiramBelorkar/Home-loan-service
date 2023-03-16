package com.app.service;

import com.app.pojos.Ledger;

public interface LedgerInterface {

   public Ledger ledgerSaveData(Ledger l);

   public Iterable<Ledger> getAllLedgerData();

   public Ledger updateLedgerData(Ledger ledger, Integer ledgerId);

   public Ledger getSingleLedgerData(Integer ledgerId);

  public void deleteLEdgerData(Integer ledgerId);
	
	


}
