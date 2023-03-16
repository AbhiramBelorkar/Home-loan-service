package com.app.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.app.pojos.DependentInfo;
import com.app.repository.DependentInfoRepository;
import com.app.service.DependentInfoInterface;



@Service
public class DependentInfoServiceImpl  implements DependentInfoInterface{
	@Autowired
	private DependentInfoRepository dir;

	@Override
	public DependentInfo saveDependentInfoData(DependentInfo d) {
		DependentInfo dep = dir.save(d);
		return dep;
	}

	@Override
	public Iterable<DependentInfo> getAlldependentInfoData() {
Iterable<DependentInfo> did	=dir.findAll();
		return did;
	}

	@Override
	public DependentInfo updateDependentInfoData(DependentInfo dependentInfoId) {
		DependentInfo sud = dir.save(dependentInfoId);
		return sud;
	}

	@Override
	public String deleteDependentInfoData(Integer dependentInfoId) {
		dir.deleteById(dependentInfoId);
		return "delete Succesfully...";
	}

	 
	

	 

	
}
