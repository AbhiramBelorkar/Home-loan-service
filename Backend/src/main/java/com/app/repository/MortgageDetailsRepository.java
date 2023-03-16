package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.MortgageDetails;



@Repository
public interface MortgageDetailsRepository extends JpaRepository<MortgageDetails, Integer>{

}
