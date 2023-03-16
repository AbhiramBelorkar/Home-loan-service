package com.app.service;

import java.util.List;

import com.app.pojos.EducationalInformation;


public interface EducationalInformationServiceI {

	public EducationalInformation saveEducationalInformation(EducationalInformation education);

	public List<EducationalInformation> getAllEducationalInformation();

	public EducationalInformation getSingleEducationalInformation(EducationalInformation eduInformation,Integer educationId);

	public void deleteEducationalInformation(Integer educationId);

	public EducationalInformation updateEducationalInformation(Integer educationId,EducationalInformation educationalInformation);

}
