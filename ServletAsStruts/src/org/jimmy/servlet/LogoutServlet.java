package org.jimmy.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jimmy.servlet.i.IStructsServlet;

public class LogoutServlet implements IStructsServlet{
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("LogoutServlet");
	}
}
