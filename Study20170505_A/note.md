﻿﻿http://study.163.com

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

多线程
并行：两个以上事件在同一时刻点发生；  （多核，同时点执行多个）
并发：两个以上事件在同一时间段内发生；（单核只能并发，不能并行）

两种启动多进程的方法：
		Runtime rt = Runtime.getRuntime();
		rt.exec("Notepad");  // Runtime
		ProcessBuilder pb = new ProcessBuilder("Notepad");
		pb.start();				// ProcessBuilder
		
创建现成的两个方法；
// 方法1：继承Thread 类
class XXX extends Thread{run() {...}}
     new XXX().start();   // 实现run方法，但不能运行run();
==>或者
new Thread(){run(){...}}.start();

//实现Runnable接口
class YYY implement Runnable{run(){...}}
    new Thread(new YYY(), "").start();
==>或者匿名内部类
new Thread(new Runnable(){run(){...}).start();
    
---------------------
并发线程安全 ：  
同步代码块  synchronized(lock) {...}

--> 主程序
		Apple apple = new Apple();
		new Thread(apple, "小A").start();
		new Thread(apple, "小B").start();
		new Thread(apple, "小C").start();
		
-->apple的同步代码块写法		
	public void run() { // 同步代码块，synchronized(同一个资源对象)
		for (int i = 1; i <= 50; i++) {
			synchronized (this) { // synchronized不能修饰到for之前，否则代码全被一个线程执行完。
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + " Eat apple " + num--);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}



-->同步方法写法 //隐含了同步锁 = this
	public void run() { // 同步方法 如果直接用synchronized修饰run，第一个线程可能就执行完整个方法。
		for (int i = 1; i <= 50; i++) {
			doWork();
		}
	}
	//--
	private synchronized void doWork() {
		if (num > 0) {
			System.out.println(Thread.currentThread().getName() + " Eat apple " + num--);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
------------
缺点：使用了synchronized方法/代码块的性能不高。尽量减小synchronized的作用域

案例：
1） StringBuilder（推荐 效率高）  和 StringBuffer（所有方法相同，多了synchronized修饰符，效率底）

2） ArrayList 和 Vector（ArrayList的前身，加了synchronized）
      HashMap 和 Hashtable（HashMap的前身，加了synchronized）

/// 单例模式 - 饿汉模式
private ArrayUtil() {}
private static ArrayUtil instance = new ArrayUtil();
public static ArrayUtil getInstance() {return instance;}
/// 单例模式 - 懒汉模式
private ArrayUtil() {}
private static ArrayUtil instance = null;
public static ArrayUtil getInstance() {if (instance == null) {instance = new ArrayUtil();}return instance;}
  ... 以上getInstance方法线程不安全 改为：
private ArrayUtil() {}
private static ArrayUtil instance = null;
public static ArrayUtil getInstance() {
synchronized(ArrayUtil.class) {
if (instance == null) {instance = new ArrayUtil();}
}
return instance;} //减小synchronized作用域，建议代码块
  ... 双重检查加锁 java1.4之前没有作用，instance增加volatile关键字，直接操作内存，而不在本线程缓存。但是会屏蔽编译器的优化机制，运行效率不高。
  private ArrayUtil() {}
private static volatile ArrayUtil instance = null;  //不被缓存，java5之后生效
public static ArrayUtil getInstance() {
if (instance == null) {
	synchronized(ArrayUtil.class) {
	if (instance == null) {instance = new ArrayUtil();}
	}
}
return instance;} //减小synchronized作用域，建议代码块
/////////////鉴于以上原因，推荐使用饿汉形式。。。。。


-->同步锁
Lock机制具有同步代码块的所有功能，而且体现面向对象。
private final Lock lock = new ReentrantLock(); // 创建锁对象
run方法同同步方法，调用doWork()方法
	private void doWork() {
		lock.lock();// 加锁 
		try {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + " Eat apple " + num--);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();// 释放锁
		}
	}
	
	
--------------生产者/消费者 案例
public class SharedObj {
	private String name = "";
	private String general = "";
	private boolean isEmpty = true;
	public synchronized void push(String name, String general) {
		try {
			if (!isEmpty) {
				this.wait();
			}
			this.name = name;
			this.general = general;
			Thread.sleep(10);
			this.isEmpty = false;
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void pop() {
		try {
			if (isEmpty) {
				this.wait();
			}
			Thread.sleep(10);
			System.out.println(this.name + "-" + this.general);
			this.isEmpty = true;
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

-----使用同步锁的方法 java5中提供lock机制的通信控制
	private String name = "";
	private String general = "";
	private boolean isEmpty = true;
	private ReentrantLock lock = new ReentrantLock();
	private Condition con = lock.newCondition();
	public void push(String name, String general) {
		lock.lock();
		try {
			while (!isEmpty) {
				con.await();
			}
			this.name = name;
			this.general = general;
			Thread.sleep(10);
			con.signalAll();
			isEmpty = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void pop() {
		lock.lock();
		try {
			while (isEmpty) {
				con.await();
			}
			Thread.sleep(10);
			System.out.println(this.name + "-" + this.general);
			isEmpty = true;
			con.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

------------2017/5/16
死锁 ： 避免方法为 让每个线程按照一样的顺序访问资源A、B、C

线程的6个状态Thread.state(New, Runnable, wait, wait time, block, Stop)

Thread.sleep(n); // 释放CPU，但是不释放资源锁。

Thread.join(); //将现有线程与所在线程合并，待另一线程完成后再执行当前线程。

前台线程：默认前台线程，可以通过Thread.setDemon(true)设置为后台线程，必须在start之前设置。
后台线程：守护线程，当主线程结束后，后台线程也就结束。

线程优先级：
MAX_PRIORITY = 10
MIN_PRIORITY = 1
NORM_PRIORITY = 5
int getPriority 返回优先级， void setPriority(*) 更改优先级，子线程与主线程默认相同 

--------------
线程礼让  yield()   ---- 一般不用
通知JVM自己可以礼让出CPU，不一定会让出CPU， 状态转变为就绪状态。

了解线程组 ThreadGroup

------------------------------------------
集合操作的工具类
Arrays     Collections
toArrays  
List<String> list = Arrays. asList("", ""); // 固定长度的list，不能增加删除

Collections
空集： EMPTYLIST, EMPTYMAP, EMTPYSET  --> new ArrayList // java7之后返回空集






---泛型类
public class X<T> {
}
---泛型方法
public static <T> List<T> asList(T... a) {}
==> public static <T> List<T> asList(T[] a) {}


==================================================

序列化  implements Serializable
static 和 transient 修饰的字段不会被序列化。<例如密码，字节流等不该被序列化>
序列化版本号 serialVersionUUID，Java通过该字段判断是否字节码相同，否则报错。
  在需要序列化的类中提供一个固定的序列化UUID，Java判断就会相同。
  ================
properties文件加载。   Properties类
p = new Properties().load(new FileInputStream(""));
p.getProperties("");

RandomAccessFile 任意位置读写  用于断点/多线程下载文件。
NIO  new IO Java4开始提出，主要用于服务器提高性能，我们代码依然用传统IO。
  NIO提供通道和缓存
注：Java7中提出了更新的IO， NIO2.0 提供异步IO   --> Files工具类

----------------------------------------
InputStream -- OutputStream         四大基流
Reader -- Writer
----------------------------------------
 File RandomAccessFile  Files
---------------------------------
文件流： FileInputStream/FileOutputStream  FileReader/FileWriter
缓冲流： BufferedInputStream/BufferedOutputStream  BufferedReader/BufferedWriter
转换流（字节流转换为字符流）： InputStreamReader/OutputStreamWriter
内存流（临时存储）： ByteArrayInputStream/ByteArrayOutputStream/CharArrayReader/CharArrayWriter/StringReader/StringWriter
顺序流（合并流）： SequenceInputStream  
对象流（序列化/反序列化）： ObjectInputStream/ObjectOutputStream
打印流： PrintStream/PrintWriter
数据流： DataInputStream/DataOutputStream
管道流（线程通信）： PipedInputStream/PipedOutputStream/PipedReader/PipedWriter 


================================================
网络
TCP 服务端 ServerSocket,  客户端 Socket   ServerSocket.accept
UDP 发送端/接收端DatagramSocket

-----------------------------------------------------
// 1
Class<Date> clz1 = Date.class;
// 2
Date date = new Date();
Class<?> clz2 = date.getClass();
// 3 推荐使用的！！！
Class<?> clz3 = Class.forName("java.util.Date");
--通过反射可以绕过单例模式，但在单例中增加构造器判断则可以阻止该漏洞。-------------
			Class<?> clz4 = Class.forName("org.jimmy.reflect.PrivateClass");
			for (Constructor<?> c : clz4.getDeclaredConstructors()) {
				c.setAccessible(true); // AccessibleObject
				PrivateClass pvC = (PrivateClass) c.newInstance();
				System.out.println(pvC.getClass().hashCode());    // 通过 throw new CannotNewSingleInstanceException("不能多次生成单例实例。");  禁止反射
			}
--
静态引入
import static java.lang.Math.PI
System.out.println(PI);

资源文件导入：
ClassLoader loader = Thread.getCurrentThread.getClassLoader();
loader.load("db.properties");

======Java8 的Lambda表达式
Arrays.sort(us, new Comparetor<User>() {
 public int(User u1, User u2) {
 return Integer.compare(u1.score, u2.score);
 }
 });
 ==>
 Arrays.sort(us, (User u1, User u2) -> {
 return Integer.compare(u1.score, u2.score);
 });
==>
 Arrays.sort(us, (User u1, User u2) -> Integer.compare(u1.score, u2.score) );
==>
 Arrays.sort(us, (u1, u2) -> Integer.compare(u1.score, u2.score) );

=----------接口中的默认方法
public interface IXXX {
void run();
default void speak(){System.out.println("");}
}


==========================
XML  DOM
http://www.cnblogs.com/McCa/p/5938736.html
什么是XML？
　　XML是指可扩展标记语言(eXtensible Markup Language)，它是一种标记语言，很类似HTML。它被设计的宗旨是传输数据，而非显示数据。 XML标签没有被预定义，需要用户自行定义标签。 XML技术是W3C组织(World Wide Web Consortium万维网联盟)发布的，目前遵循的是W3C组织于2000年发布的XML1.0规范。 XML被广泛认为是继Java之后在Internet上最激动人心的新技术。
XML语法规则总结
　　所有 XML 元素都须有关闭标签
　　XML 标签对大小写敏感 XML
　　必须正确地嵌套顺序
　　XML 文档必须有根元素(只有一个)
　　XML 的属性值须加引号
　　特殊字符必须转义 --- CDATA
　　XML 中的空格、回车换行会解析时被保留
XML约束之DTD约束     DTD(Document Type Definition)，全称为文档类型定义
XML约束之Schema XML     Schema 也是一种用于定义和描述 XML 文档结构与内容的模式语言，其出现是为了克服 DTD 的局限性

XML解析方式分为两种：
　　DOM：Document Object Model，文档对象模型。这种方式是W3C推荐的处理XML的一种方式。
　　SAX：Simple API for XML。这种方式不是官方标准，属于开源社区XML-DEV，几乎所有的XML解析器都支持它。

　　XML解析开发包 :
　　JAXP：是SUN公司推出的解析标准实现。
　　Dom4J：是开源组织推出的解析开发包。(牛，大家都在用，包括SUN公司的一些技术的实现都在用) J
　　Dom：是开源组织推出的解析开发包。　

　　JAXP:
　　JAXP:(Java API for XML Processing)开发包是JavaSE的一部分，它由以下几个包及其子包组成：
　　　　org.w3c.dom:提供DOM方式解析XML的标准接口
　　　　org.xml.sax:提供SAX方式解析XML的标准接口
　　　　javax.xml:提供了解析XML文档的类
　　javax.xml.parsers包中，定义了几个工厂类。我们可以通过调用这些工厂类，得到对XML文档进行解析的DOM和SAX解析器对象。 　　　　　　　　　　　　  　　DocumentBuilderFactory
　　　  SAXParserFactory

