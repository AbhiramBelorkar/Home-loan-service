package com.app.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.EMIDetails;
import com.app.repository.EMIDetailsRepository;
import com.app.service.EMIDetailsServiceI;



@Service
public class EMIDetailsServiceImpl implements EMIDetailsServiceI
{

	@Autowired
	private EMIDetailsRepository edr;

	@Override
	public EMIDetails saveEMIDetails(EMIDetails ed) {
		
		EMIDetails emid = edr.save(ed);
		
		return emid;
	}

	@Override
	public Iterable<EMIDetails> getAllEMIDetails() {
		
		Iterable<EMIDetails> list = edr.findAll();
		return list;
	}

	@Override
	public EMIDetails updateEMIDetails(Integer emiID, EMIDetails ed) {
		ed.setEmiID(emiID);
		EMIDetails uemid = edr.save(ed);
		return uemid;
	}

	@Override
	public EMIDetails getSingleEMIDetails(Integer emiID) {
		
		return edr.findById(emiID).get();
	}

	@Override
	public void deleteEMIDetails(Integer emiID) {
		edr.deleteById(emiID);
		
	}
	
}
