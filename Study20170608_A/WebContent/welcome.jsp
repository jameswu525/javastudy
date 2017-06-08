<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
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
		session.setAttribute("session", "Session Attribute");
		request.setAttribute("temp", "This is attribute.");
	%></a>
	
	<h1><%= request.getParameter("user") %></h1>
	<h2><%= request.getAttribute("temp") %></h2>
	<h3>abc ${temp} - ${param.user}</h3>
	<h1>-----------------------------</h1>
	<h2>==${applicationScope.user-name }</h2>
	<h2>==${requestScope.param.user }</h2>
	<%= session.getAttribute("session") %>
	<%
	out.append(String.valueOf(request.getAttribute("temp")));
	// session.getAttribute("session");
	System.out.println(session.getId());
//	System.out.println(session.getId());
	System.out.println(application.getInitParameter("user-name"));
	System.out.println(config.getInitParameter("welcome"));    // 开发中几乎不用 ， 包括response, page 几乎不使用
	
	%>
	<%--
	<%
	System.out.println("JSP注释内容");
	%>
	 --%>
	 
	<!--
	<%
	System.out.println("HTML注释内容");
	%>
	 -->
</body>
</html>