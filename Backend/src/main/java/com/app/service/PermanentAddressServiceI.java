package com.app.service;

import com.app.pojos.PermanentAddress;

public interface PermanentAddressServiceI {

	public PermanentAddress savePermanentAddress(PermanentAddress pd);

	public Iterable<PermanentAddress> getAllPermanentAddress();

	public PermanentAddress updatePermanentAddress(Integer permanentAddressId, PermanentAddress add);

	public PermanentAddress getSinglePermanentAddress(Integer permanentAddressId);

	public void deletePermanentAddress(Integer permanentAddressId);

}
