package org.jimmy.mvc.pojo;

import org.jimmy.mvc.entity.Entity;
import org.jimmy.mvc.utils.PropertiesUtils;

public class PojoCache{
	private boolean result = false;
	private String message = "";
	private String errMessage = "";
	private Entity entity = null;

	public PojoCache() {
		this(true, "", null);
	}
	
	public PojoCache(Entity entity) {
		this(true, "", entity);
	}
	
	public PojoCache(boolean res) {
		this(res, "", null);
	}
	
	public PojoCache(boolean res, String msg) {
		this(res, msg, null);
	}
	
	public PojoCache(boolean res, Entity entity) {
		this(res, "", entity);
	}

	public PojoCache(boolean res, String msg, Entity entity) {
		this.entity = entity;
		if (res) {
			this.message = msg;
			this.result = true;
		} else {
			this.errMessage = PropertiesUtils.readPropertiesValue("message_tips.properties",  msg);
			this.result = false;
		}
	}

	public boolean hasError() {
		return !result;
	}

	public String getMessage() {
		if (result) {
			return message;
		} else {
			return errMessage;
		}
	}

	public void setError(String err) {
		this.errMessage = PropertiesUtils.readPropertiesValue("message_tips.properties",  err);
		this.result = false;
	}

	public void setMessage(String msg) {
		this.message = msg;
		this.result = true;
	}
	
	public Entity getEntity() {
		return this.entity;
	}

}
