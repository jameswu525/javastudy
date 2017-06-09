<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form action="login.do" method="post">
<%
	Object value = request.getAttribute("message"); 
	if (value != null) out.append(String.valueOf(value)); 
%><br>
	User: <input type="text" name="user"><br>
	Password: <input type="password" name="pwd"><br>
	<input type="submit" value="Submit">
</form>
</body>
</html>