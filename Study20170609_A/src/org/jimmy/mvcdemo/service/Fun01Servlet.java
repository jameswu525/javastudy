package org.jimmy.mvcdemo.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jimmy.mvc.service.Service;
import org.jimmy.mvcdemo.entity.PropertiesEntity;
import org.jimmy.mvcdemo.pojo.PropertiesPojo;

public class Fun01Servlet extends Service {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean validat = true;
		// 检索properties表，将其显示在界面中。
		
		List<PropertiesEntity> list = new PropertiesPojo().getProperties().getList();
		
		request.setAttribute("list",  list);
		request.getRequestDispatcher(this.getServletConfig().getInitParameter("page")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
