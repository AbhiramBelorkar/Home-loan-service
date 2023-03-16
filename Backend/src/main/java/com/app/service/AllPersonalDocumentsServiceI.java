
package com.app.service;

import java.util.List;

import com.app.pojos.AllPersonalDocuments;



public interface AllPersonalDocumentsServiceI {



	public AllPersonalDocuments saveAllPersonalDocuments(AllPersonalDocuments documents);

	public List<AllPersonalDocuments> getAllPersonalDocuments();

	public AllPersonalDocuments getSinglePersonalDocuments(Integer documentID);

	public void deleteAllPersonalDocuments(Integer documentID);

	public AllPersonalDocuments updateAllPersonalDocuments(AllPersonalDocuments documents);

	

	 

}
