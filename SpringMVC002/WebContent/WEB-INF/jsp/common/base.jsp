<% String path = request.getContextPath();
	  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	  /*	  
	  String pre = (String)session.getAttribute("CURRENT_URL");
	  String current = request.getRequestURL().toString();
	  System.out.println("Pre=" + pre + "  /  Current=" + current);
	  session.setAttribute("CURRENT_URL", current); 
	  */
	  String pre = (String)request.getAttribute("SERVLET_NAME");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<base href="<%=basePath %>" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="myjs/test.js"></script>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="css/jquery-ui.css" type="text/css" rel="stylesheet">
<link href="mycss/test.css" type="text/css" rel="stylesheet">