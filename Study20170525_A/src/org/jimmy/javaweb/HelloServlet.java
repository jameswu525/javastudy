package org.jimmy.javaweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	public HelloServlet() {

		System.out.println("constructor");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
		System.out.println("serlet name => " + config.getServletName());
		System.out.println("path => " + config.getServletContext().getContextPath());
		String parameterName = "";
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			parameterName = names.nextElement();
			System.out.println(parameterName + " ==> " + config.getInitParameter(parameterName));
		}
		System.out.println("==========Globle context parameter============");
		names = config.getServletContext().getInitParameterNames();
		while (names.hasMoreElements()) {
			parameterName = names.nextElement();
			System.out.println(parameterName + " ==> " + config.getServletContext().getInitParameter(parameterName));
		} 
		System.out.println("========== context ============");
		String realPath = config.getServletContext().getRealPath("readme.md");
		System.out.println(realPath);
		realPath = config.getServletContext().getRealPath("/WEB-INF/web.xml");
		System.out.println(realPath);
		byte[] b = new byte[1024];
		int len = -1;
		try {
//			InputStream st1 = config.getServletContext().getResourceAsStream("jdbc2.properties");
			InputStream st1 = config.getServletContext().getResourceAsStream("/WEB-INF/classes/jdbc1.properties");
			len = st1.read(b);
			System.out.println(new String(b, 0, len));
		} catch (Exception e) {
			System.out.println("getServletContext().getResourceAsStream = null");
		}

		try {
			System.out.println(config.getServletContext().getRealPath("jdbc2.properties"));
			System.out.println(config.getServletContext().getRealPath("WEB-INF/classes/jdbc1.properties"));
			InputStream st2 = ClassLoader.getSystemResourceAsStream("../../jdbc2.properties"); // exception
//			InputStream st2 = ClassLoader.getSystemResourceAsStream("jdbc1.properties");
			len = st2.read(b);
			System.out.println(new String(b, 0, len));
		} catch (Exception e) {
			System.out.println("ClassLoader.getSystemResourceAsStream = null");
		}
		System.out.println("==========Globle context getAttributeNames============");
		names = config.getServletContext().getAttributeNames();
		while (names.hasMoreElements()) {
			parameterName = names.nextElement();
			System.out.println(parameterName + " ==> " + config.getServletContext().getAttribute(parameterName));
		} 
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");

	}

}
