http://edu.csdn.net/course/detail/1060/15800?auto_start=1
	JavaWeb  -- by 佟刚


（1）HttpServletRequest 类有setAttribute()方法，而没有setParameter()方法
----


（2） 当两个Web组件之间为链接关系时，被链接的组件通过getParameter()方法来获得请求参数，


（3） 当两个Web组件之间为转发关系时，转发目标组件通过getAttribute()方法来和转发源组件共享request范围内的数据。


一般通过表单和链接传递的参数使用getParameter

通过request.setAttribute("name","jerry")的方式赋值的使用request.getAttribute("name")


这个问题主要是request和session的差别，request范围较小一些，只是一个请求，简单说就是你在页面上的一个操作， request.getParameter()就是从上一个页面中的url、form中获取参数，但如果一个request涉及多个类，后面还要取参数， 可以用request.setAttribute()和request.getAttribute()，但是当结果输出之后，request就结束了。

而session可以跨越很多页面，可以理解是客户端同一个IE窗口发出的多个请求。这之间都可以传递参数，比如很多网站的用户登录都用到了。


一般可以用getParameter得到页面参数。。。字符串。。。

getAttribute()可以得到对象。。。


getParameter可以得到页面传来的参数如？id=123之类的。

getAttribute()常用于servlet页面传递参数给jsp

JSP EL语言定义
----
E L（Expression Language）  目的：为了使JSP写起来更加简单。
   表达式语言的灵感来自于 ECMAScript 和 XPath 表达式语言，它提供了在 JSP 中简化表达式的方法。它是一种简单的语言，基于可用的命名空间（PageContext 属性）、嵌套属性和对集合、操作符（算术型、关系型和逻辑型）的访问符、映射到 Java 类中静态方法的可扩展函数以及一组隐式对象。
----
 属性范围在EL中的名称
 Page          PageScope
 Request          RequestScope
 Session          SessionScope
 Application      ApplicationScope
         
----
pageContext
JSP 页的上下文。它可以用于访问 JSP 隐式对象，如请求、响应、会话、输出、servletContext 等。例如，${pageContext.response} 为页面的响应对象赋值。
param
将请求参数名称映射到单个字符串参数值（通过调用 ServletRequest.getParameter (String name) 获得）。getParameter (String) 方法返回带有特定名称的参数。表达式 $(param.name) 相当于 request.getParameter (name)。
paramValues
将请求参数名称映射到一个数值数组（通过调用 ServletRequest.getParameter (String name) 获得）。它与 param 隐式对象非常类似，但它检索一个字符串数组而不是单个值。表达式 ${paramvalues.name) 相当于 request.getParamterValues(name)。
header
将请求头名称映射到单个字符串头值（通过调用 ServletRequest.getHeader(String name) 获得）。表达式 ${header.name} 相当于 request.getHeader(name)。
headerValues
将请求头名称映射到一个数值数组（通过调用 ServletRequest.getHeaders(String) 获得）。它与头隐式对象非常类似。表达式 ${headerValues.name} 相当于 request.getHeaderValues(name)。
cookie	将 cookie 名称映射到单个 cookie 对象。向服务器发出的客户端请求可以获得一个或多个 cookie。表达式 ${cookie.name.value} 返回带有特定名称的第一个 cookie 值。如果请求包含多个同名的 cookie，则应该使用 ${headerValues.name} 表达式。
initParam	将上下文初始化参数名称映射到单个值（通过调用 ServletContext.getInitparameter(String name) 获得）。

pageScope
将页面范围的变量名称映射到其值。例如，EL 表达式可以使用 ${pageScope.objectName} 访问一个 JSP 中页面范围的对象，还可以使用${pageScope.objectName.attributeName} 访问对象的属性。
requestScope
将请求范围的变量名称映射到其值。该对象允许访问请求对象的属性。例如，EL 表达式可以使用 ${requestScope.objectName} 访问一个 JSP 请求范围的对象，还可以使用${requestScope.objectName.attributeName} 访问对象的属性。
sessionScope
将会话范围的变量名称映射到其值。该对象允许访问会话对象的属性。例如：$sessionScope.name} 
applicationScope
将应用程序范围的变量名称映射到其值。该隐式对象允许访问应用程序范围的对象。



----
JSP 只能放置在除WEB-INF以外的目录；
JSP中可以使用HTML模板
JSP中可以使用脚本片段  <% %>嵌入Java代码，编译后直接参与service方法的运行;
JSP中可以使用表达式EL  <%= %>嵌入表达式，相当于 <% out.write("XXXX") %>;
JSP声明 ，<%! %> 将代码块放到jsp生成文件的service方法外面。 // 仅当了解，几乎不用
JSP注释 <%--    --%> 阻止Java代码运行。
HTML注释 <!--    -->不阻止Java代码

----
以上的JAVA代码中存在9大隐藏对象：
 pageContext, request, session, application,  (-->作用域越来越大)
 out, 
 // 后面的几乎不用 response, config,  page, 
exception// 特殊的时候，申明 <%@ page isErrorPage="true" %>时才使用
分别在：
public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
final javax.servlet.jsp.PageContext pageContext;
javax.servlet.http.HttpSession session = null;
final javax.servlet.ServletContext application;
final javax.servlet.ServletConfig config;
javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
javax.servlet.jsp.JspWriter _jspx_out = null;
javax.servlet.jsp.PageContext _jspx_page_context = null;

----
属性 (以下四个对象 PageContext, request, session, application， 作用域越来越大。)
Object getAttribute(Stirng name);
Enumeration getAttributeNames();
removeAttribute(String name);
void setAttribute(String name, Object value);

