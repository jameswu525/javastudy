<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/jsp/common/base.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"><!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Projects Name</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<form class="navbar-form navbar-right">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Email">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-success">Sign in</button>
		</form>
	</div>
	<!-- /.navbar-collapse --> </nav>
<div class="jumbotron">
			<div class="col-md-12">
				<p>以下是学习中的案例</p>
			</div>
	<div class="container">
		<div id="spaceDiv"></div>
		<div class="row">
			<div class="col-md-1">
				1
			</div>
			<div class="col-md-5">
				<a href="m01/hello">Hello World</a>
			</div>
			<div class="col-md-6">ModelAndView跳转，Class和Method上同时定义@RequestMapping</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				2
			</div>
			<div class="col-md-5">
				<form action="test01" method="POST">
					<input type="submit" value="POST" class="btn btn-primary">
					<a href="test01" class="btn btn-large">GET请求失败</a><br/>
				</form>
			</div>
			<div class="col-md-6">只能接受POST请求</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				3
			</div>
			<div class="col-md-5">
					<a href="test02?username=Jimmy" class="btn btn-large">含username</a>&rarr;<a href="test02" class="btn btn-large">不含username请求失败</a>
			</div>
			<div class="col-md-6">只能接受包含param{username}</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				4
			</div>
			<div class="col-md-5">
					<a href="test03/xyz/main" class="btn btn-large">/test03/*/main</a><br/>
			</div>
			<div class="col-md-6">/test03/*/main， * 通配符</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				5
			</div>
			<div class="col-md-5">
					<a href="test04/speciedvalue" class="btn btn-large">value从路径中获取</a><br/>
			</div>
			<div class="col-md-6">@PathVariable参数中获取的val值</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				6
			</div>
			<div class="col-md-5">
					<a href="test05/sessionAttributes" class="btn btn-large">Session域</a><br/>
			</div>
			<div class="col-md-6">将参数存储在Session域中</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				7
			</div>
			<div class="col-md-5">
				<form action="test06/params" method="POST">
					<a href="test06/params?username=yes" class="btn btn-large">RequestParam - Get</a>
					<input type="hidden" name="username" value="hidden-yes"/>
					<input type="submit" value="POST" class="btn btn-primary">
				</form>
			</div>
			<div class="col-md-6">试验RequestParam</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				8
			</div>
			<div class="col-md-5">
				<form action="test07/RequestAttributes" method="POST">
					<input type="hidden" name="id" value="100"/>
					<input type="text" name="username" value="Jimmy"/>
					<input type="text" name="age" value="12"/>					
					<input type="submit" value="POST" class="btn btn-primary">
				</form>
			</div>
			<div class="col-md-6">RequestAttributes</div>
		</div>
		
	</div>
	<!-- /.container-fluid -->
</div>
</body>

</html>