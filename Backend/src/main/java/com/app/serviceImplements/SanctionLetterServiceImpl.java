package com.app.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.SanctionLetter;
import com.app.repository.SanctionLetterRepository;
import com.app.service.SanctionLetterServiceI;


@Service
public class SanctionLetterServiceImpl implements SanctionLetterServiceI
{
	
	@Autowired
	private SanctionLetterRepository sanctionLetterRepository;

	@Override
	public SanctionLetter saveSanctionLetter(SanctionLetter sl) {
		SanctionLetter sanctionLetter= sanctionLetterRepository.save(sl);
		return sanctionLetter;
	}

	@Override
	public List<SanctionLetter> getSanctionLetter() {
		
		return sanctionLetterRepository.findAll();
	}

	@Override
	public void deleteSanctionLetter(Integer sanctionId) {
		sanctionLetterRepository.deleteById(sanctionId);
		
	}

	@Override
	public SanctionLetter updateSanctionLetter(Integer sanctionId, SanctionLetter sl) {
		sl.setSanctionId(sanctionId);
		return sanctionLetterRepository.save(sl);
	}

	@Override
	public Optional<SanctionLetter> getSingleSanctionLetter(Integer sanctionId) {
		Optional<SanctionLetter>scl=sanctionLetterRepository.findById(sanctionId);
		return scl;
	}

}
