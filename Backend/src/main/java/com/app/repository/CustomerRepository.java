package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
