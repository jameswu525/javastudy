反射， 动态代理， annotation注解
----
 @@静态代理：
每个类需要对不同的方法进行单独开发，进行代理。

 @@JDK中提供动态代理的方法：
 Agent 类 必须实现 implements InvocationHandler |  被代理对象必须实现接口。
 
 	// 真实代理的角色
	Object obj;

	public AgentDemo(Object obj) {
		super();
		this.obj = obj; 
    ｝
	/**
	 * jdk动态代理的对象必须实现接口
	 * 第一个参数不需要；
	 * 第二个参数method： 被代理对象的接口方法
	 * 第三个参数args：是被代理接口方法的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before *** ===");
		if (args != null) {
			for (Object o : args) {
				System.out.println("Parameter: " + o);
			}
		}
		// 实际被代理的方法
		Object invoke = method.invoke(obj,  args);
		System.out.println("After *** ===");
		return invoke;
	}
	
// 生成代理对象的方法：	jdk底层利用动态组装使用Agent的invoke方法，针对每个接口方法，编译class com.sun.proxy.$Proxy0
interface proxy = (interface)Proxy.newProxyInstance(entity.getClass().getClassLoader(), entity.getClass().getInterfaces(), new Agent(entity));
// interface 及需要代理对象的接口。


设想验证方式，经过Proxy生成的对象，通过反射出该对象的相关信息，例如classname,成员变量是否有InovacationHandler /有，存在父类proxy中，代理中打印本体对象的hashcode验证是否是原obj /yes！

==验证结论==
proxy.getClass().getSuperclass();=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
java.lang.reflect.Proxy
serialVersionUID--long---2222568056686623797
constructorParams--[Ljava.lang.Class;--[Ljava.lang.Class;@28d93b30
proxyClassCache--java.lang.reflect.WeakCache--java.lang.reflect.WeakCache@1b6d3586
h--java.lang.reflect.InvocationHandler--org.jimmy.reflect.dynamicAgent.AgentDemo@6d06d69c
======>org.jimmy.reflect.dynamicAgent.AgentImpl@15db9742
key0--java.lang.Object--java.lang.Object@4554617c
access$200--java.lang.Object
access$300--java.lang.Class
isProxyClass--boolean
defineClass0--java.lang.Class
checkNewProxyPermission--void
checkProxyAccess--void
getInvocationHandler--java.lang.reflect.InvocationHandler
getProxyClass--java.lang.Class
getProxyClass0--java.lang.Class
newProxyInstance--java.lang.Object
proxy.getClass();=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
com.sun.proxy.$Proxy0
m1--java.lang.reflect.Method
m2--java.lang.reflect.Method
m3--java.lang.reflect.Method
m0--java.lang.reflect.Method
equals--boolean
toString--java.lang.String
hashCode--int
doWork--void
agent.getClass();=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
org.jimmy.reflect.dynamicAgent.AgentImpl
doWork--void
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


----

 @@annotation注解
 自动实现 Annotation接口
 public @interface AnnoTest
 其中可以定义值， 非标识类的注解都有值。（即 标识类的注解没有值）
 @ 只有在反射时才有作用。
 定义方法： 数据类型 值的名称();
 
 
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)   // 表示该注解能标注在哪些地方
public @interface Retention {   // 仅仅针对注解的注解，用以注解策略。
    RetentionPolicy value();
}

 RetentionPolicy   -- 该注解生存周期
CLASS 
          编译器将把注释记录在类文件中，但在运行时 VM 不需要保留注释。 
RUNTIME  -- 最重要！！！
          编译器将把注释记录在类文件中，在运行时 VM 将保留注释，因此可以反射性地读取。 
SOURCE 
          编译器要丢弃的注释。 
 
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target
    ElementType[] value();
}

 ElementType    -- 该注解能在何处注解
 ANNOTATION_TYPE 
          注释类型声明 
CONSTRUCTOR 
          构造方法声明 
FIELD 
          字段声明（包括枚举常量） 
LOCAL_VARIABLE 
          局部变量声明 
METHOD 
          方法声明 
PACKAGE 
          包声明 
PARAMETER 
          参数声明 
TYPE 
          类、接口（包括注释类型）或枚举声明 
 
 
 ----
 