<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL</title>
</head>
<body>
<%
System.out.println("----------------~~~~~~~~~~~~~~~~");
request.setAttribute("NNN", "YES");
request.setAttribute("MMM", "12");
session.setAttribute("MMM", "13");
application.setAttribute("MMM", "14");
%>
<jsp:useBean id="user" class="org.jimmy.mvcdemo.entity.UserEntity" scope="session" />
<jsp:setProperty name="user" property="id" value="30"/>
	<form action="${pageContext.request.contextPath}/page/main.jsp?page=EL.jsp" method="post">
	username:<br>
	request : <input type="text" name="username" value="<%=request.getParameter("username") %>"><br>
	request : <input type="text" name="username2" value="<%=request.getParameter("username") == null ? "":request.getParameter("username") %>"><br>
	EL - param: <input type="text" name="username3" value="${param.username}"><br>
	EL - request: <input type="text" name="username4" value="${requestScope.NNN}"><br>
	EL - session .: <input type="text" name="username5" value="${sessionScope.user.id}"><br>
	EL - session['']: <input type="text" name="username51" value="${sessionScope['user'].id}"><br>  // 如果其中的参数名称有特殊字符，需要使用['xxx.xx.x']的方式取值
	
	EL - page>request>session>application <input type="text" name="username6" value="${MMM}"><br>
	EL - cacl <input type="text" name="username7" value="${param.username +8}"><br>
	java - 不计算 <input type="text" name="username71" value='<%= request.getParameter("username") + 8%>'><br>
	<input type="submit" value="Submit">
	</form>
</body>
</html>