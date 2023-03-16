package com.app.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.PropertyInfo;
import com.app.repository.PropertyInfoRepository;
import com.app.service.PropertyInfoServiceI;



@Service
public class PropertyInfoServiceImpl implements PropertyInfoServiceI{
	
	@Autowired
	private PropertyInfoRepository propertyInfoRepository;

	@Override
	public PropertyInfo savePropertyInfo(PropertyInfo propertyinfo) {
		PropertyInfo property = propertyInfoRepository.save(propertyinfo);
		return property;
	}

	@Override
	public List<PropertyInfo> getAllPropertyInfo() {
		
		return propertyInfoRepository.findAll();
	}

	@Override
	public PropertyInfo getSinglePropertyInfo(Integer propertyId) {
		
		return propertyInfoRepository.findById(propertyId).get();
	}

	@Override
	public void deletePropertyInfo(Integer propertyId) {
		
		propertyInfoRepository.deleteById(propertyId);
		    
		
	}

	@Override
	public PropertyInfo updatePropertyInfo(PropertyInfo property) {
		
		return propertyInfoRepository.save(property);
	}

	

}
