package com.app.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.PermanentAddress;
import com.app.repository.PermanentAddressRepository;
import com.app.service.PermanentAddressServiceI;



@Service
public class PermanentAddressServiceImpl implements PermanentAddressServiceI {

	@Autowired
	private PermanentAddressRepository par;
	
	@Override
	public PermanentAddress savePermanentAddress(PermanentAddress pd) {
		PermanentAddress peradd= par.save(pd);
		return peradd;
	}

	@Override
	public Iterable<PermanentAddress> getAllPermanentAddress() {
		Iterable<PermanentAddress> list =par.findAll();
		return list;
	}

	@Override
	public PermanentAddress updatePermanentAddress(Integer permanentAddressId, PermanentAddress add) {
		add.setPermanentAddressId(permanentAddressId);
		PermanentAddress newpa=par.save(add);
		return newpa;
	}

	@Override
	public PermanentAddress getSinglePermanentAddress(Integer permanentAddressId) {
		
		return par.findById(permanentAddressId).get();
	}

	@Override
	public void deletePermanentAddress(Integer permanentAddressId) {
		par.deleteById(permanentAddressId);
		
	}

}
