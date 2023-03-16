package com.app.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.EducationalInformation;
import com.app.repository.EducationalInformationRepository;
import com.app.service.EducationalInformationServiceI;




@Service
public class EducationalInformationServiceImpl implements EducationalInformationServiceI {

	
	@Autowired
	private EducationalInformationRepository edInformationRepository;

	@Override
	public EducationalInformation saveEducationalInformation(EducationalInformation education) {
		EducationalInformation EducationalInformation = edInformationRepository.save(education);
		return EducationalInformation;
	}

	@Override
	public List<EducationalInformation> getAllEducationalInformation() {
		     
		return edInformationRepository.findAll();
	}

	@Override
	public EducationalInformation getSingleEducationalInformation(EducationalInformation eduInformation,Integer educationId) {
		
		return edInformationRepository.findById(educationId).get();
	}

	@Override
	public void deleteEducationalInformation(Integer educationId) {
		edInformationRepository.deleteById(educationId);
		    
		
	}

	@Override
	public EducationalInformation updateEducationalInformation(Integer educationId,EducationalInformation educationalInformation) {
		educationalInformation.setEducationId(educationId);
		return  edInformationRepository.save(educationalInformation) ;
	}

	
}
