package org.jimmy.mvcdemo.service;

import java.util.List;

import org.jimmy.mvc.service.BasicService;
import org.jimmy.mvcdemo.dao.PropertiesDAO;
import org.jimmy.mvcdemo.entity.PropertyEntity;

public class PropertyService extends BasicService {
	public PropertyEntity getAllProperties() {
		return getProperties();
	}
	
	public PropertyEntity getProperties(Object ... args) {
		PropertiesDAO dao = new PropertiesDAO();
		List<PropertyEntity> list = dao.getPropertiesList(args);
		PropertyEntity entity = new PropertyEntity();
		entity.setList(list);
		return entity;
	}
	
	public int deleteProperty(String id) {
		PropertiesDAO dao = new PropertiesDAO();
		return dao.deleteProperty(id);
	}

}
