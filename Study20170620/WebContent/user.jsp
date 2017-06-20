<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = pageContext.getServletContext().getContextPath() + "/";
	request.setAttribute("basepath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Work with Student</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/user.js"></script>
</head>
<body>
	<form action="${basepath}s1/student" method="post">
		<a>BasePath is  ${basepath}</a>
		<hr/>
		UserName : <input name="uname" id="uname"  type="text">
		Age: <input name="age" id="age" type="text" onchange="checkValidate()"><input id="ageMsg" readonly="readonly">
		<input id="btnSubmit" type="submit" name="提交">
	</form>
</body>
</html>