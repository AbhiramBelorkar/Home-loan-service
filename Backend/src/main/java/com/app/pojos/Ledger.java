package com.app.pojos;



import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.PutMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ledger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer ledgerId;
	
	private String ledgerCreatedDate;
	
	private Double totalLoanAmount; //customer.getSanctionletter().getLoanAmtSanctioned()
	
	private Double payableAmountwithInterest;//customer.getCurrentloandetails().getTotalAmounttobepaidDouble()
	
	private Integer tenure;//customer.getSanctionletter().getLoanTenure()
	
	private Double monthlyEMI;//customer.getSanctionletter().getMonthlyEmiAmount()
	
	private Double amountPaidtillDate;
	
	private Double remainingAmount;
	
	private String nextEmiDatestart;
	
	private String nextEmiDateEnd;
	
	private Integer defaulterCount;//@PutMapping(value="/defaultcounter/{customerId}")
	
	private String previousEmitStatus;
	
	private String currentMonthEmiStatus;
	
	private String loanEndDate;//customer.getLedger().setLoanEndDate(cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE));
	
	private String loanStatus;
	
}


