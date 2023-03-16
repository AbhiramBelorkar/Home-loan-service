package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.PermanentAddress;



@Repository
public interface PermanentAddressRepository extends JpaRepository<PermanentAddress, Integer> {

}
