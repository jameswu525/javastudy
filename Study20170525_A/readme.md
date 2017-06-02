Java Web视频教程

1, Tomcat下载、解压、环境变量，并配置JAVA_HOME
2, 启动、关闭  startup、shutdown
 	 或者使用catalina run/start/stop
 
--- 
 第一个案例，手工创建Web项目结构
 创建第一个普通Java Project项目FistJavaWebWithJavaProject， 修改目录结构为：
 WebContent
 	-	WEB-INF
 		-lib
 		-classes (修改项目的编译目录)
 		-web.xml (从Tomcat的已有sample项目中复制一份)
 	- hello.jsp
 拷贝WebContent目录到Tomcat的webapps目录并改名后，直接就能通过http://localhost:8080/helloJavaWeb/hello.jsp查看结果。
 --------Person类
 package org.jimmy.test;

public class Person {
	public String getPersonInfor() {
		System.out.println("S!!! Hello!!!");
		return "S!!! Hello!!!";
	}
}
---------hello.jsp页面
<%@ page import="org.jimmy.test.Person" %>
... ... 
<h1>Welcom !</h1>
<% Person p = new Person();
	p.getPersonInfor(); %>
---- 
@	以上步骤需要手工拷贝文件夹至Tomcat目录，比较繁琐，可以通过该方法解决：
	在Tomcat的目录 \conf\Catalina\localhost 中创建hello.xml文件，具体内容如下
	<Context path="/hello" docBase="E:\\workspace\\FistJavaWebWithJavaProject\\WebContent" reloadable="true"/>
	如此即可让Tomcat自动加载我们的工作目录，而无需多次拷贝。  http://localhost:8080/hello/hello.jsp
---- 
	通过JavaEE视图创建Dynamic Java Web工程，更方便的进行web开发。
		新建一个Tomcat Server，创建Dynamic Web项目，运行在Server启动服务。
		注：通过Eclipse的Windows-perspective-Customized自定义新建的快捷菜单。
		java、web、xml、general等
---
创建动态web工程Study20170525_A，新建class 实现 servlet   public class HelloServlet implements Servlet
web.xml中配置servlet-name以及servlet-mapping

  <servlet>
  	<servlet-name>hello</servlet-name>
  	<servlet-class>org.jimmy.javaweb.HelloServlet</servlet-class>
  	<load-on-startup>1</load-on-startup>   -- 使用这个参数，将在tomcat启动时加载该servlet并init
  	<!-- 0~?   数字越小越早被创建，若为负数则需要在第一次请求是才能创建 -->
  </servlet>
  
  <servlet-mapping>   -- 一个Servlet可以有多个mapping对应
  	<servlet-name>hello</servlet-name>
  	<url-pattern>/hello</url-pattern>    -- 可以使用通配符 *.do(带扩展名的不能加/, 即不能使用/*.do)    或者  /*  (任意)
  </servlet-mapping>
  
启动服务，通过url访问servlet的url-patten
http://localhost:8080/Study20170525_A/hello
----
Servlet容器： 运行Servlet、JSP、Filter、Listener、Tag等的软件环境
	创建Servlet并调用Servlet的相关生命周期方法；(容器负责调用)
		构造器、 (Servlet是单例的)
		init、(构造完立即init)
		service、
		destroy 
----
ServletConfig  配置信息，并且可以获取ServletContext对象。
	获取初始化参数	web.xml 中的 <init-parameter>
	获取全局的Context参数
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			parameterName = names.nextElement();
			System.out.println(parameterName + " ==> " + config.getInitParameter(parameterName));
		}
		System.out.println("==========Globle context parameter============");
		names = config.getServletContext().getInitParameterNames();
		while (names.hasMoreElements()) {
			parameterName = names.nextElement();
			System.out.println(parameterName + " ==> " + config.getServletContext().getInitParameter(parameterName));
		}
----
Servlet Context 可以通过config.getServletContext()获取
		String realPath = config.getServletContext().getRealPath("readme.md");
		--src
			--jdbc1.properties
		--WebContent
			jdbc2.properties
		InputStream st1 = config.getServletContext().getResourceAsStream("jdbc2.properties");
		InputStream st1 = config.getServletContext().getResourceAsStream("/WEB-INF/classes/jdbc1.properties");
		InputStream st2 = ClassLoader.getSystemResourceAsStream("../../jdbc2.properties"); // =====>exception
		InputStream st2 = ClassLoader.getSystemResourceAsStream("jdbc1.properties");
----
GET请求方式   ==》  指定Form的请求方式“Get”， 点击超链接，或者在地址栏直接输入URL，使用Get方式传参的格式，一般在1KB以下；
POST请求方式 ==》  FORM表单中指定“POST”，能够传输数据大得多
----
获取request的参数列表，注意使用getParameterValues。。。 或者getParameterMap
String[] habits = request.getParameterValues("habit");   ///////
for (String habit : habits) {
	response.getWriter().append("\nHabits: => " + habit + "");
	System.out.println("==> " + habit);
}
System.out.println("============================");
Map<String, String[]> map = request.getParameterMap();  ////////
for (Map.Entry<String, String[]> entry : map.entrySet()) {
	System.out.println("***" + entry.getKey() + " : " + Arrays.asList(entry.getValue()));
}
getParameterNames
getParameterValue("name");

----
