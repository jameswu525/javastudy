<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="habit.do" method="post">
	<h1>Welcome!</h1>
	Your Habit
	<br>
	<input type="checkbox" name="habit" value="Swimming"/>Swimming<br>
	<input type="checkbox" name="habit" value="Sports"/>Sports<br>
	<input type="checkbox" name="habit" value="Reading"/>Reading<br>
	
	<input type="hidden" name="name" value=""/>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>