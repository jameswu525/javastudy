<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
	<h4><a href="#">Menu</a></h4>
	<ul>
		<li><a href="${pageContext.request.contextPath}/property.do">功能1</a>查询并删除行</li>
		<li></li>
		<li><a href="${pageContext.request.contextPath}/page/main.jsp?page=jspbean.jsp">功能2</a>Bean 标签</li>
		<li></li>
		<li><a href="${pageContext.request.contextPath}/page/main.jsp?page=EL.jsp">功能3</a>EL语法</li>
		<li></li>
		<li><a href="${pageContext.request.contextPath}/page/main.jsp?page=tagsample.jsp">功能4</a>Tag JSTL</li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</body>
</html>