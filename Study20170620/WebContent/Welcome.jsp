<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Welcome</title>
 <link href="<s:url value="/css/tutorial.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h3>Commands</h3>
<ul>
 <li><a href="<s:url action="Register"/>">Register</a></li>
 <li><a href="<s:url action="Logon"/>">Sign On</a></li>
</ul>
</body>
</html>