package com.app.service;

import java.util.List;

import com.app.pojos.PropertyInfo;



public interface PropertyInfoServiceI {

	public PropertyInfo savePropertyInfo(PropertyInfo propertyinfo);

	public List<PropertyInfo> getAllPropertyInfo();

	public PropertyInfo getSinglePropertyInfo(Integer propertyId);

	public void deletePropertyInfo(Integer propertyId);

	public PropertyInfo updatePropertyInfo(PropertyInfo property);

}
