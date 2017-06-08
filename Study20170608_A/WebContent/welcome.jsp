<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> welcome , <% out.append(request.getParameter("user")); %></p>
	<a><%
		System.out.println(new Date().toLocaleString());
		out.append(new Date().toLocaleString());
		System.out.println(page.getClass().getName());
		System.out.println(session.getValue("JimmyKey"));

		System.out.println(config.getInitParameter("welcome"));
	%></a>
</body>
</html>