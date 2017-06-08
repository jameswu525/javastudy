package org.jimmy.service;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends HttpServlet {
	private String username = null;
	private String password = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		username  = getServletContext().getInitParameter("user-name");
		password = getServletContext().getInitParameter("password");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String par_username = req.getParameter("user");
		String par_password = req.getParameter("pwd");
		
		System.out.println(username + "/" + password);
		System.out.println(par_username + "/" + par_password);
		
		if (username.equals(par_username) && password.equals(par_password)) {
			req.getSession().putValue("JimmyKey", "value");
			resp.getWriter().println("Hello " + par_username);
			req.getRequestDispatcher("/welcome.j").forward(req, resp);
		} else {
			resp.getWriter().println("Sorry " + par_password);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
