<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/jsp/common/base.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
	<div class="container">
	<h1>SUCCESS!!!</h1>
		<div class="row">
			<div class="col-md-12">
				<p><strong>请求来源于</strong> <%=basePath %><%=pre %></p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p>requestScope=
					<c:if test="${not empty requestScope.test001}">  
	    				${requestScope.test001}
					</c:if>
					<c:if test="${empty requestScope.test001}">  
					    <span class="warning">!!!没有放置该参数!!!</span>
					</c:if>  
				</p>
			</div>
			<div class="col-md-6">
				<p>request=<%=request.getAttribute("test001")%></p>
			</div>
		</div>
	</div>

</body>
</html>