http://study.163.com

=========================================================================
1） Github网站中创建项目javastudy   https://github.com/jameswu525
	指定Public权限以及README.md
	得到Git资料库地址：https://github.com/jameswu525/javastudy.git

// 错误2） 在eclipse中右键-project-Git， 创建本地资料库
// 错误	选择本地资料库存储地址（不勾选Bare -- 空白）

2） 拷贝第一步的地址，在Git Repositories视图中右键，Paste Git URI（或者点击Clone A Git repository），下一步
	选择master，下一步选择项目文件存放目录（即开发目录）
	完成后，资料库视图中出现在线创建的项目名称的目录。
	右键属性，增加key-value user.nam以及user.email，
	

3） eclipse中创建项目或者导入已有的项目（在workspace目录下），点击右键-team-share project，选择刚刚导入的Git项目。
	项目将搬进刚才资料库的本地目录中。
	右键项目，team-commit，全选Unstaged Changes，并拖入Staged Changes
	键入commit message后点击 Commit，或者Commit and Push（Commit并存入Git）
	稍后片刻，成功后查看Git项目文件。

注： 导入已存在的Git项目，同上操作，得到在线的Project后，eclipse导入已存在项目。
合作开发（Fork项目、修改后Commit、Push，Pull request给原项目作者）的方式： http://blog.csdn.net/qq_26787115/article/details/52133008

Eclipse中Help-Market，搜索需要的plugin插件后安装。

=================================================================

和系统相关的常用类：
1， System
	System.gc(); // 强制运行回收，以上不用的对象将被清理，  一般不用！！！
2， Runtime   -> Runtime.getRuntime.gc();

Math
abs

BigDecimal
0.01 + 0.09  // 0.09999999999999999
创建BigDecimal时建议使用String构造



String   // 不可变字符串
StringBuffer // 可变字符串
StringBuilder // 可变字符串



================MAVEN=====================
http://maven.apache.org/release-notes-all.html
==> Binary zip archive	apache-maven-3.5.0-bin.zip
两个环境变量可以配置：
MAVEN_HOME = D:\maven\apache-maven-3.5.0
MAVEN_OPTS = -Xms128m -Xmx512m(可选)
在path变量末尾加入“%MAVEN_HOME%\bin;”
验证是否安装成功       mvn -v
(http://blog.csdn.net/jiuqiyuliang/article/details/46053543)

使用 Maven 给我们带来的最直接的好处，就是统一管理jar 包，那么这些 jar 包存放在哪里呢？它们就在您的 本地仓库 中
实际上我们可以将本地仓库理解“缓存”，目的是存放jar包。开发项目时项目首先会从本地仓库中获取 jar 包，当无法获取指定 jar 包的时候，本地仓库会从 远程仓库（或 中央仓库） 中下载 jar 包，并“缓存”到本地仓库中以备将来使用。
远程仓库（中央仓库）是 Maven 官方提供的，可通过 http://search.maven.org/ 来访问
Maven会将下载的类库（jar包）放置到本地的一个目录下，如果想重新定义这个目录的位置就需要修改Maven本地仓库的配置：

修改文件：D:\maven\apache-maven-3.2.3\conf\setting.xml
--> <localRepository>D:\maven\repository</localRepository>

mvn help:system
执行完该命令之后，在D:\maven\repository下面就会多出很多文件，这些文件就是maven从中央仓库下载到本地仓库的文件，maven已经开始为我们工作了。


Eclipse 中配置
点击Installations –> add 选择maven安装目录，这里我的Maven安装目录为D:\maven\apache-maven-3.2.3，选择你的Maven安装目录，并点击确定, 之后可以点击Apply,点击OK，即可完成 

设置User Settings 
Global Settings选择maven 安装目录下conf文件夹下的settings.xml，这里我的Maven安装目录为D:\maven\apache-maven-3.2.3\conf\settings.xml，选择你的Maven安装目录，检查Local Repository 项，如果为D:/maven/repository则配置成功

创建测试的maven项目，新建Project-Maven-Simple-org.jimmy | maventest | jar(普通)/war(web)
web项目需要在src/main/webapp下创建META-INF、WEB-INF以及 


=====================================================================
http://tomcat.apache.org/       8.5.14
下载zip并且解压后，参照官方document   http://tomcat.apache.org/tomcat-8.5-doc/setup.html

参照 http://blog.csdn.net/lixingshi/article/details/49874213
添加TOMCAT_HOME的环境变量，值为d:\Program Files\tomcat7。再添加CATALINA_HOME环境变量，值为%TOMCAT_HOME%，在添加CATALINA_BASE环境变量，值为%TOMCAT_HOME%。免安装的版本需要这两个环境变量，写成带“%”号的这样作是为了以后更改版本的方便，可以直接修改TOMCAT_HOME的值，改变CATALINA_HOME和CATALINA_BASE的值。
修改根目录下的bin文件夹下startup.bat文件
或者增加JAVA_HOME环境变量
C:\>service.bat install
tomcat8w.exe 打开控制面板  、服务里面打开/关闭         或者以下方式：
net start服务名
net stop服务名
http://localhost:8080/

Eclipse内配置Server ，增加TOMCAT8.5

配置Tomcat的管理员
conf/tomcat-users.xml
<role rolename="manager-gui"/>
<user username="tomcat" password="s3cret" roles="manager-gui"/>
===========================================================
AutoSecurity

1, 硬件准备
	STC8051单片机 （准备3片，以备用） 16针脚输入，16针脚输出
	电路板（需要定制）
	扬声器（蜂鸣器）
	电机（1~2W）需要设置两个干接点，作为行程开关
	红外线感应器
2, 辅助工具
	编程工具（由购买单片机商家推荐）
	程序烧录的硬件套件（8051单片机是一次性写入，有错误要换新的模块）
3, 设计过程
	设计电路板、连接硬件、编写单片机程序（汇编语言）。
		http://www.openedv.com/posts/list/47657.htm
==============================================================

Java 异常
Throwable - Error
	  - Exception - Checked Exception
		      - RuntimeException   - NotChecked Exception
注： 1 Error 不能由程序处理
     2 继承RuntimeException 程序可处理可不处理，编译器不做强制  如NullPointException、OutofboundException
     3 其他Exception必须由程序处理，属于强制处理。  如IOException、FileNotFoundException
	CheckedException如果不在程序内处理，必须在方法名后Throws抛出

Finally是最终必须运行的代码，一般是资源关闭类的处理，前提是catch中不做System.exit();
在Try中return语句先预处理，在此之前必须先处理finally语句后再处理try，注意：如果finally中对try return的变量进行处理，则try中return值保持不变。
如果finally中return则try中return会被忽略；

Java7之后，在finally中的关闭资源操作可以直接省略，使用
try (Stream file = new FileStream("");) { //注：()中的代码，new出的资源必须实现Closeable接口，java内核中的资源类均符合；
    ...
} catch {
    ...
}


==============================================================



