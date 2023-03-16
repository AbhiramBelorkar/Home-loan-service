package com.app.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.PreviousLoan;
import com.app.repository.PreviousLoanRepository;
import com.app.service.PreviousLoanServiceInterface;



@Service
public class PreviousLoanServiceImpl implements PreviousLoanServiceInterface{
	
	@Autowired
	private PreviousLoanRepository preLoanRepository;

	@Override
	public PreviousLoan savePreviousLoan(PreviousLoan previousloan) {
		PreviousLoan loan = preLoanRepository.save(previousloan);
		return loan;
	}

	@Override
	public List<PreviousLoan> getAllPreviousLoan() {
		
		return preLoanRepository.findAll() ;
	}

	@Override
	public PreviousLoan getSinglePreviousLoan(Integer previousLoanId) {
		       
		return preLoanRepository.findById(previousLoanId).get();
	}

	@Override
	public void deletePreviousLoan(Integer previousLoanId) {
		preLoanRepository.deleteById(previousLoanId);
		
	}

	@Override
	public PreviousLoan updatePreviousLoan(PreviousLoan loan, Integer previousLoanId) {
		        
		loan.setPreviousLoanId(previousLoanId);
		
		return preLoanRepository.save(loan);
	}

	

	


	

}
