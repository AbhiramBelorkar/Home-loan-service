package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.CustomerAddress;


@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer>{

}
