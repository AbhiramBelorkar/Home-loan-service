package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.AllPersonalDocuments;



@Repository
public interface AllPersonalDocumentsRepository extends JpaRepository<AllPersonalDocuments, Integer> {

}
