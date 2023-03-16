package com.app.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.PropertyAddress;
import com.app.repository.PropertyAddressRepository;
import com.app.service.PropertyAddressServiceInterface;


@Service
public class PropertyAddressServiceImpl implements  PropertyAddressServiceInterface{
	
	@Autowired
	private PropertyAddressRepository propertyAddressRepository;

	@Override
	public PropertyAddress savePropertyAddress(PropertyAddress pd) {
		    PropertyAddress propertyAddress=propertyAddressRepository.save(pd);
		return propertyAddress;
	}

	@Override
	public List<PropertyAddress> getAllPropertyAddress() {
		
		return propertyAddressRepository.findAll();
	}

	@Override
	public Optional<PropertyAddress> getSinglePropertyAddress(Integer propertyAddressId) {
		 Optional<PropertyAddress> property= propertyAddressRepository.findById(propertyAddressId);
		return property;
	}

	@Override
	public void deletePropertyAddress(Integer propertyAddressId) {
		            propertyAddressRepository.deleteById(propertyAddressId);
		
	}

	@Override
	public PropertyAddress updatePropertyAddress(Integer propertyAddressId, PropertyAddress pa) {
		               pa.setPropertyAddressId(propertyAddressId);
		               
		return propertyAddressRepository.save(pa);
	}

}

