package org.jimmy.mvcdemo.pojo;

import java.util.List;

import org.jimmy.mvc.pojo.Pojo;
import org.jimmy.mvcdemo.dao.PropertiesDAO;
import org.jimmy.mvcdemo.entity.PropertiesEntity;

public class PropertiesPojo extends Pojo {
	public PropertiesPojoCache getProperties() {

		PropertiesDAO dao = new PropertiesDAO();
		List<PropertiesEntity> list = dao.getPropertiesList();
		PropertiesPojoCache pojoCache = new PropertiesPojoCache();
		pojoCache.setList(list);
		return pojoCache;
	}

}
