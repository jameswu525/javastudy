<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
 <%@ page import="java.util.ArrayList" %>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="j"  uri="http://www.kerryprops.com/org/jimmy/taglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("----------------~~~~~~~~~~~~~~~~");
	List<String> list = new ArrayList<>();
	list.add("AA");
	list.add("BB");
	list.add("CC");
	request.setAttribute("strings", list);
%>
	<c:forEach items="${requestScope.strings}" var="item">
		-->item: ${item }  <br>
	</c:forEach>
	
	<br>
	<j:hello/>
</body>
</html>