package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.DependentInfo;
import com.app.service.DependentInfoInterface;


@CrossOrigin("*")
@RequestMapping(value="/dependentinfocontroller")
@RestController
public class DependentInfoController {
	
	@Autowired
	private DependentInfoInterface dis;
	
	
	
	
	@PostMapping("/dependentInfoData")
	public DependentInfo saveDependentInfoData(@RequestBody DependentInfo d) {
		
		DependentInfo di = dis.saveDependentInfoData(d);
		return di;
		
	}
	
	
	
	@GetMapping("/dependentInfoData")
	public Iterable<DependentInfo> getDependentInfoData(){
		
	Iterable<DependentInfo> did	=dis.getAlldependentInfoData();
	return did;
		
	}
	
	
	
	@PutMapping("/dependentInfoData/{dependentInfoId}")
	public  DependentInfo updateDependentInfoData(@PathVariable Integer dependentInfoId,@RequestBody DependentInfo dd) {
		
		dd.setDependentInfoId(dependentInfoId);
		
		DependentInfo sud = dis.updateDependentInfoData(dd);
		return sud;
	}
	
	
	
	
	@DeleteMapping("/dependentInfoData/{dependentInfoId}")
	public  String deleteDependentInfoData(@PathVariable Integer  dependentInfoId) {
		
		dis.deleteDependentInfoData(dependentInfoId);
		
		return "delete Succesfully....!!";
	}

}
