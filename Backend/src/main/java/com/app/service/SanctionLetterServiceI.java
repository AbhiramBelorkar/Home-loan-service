package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.SanctionLetter;



public interface SanctionLetterServiceI {

	public SanctionLetter saveSanctionLetter(SanctionLetter sl);

	public List<SanctionLetter> getSanctionLetter();

	public void deleteSanctionLetter(Integer sanctionId);

	public SanctionLetter updateSanctionLetter(Integer sanctionId, SanctionLetter sl);

	public Optional<SanctionLetter> getSingleSanctionLetter(Integer sanctionId);

}
