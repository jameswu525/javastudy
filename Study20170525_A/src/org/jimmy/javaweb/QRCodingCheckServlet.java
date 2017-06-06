package org.jimmy.javaweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QRCodingCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("请求过来啦");
		Enumeration<String> ps = req.getParameterNames();
		boolean result = false;
		while (ps.hasMoreElements()) {
			String name = ps.nextElement();
			String value = req.getParameter(name);
			System.out.println(name + " / " + value);
			if ("vgdecoderesult".equals(name) && ("QRXIDDD20170606100000XBC983E".equals(value) || "CD0021411915E".equals(value))) {
				result = true;
			}
		}
		if (result) {
			System.out.println("successful");
			res.getWriter().append("code=00000&&desc=messageID");
		} else {
			System.out.println("failure");
			res.getWriter().append("code=0010&&desc=messageID");
		}
		
//		if (validateLoginInfor()) {
//			System.out.println("成功");
//			HttpServletRequest httpReq = (HttpServletRequest) req;
//			httpReq.getSession().setAttribute("isLogin", true);
//			req.getRequestDispatcher("index.jsp").forward(req, res);
//		} else {
//			System.out.println("失败");
//			req.getRequestDispatcher("login.jsp").forward(req, res);
//		}
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

}
