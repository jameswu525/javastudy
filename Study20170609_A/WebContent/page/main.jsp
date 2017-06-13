<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Demo</title>
<style> 
#header{padding-top:5px;width:100%;height:20px;margin-bottom:15px;}
#main{padding-left:5px;width:100%;height:auto;}
#left{width:20%;height:800px;border:1px solid #F00;}
#right{width:70%;height:800px;border:1px solid #F00;}
#left,#right{float:left;}
</style> 
</head>
<body>
	<div id="header">Welcome ${sessionScope.login_infor.username } </div>
	<div id="main">
		<div id="left"><jsp:include page="/page/menu.jsp"></jsp:include></div> 
		<div id="right">
			<%
				if (request.getParameter("page") == null) {
					%>
					<h2>Welcome </h2>
					<%
				} else {  %>
				<jsp:include page="${param.page}"></jsp:include>
				<%
				}
			%>
		</div>
	</div>
</body>
</html>