<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String url = request.getParameter("url");
 out.append(url);
 out.append("==============================");
 pageContext.forward(url);  
 %>
