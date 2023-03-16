package com.app.service;

import com.app.pojos.Cibil;

public interface CibilIService {
	
	public Cibil saveData(Cibil c);
	
	public Iterable<Cibil> getAllCibilData() ;
	
	public Cibil getSingleData(Integer cibilId);

}
