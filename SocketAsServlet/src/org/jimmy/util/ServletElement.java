package org.jimmy.util;

import org.jimmy.server.IServlet;

public class ServletElement {
	public String servletName = "";
	public String servletUrl = "";
	private String servletClzName = "";
	private IServlet servletClz = null;
	
	public void setServletClz(String clzpath) {
		try {
			servletClzName = clzpath;
			servletClz = (IServlet)Class.forName(clzpath).newInstance();
			System.out.println(servletClz.toString());
		} catch (InstantiationException e) {
			servletClzName = "";
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			servletClzName = "";
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			servletClzName = "";
			e.printStackTrace();
		}
	}
	
	public IServlet getServletClz() {
		if ("".equals(servletClzName)) {
			throw new NoSpecifiedServletPathException("servlet path error.");
		}
		return this.servletClz;
	}
}
