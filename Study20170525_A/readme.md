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