@application - ServletContext
	getInitParameter(String)
	getInitParameterNames()
	setInitParameter(String, String)
getAttribute(String)
getAttributeNames()
setAttribute(String, Object)
removeAttribute(String)

@session - HttpSession
getAttribute(String)
getAttributeNames()
setAttribute(String, Object)
removeAttribute(String)

@request - HttpServletRequest extends ServletRequest
getAttribute(String)
getAttributeNames()
	getParameter(String)
	getParameterNames()
	getParameterValues(String)
	getParameterMap()
setAttribute(String, Object)
removeAttribute(String)

@PageContext - JspContext
setAttribute(String, Object)
setAttribute(String, Object, int)
getAttribute(String)
getAttribute(String, int)
findAttribute(String)
removeAttribute(String)
removeAttribute(String, int)

----
请求的转发和重新向
-转发： 只发出一次请求《J2EE的MVC本质》
	地址栏不发生变化
	Servlet中request对象和中转的request是同一个对象
	attribute值能够在被转发的servlet中获取
	request.getRequestDispatcher("/x.jsp").forward();
	只能转发给当前WEB应用的资源
	"/" 代表的是当前应用的根目录
-重定向： 发出两次请求
	地址栏被置为重定向的地址
	Servlet已中的request已经被重新生成
	attribute值重定向的servlet中丢失了
	response.sendRedirect("/x.jsp");
	可以重定向到任何的资源
	"/" 代表的是当前WEB站点的根目录

----
JSP指令 - Key-Value对 可以在同一个指令中放置多个，或者以多条指令
<%@ page 属性=值 %>
	如：<%@  language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ include 属性=值 %>
<%@ taglib 属性=值 %>

建议：指令放置在JSP的起始位置
<%@ page
	language="java"  --必须是java
	contentType="text/html; charset=UTF-8"  --指定响应类型
			--> response.setContentType("text/html; charset=UTF-8");
	pageEncoding="" --指定JSP页面的字符编码，通常与contentType中的编码一致
	isELIgnored="true" --指定当前是否可以使用EL表达式，通常是true
	extends="package.class" --被翻译成java类时继承，不用
	import="java.util.Date" --导入类，不需要记忆
		// 不需要导入以下默认已导入的包
			import javax.servlet.*;
			import javax.servlet.http.*;
			import javax.servlet.jsp.*;
	session="true|false" --当前页面是否允许使用session，重要
	errorPage="/error.jsp" --指定异常错误的页面
	isErrorPage="true" --配合上述错误页面，可以使用exception
		-- 已转发的方式进行。
！！！对于Tomcat服务器而言，WEB-INF下的文件是不能通过浏览器直接输入地址的方式访问
	但可以通过转发是可以访问。
	==>  errorPage="/WEB-INF/error.jsp"
!!! 可以将不希望直接给用户访问的文件放置在WEB-INF下，使用转发的方式访问。
!!! 可以在web.xml中指定errorPage
<error-page><!-- 出错代码：500页面错误 -->
	<error-code>500</error-code>
	<location>/WEB-INF/error.jsp</location>
</error-page>
<error-page> <!-- 出错代码：404页面不存在 -->
	<error-code>404</error-code>
	<location>/login.jsp</location>
</error-page>
或者
<error-page> <!-- 异常类型 -->
	<exception-type>java.lang.xxxxException</exception-type>
	<location>/WEB-INF/error.jsp</location>
</error-page>

---- 文件包含
<%@ include file="b.jsp" %>
通知引擎翻译当前JSP页面时 - @静态引入其他页面。（源码级包含），只有1个java文件
file 如果不使用“/”    则表示相对路径
当前JSP页面与子页面使用同一个Servlet

<jsp:xxx> 标签
<jsp:include  page="b.jsp"></jsp:include>   @动态引入   ，  生成2个java文件 (惊悚片：param传参)
--> org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, “b.jsp", out, false)
被包含的JSP必须有独立运行的servlet
<jsp:forward page=""></jsp:forward>  // 可以传递参数 jsp:param 子标签
--> request.getRequestDispatcher("").forward(req, resp);   

----
JSP中文乱码的问题
① 保证pageEncoding 和 content-Type:charset 都是 “UTF-8”，保存文件格式也要是“UTF-8”
② 浏览器的访问编码指定为相同的“UTF-8”
③ 获取中文参数值 ： 默认传输过程中使用ISO-8859-1编码。   request.setCharacterEncoding("UTF-8");
<form action="hello.jsp" method="post">
	<input type="text" name="username">
</form>
++++++++
// 对于Post请求，必须在使用request之前增加代码： 
request.setCharacterEncoding("UTF-8");
----> <%= request.getParameter("username") %>

// 对于Get请求 - 方式1，不方便
<%
	String val = request.getParameter("username");
	String uname = new String(val.getBytes("iso-8859-1"), "UTF-8");
	out.print(uname);
%>

// 对于Get请求 - 方式2：找到Tomcat的conf/server.xml，找到connector，增加useBodyEncodingForURI="true", Eclipse中的server.xml同样需要修改。
		A)Tomcat的问题 URIEncoding 默认使用了ISO-8859-1
		B)useBodyEncodingForURI
			与POST方式相同    request.setCharacterEncoding("UTF-8");
			----> <%= request.getParameter("username") %>
注：参照tomcat:docs/config/index.html的useBodyEncodingForURI属性。


------------------------------------------------------------
MVC 设计模式











			