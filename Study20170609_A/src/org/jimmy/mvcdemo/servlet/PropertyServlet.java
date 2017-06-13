package org.jimmy.mvcdemo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jimmy.mvc.servlet.BasicServlet;
import org.jimmy.mvcdemo.entity.PropertyEntity;
import org.jimmy.mvcdemo.service.PropertyService;

public class PropertyServlet extends BasicServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 检索properties表，将其显示在界面中。
		List<PropertyEntity> list = new PropertyService().getAllProperties().getList();
		//${pageContext.request.contextPath}/page/main.jsp?page=
		System.out.println("/page/main.jsp?page=property.jsp");
		request.setAttribute("list",  list);
		request.getRequestDispatcher("/page/main.jsp?page=property.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
