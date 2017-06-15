<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login (Using JQuery and Bootstrap)</title>
<script  type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script  type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css" />
<script  type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div class="container">
	<form method="post" id="loginForm" action="login.do" class="form-horizontal">
	<%
	Object value = request.getAttribute("message"); 
	if (value != null) out.append(String.valueOf(value)); 
%><br>
		<fieldset>
			<legend><label><span class="glyphicon glyphicon-user"></span>&nbsp;用户登录</label></legend>
			<div class="form-group" id="userDiv">
				<label class="col-md-3 control-label" for="user">用户名</label>
				<div class="col-md-5">
					<!--  id 为js服务， name为jsp服务  -->
					<input type="text" id="user" name="user" class="form-control">
				</div>
				<div class="col-md-4" id="userSpan"></div>
			</div>
			
			<div class="form-group" id="pwdDiv">
				<label class="col-md-3 control-label" for="pwd">密码</label>
				<div class="col-md-5">
					<!--  id 为js服务， name为jsp服务  -->
					<input type="password" id="pwd" name="pwd" class="form-control">
				</div>
				<div class="col-md-4" id="pwdSpan"></div>
			</div>
			<div class="form-group" id="butDiv">
				<div class="col-md-5 col-md-offset-3">
					<input type="submit" id="subBut" value="Submit" class="btn btn-l btn-primary">
				</div>
			</div>
		</fieldset>
	</form>


</div>
</body>
</html>