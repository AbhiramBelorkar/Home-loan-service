package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.GuarantorDetails;



public interface GuarantorDetailsServiceI {

	 public GuarantorDetails saveGuarantorDetails(GuarantorDetails guarantordetails);

	public List<GuarantorDetails> getAllGuarantorDetails();

	public Optional<GuarantorDetails> getGuarantorDetails(GuarantorDetails guarantorDetails, Integer guarantorId);

	public void deleteGuarantorDetails(Integer guarantorId);

	public GuarantorDetails updateGuarantorDetails(Integer guarantorId, GuarantorDetails guarantordetails);

}
