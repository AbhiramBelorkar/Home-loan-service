package com.app.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.GuarantorDetails;
import com.app.repository.GuarantorDetailsRepository;
import com.app.service.GuarantorDetailsServiceI;



@Service
public class GuarantorDetailsServiceImpl implements GuarantorDetailsServiceI{
	
	@Autowired
	private GuarantorDetailsRepository guarantordetailsRepository;

	@Override
	public GuarantorDetails saveGuarantorDetails(GuarantorDetails guarantordetails) {
		GuarantorDetails GuarantorDetails=guarantordetailsRepository.save(guarantordetails);
		return GuarantorDetails;
	}

	@Override
	public List<GuarantorDetails> getAllGuarantorDetails() {
		
		return guarantordetailsRepository.findAll();
	}

	@Override
	public Optional<GuarantorDetails> getGuarantorDetails(GuarantorDetails guarantorDetails, Integer guarantorId) {
		Optional<GuarantorDetails> guarantor=guarantordetailsRepository.findById(guarantorId);
		return guarantor;
	}

	@Override
	public void deleteGuarantorDetails(Integer guarantorId) {
		guarantordetailsRepository.deleteById(guarantorId);
		
	}

	@Override
	public GuarantorDetails updateGuarantorDetails(Integer guarantorId, GuarantorDetails guarantordetails) {
		            guarantordetails.setGuarantorId(guarantorId);
		return guarantordetailsRepository.save(guarantordetails);
	}

}
