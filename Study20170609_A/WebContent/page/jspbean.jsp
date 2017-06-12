<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 标签</title>
</head>
<body>
<jsp:useBean id="user" class="org.jimmy.mvcdemo.entity.UserEntity" scope="session"></jsp:useBean>


<%
	user.setId("12");
%>

<%= user.getId() %>

<jsp:setProperty  name="user"  property="id" value="20"/>
<br>
<br>jsp:setProperty: Value = 
<%
	out.append(user.getId());
%>

<br>
<br>

jsp:getProperty: <jsp:getProperty property="id" name="user"/>
</body>
</html>