package org.jimmy.mvc.exception;

import org.jimmy.mvc.utils.PropertiesUtils;

public class MVCException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageID = "excep0A001";
	
	public MVCException() {
		super();
	}
	
	public MVCException(String messageID) {
		super(messageID);
		this.messageID = messageID;
	}
	
	public String getExceptionMessage() {
		return PropertiesUtils.readPropertiesValue("message_exception.properties", this.messageID);
	}
}
