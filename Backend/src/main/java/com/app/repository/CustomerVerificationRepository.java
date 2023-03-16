package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.CustomerVerification;



@Repository
public interface CustomerVerificationRepository extends JpaRepository<CustomerVerification, Integer> {



}
