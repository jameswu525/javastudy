package org.jimmy.javaweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Loginservlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("请求过来啦'");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		System.out.println(name + " : " +  password);
		
		if (validateLoginInfor()) {
			System.out.println("成功");
			HttpServletRequest httpReq = (HttpServletRequest) req;
			httpReq.getSession().setAttribute("isLogin", true);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			System.out.println("失败");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
	
	private boolean validateLoginInfor() {
		boolean result = false;
		Connection conn = null;
		Statement state = null;
		String url = "jdbc:postgresql://localhost:5432/wx20170324";
		String username = "wx";
		String password = "kerry2016!";
		System.out.println(url + ":" + username);
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, username, password);
			state = conn.createStatement();
			
			ResultSet res = state.executeQuery("select current_date");
			if (res.next()) {
				System.out.println(res.getString(1));
				result = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
