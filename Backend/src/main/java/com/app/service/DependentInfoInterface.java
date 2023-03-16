package com.app.service;

import com.app.pojos.DependentInfo;

public interface DependentInfoInterface {
	
	
	public DependentInfo saveDependentInfoData(DependentInfo d);
	
	public Iterable<DependentInfo> getAlldependentInfoData();
	
	public DependentInfo updateDependentInfoData(DependentInfo dependentInfoId);
	public String deleteDependentInfoData(Integer dependentInfoId);

}
