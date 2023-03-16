package com.app.service;

import java.util.List;

import com.app.pojos.PreviousLoan;



public interface PreviousLoanServiceInterface {

	public PreviousLoan savePreviousLoan(PreviousLoan previousloan);

	public List<PreviousLoan> getAllPreviousLoan();

	public PreviousLoan getSinglePreviousLoan(Integer previousLoanId);

	public void deletePreviousLoan(Integer previousLoanId);

	public PreviousLoan updatePreviousLoan(PreviousLoan loan, Integer previousLoanId);

	


	

}
