package org.jimmy.mvc.entity;

import java.util.ArrayList;
import java.util.List;

import org.jimmy.mvc.utils.PropertiesUtils;

public abstract class Entity<T> {
	private boolean result = false;
	private String msg = "";
	private List<T> list = null;
	
	public Entity() {
	}
	
	public Entity(boolean result, String msg) {
		this.result = result;
		this.msg = msg;
	}
	
	public void success() {
		result = true;
	}
	
	public String getMessage() {
		return PropertiesUtils.readPropertiesValue("message_tips.properties", msg);
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public void addList(T entity) {
		if (list == null) {
			list = new ArrayList<T>();
			
		list.add(entity);
		}
	}
	
	public List<T> getList() {
		return list;
	}
	
	public boolean isSuccess() {
		return result;
	}
	
}
