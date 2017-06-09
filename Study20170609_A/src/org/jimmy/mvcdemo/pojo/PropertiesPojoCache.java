package org.jimmy.mvcdemo.pojo;

import java.util.List;

import org.jimmy.mvc.pojo.PojoCache;
import org.jimmy.mvcdemo.entity.PropertiesEntity;

public class PropertiesPojoCache extends PojoCache {
	private List<PropertiesEntity> list = null;
	
	public PropertiesPojoCache() {
		super();
	}

	public List<PropertiesEntity> getList() {
		return list;
	}

	public void setList(List<PropertiesEntity> list) {
		this.list = list;
	}
}
