http://getbootstrap.com/getting-started/#download
下载 Bootstrap 源

http://jquery.com/download/
下载 JQuery 代码

跟着龙哥学 JavaWeb
http://edu.csdn.net/course/detail/1830/28143?auto_start=1
----
TODO ： 第六章：在线购物车设计和令牌机制以及验证码使用  2017/6/16
TODO:  JavaWeb开发之使用Apache的FileUpload组件完成基本上传操作  2017/6/17
----


web.xml的web-app节点中的参数：
metadata-complete="true"   不扫描注解
metadata-complete="false"  扫描注解, 缺省！

注解：
在每个Servlet的class头部加入：
@WebServlet("/xxx")   或者 @WebServlet(urlPatterns={"/x1", "/x2"})
其他参数：loadOnStartup=n
			initParams=@WebInitParam(name="", value="")
			
//// 配置文件 和 注解 的选择<没有绝对的好>
开发角度：注解简单，变成了硬编码
维护角度：维护困难
建议：一般通用配置一般使用xml完成，特定/个体配置使用注解
WEB总和其他框架集成，只能使用xml配置。

=======
1， Servlet可以实现javax.servlet.SingleThreadModel接口，可以使Servlet成为单线程模式，解决线程不安全！！！但非常不推荐，导致系统效率低下。
*2， 不使用成员变量，避免多线程共享变量。

