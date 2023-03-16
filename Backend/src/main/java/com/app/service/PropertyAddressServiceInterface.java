package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.PropertyAddress;



public interface PropertyAddressServiceInterface {

	public PropertyAddress savePropertyAddress(PropertyAddress pd);

	public List<PropertyAddress> getAllPropertyAddress();

	public Optional<PropertyAddress> getSinglePropertyAddress(Integer propertyAddressId);

	public void deletePropertyAddress(Integer propertyAddressId);

	public PropertyAddress updatePropertyAddress(Integer propertyAddressId, PropertyAddress pa);

}
