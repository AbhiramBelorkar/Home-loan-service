package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.app.pojos.Ledger;


@Repository
public interface LedgerRepository extends JpaRepository<Ledger,Integer> {

}
