package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.LoanDisbursement;



@Repository
public interface LoanDisbursementRepository extends JpaRepository<LoanDisbursement, Integer> {

}
