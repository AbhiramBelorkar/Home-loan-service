package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.CurrentLoanDetails;


@Repository
public interface CurrentLoanDetailsRepository extends JpaRepository<CurrentLoanDetails, Integer> {

}
