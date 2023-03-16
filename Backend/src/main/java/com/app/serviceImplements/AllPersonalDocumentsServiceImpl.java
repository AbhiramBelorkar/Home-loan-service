package com.app.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.AllPersonalDocuments;
import com.app.repository.AllPersonalDocumentsRepository;
import com.app.service.AllPersonalDocumentsServiceI;

@Service
public class AllPersonalDocumentsServiceImpl implements AllPersonalDocumentsServiceI {

	
	@Autowired
	private AllPersonalDocumentsRepository allDocumentsRepository;

      
	@Override
	public AllPersonalDocuments saveAllPersonalDocuments(AllPersonalDocuments documents) {
		
		AllPersonalDocuments doc=allDocumentsRepository.save(documents);
		
		return doc;
	}

	@Override
	public List<AllPersonalDocuments> getAllPersonalDocuments() {
		
		return allDocumentsRepository.findAll();
	}

	@Override
	public AllPersonalDocuments getSinglePersonalDocuments( Integer documentID) {
		     
		return allDocumentsRepository.findById(documentID).get();
	}

	@Override
	public void deleteAllPersonalDocuments(Integer documentID) {
		
		allDocumentsRepository.deleteById(documentID);
		
		
	}

	@Override
	public AllPersonalDocuments updateAllPersonalDocuments(AllPersonalDocuments documents) {
		         
		return allDocumentsRepository.save(documents) ;
	}

	

	
}
