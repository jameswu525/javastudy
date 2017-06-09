<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.jimmy.mvcdemo.entity.PropertyEntity" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
<style type="text/css">
.tbl{border:1px solid #F00;cellspacing:0px;cellpadding:1px;}

</style>
</head>
<body>
	<h1>Function 1 的结果页面</h1>
	<table border="1px" bordercolor="#ff0000" cellspacing="0px" cellpadding="5px">
	<tr bgcolor="blue" style="color: white">
		<th>Name</th>
		<th>Street</th>
		<th>AppID</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<%
		List<PropertyEntity> props = (List<PropertyEntity>)request.getAttribute("list");
		for (PropertyEntity entity : props) {
	%>
			<tr>
			<td><%=entity.getName() %></td>
			<td><%=entity.getStreet() %></td>
			<td><%=entity.getApp_id() %></td>
			<td><a href="editProperties.do?id=<%=entity.getId() %>">Edit</a></td>
			<td><a href="deleteProperties.do?id=<%=entity.getId() %>">Delete</a></td>
			</tr>
	<%
		}
	%>
	</table>
</body>
</html>