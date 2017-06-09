<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.jimmy.mvcdemo.entity.PropertiesEntity" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
<style type="text/css">
.tbl{padding-left:5px;width:80%;height:auto;border:1px solid #F00;cellspacing:0px;cellpadding:0px;}
.tbl_tr{border:1px solid #F00;}
.tbl_td{border:1px solid #F00;}
</style>
</head>
<body>
	<h1>Function 1 的结果页面</h1>
	<table class="tbl">
	<%
		List<PropertiesEntity> list = (List<PropertiesEntity>)request.getAttribute("list");
		for (PropertiesEntity entity : list) {
	%>
			<tr class="tbl_tr">
			<td class="tbl_td"><%=entity.getName() %></td>
			<td class="tbl_td"><%=entity.getStreet() %></td>
			<td class="tbl_td"><%=entity.getApp_id() %></td>
			</tr>
	<%
		}
	%>
	</table>
</body>
</html>