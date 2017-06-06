package org.jimmy.reflect.dynamicAgent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态代理， 必须实现 InvocationHandler
 * @author JimmyWu
 *
 */
public class AgentDemo implements InvocationHandler {
	// 真实代理的角色
	Object obj;

	public AgentDemo(Object obj) {
		super();
		this.obj = obj; 

		System.out.println("constructor : " + this.obj);
	}

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
		System.out.println("invoke : " + obj);
		System.out.println("After *** ===");
		return invoke;
	}
	
	public static void main(String[] args) throws Exception {
		// 创建被代理的接口对象
		SuperInterface agent = new AgentImpl();
		AgentDemo demo = new AgentDemo(agent);
		System.out.println("main agent : " + agent);
		System.out.println("main demo: " + demo);
		// 创建代理， 第一个参数是类加载器，第二个参数是所有接口，第三个是自定义的代理类对象
		SuperInterface proxy = (SuperInterface)Proxy.newProxyInstance(agent.getClass().getClassLoader(), agent.getClass().getInterfaces(), demo);
		
		proxy.doWork();
		
		System.out.println("proxy.getClass().getSuperclass();=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		Class<?> clazz = proxy.getClass().getSuperclass();
		String clsName = clazz.getName();
		System.out.println(clsName);
		Field[] fs = clazz.getDeclaredFields();
		for (Field f : fs) {
			if (!Modifier.isPublic(f.getModifiers())) {
				f.setAccessible(true);
			}
			System.out.println(f.getName() + "--" + f.getType().getName() + "--" + f.get(proxy));
			if ("h".equals(f.getName())) {
				InvocationHandler h = (InvocationHandler)f.get(proxy);
				Class<?> c = h.getClass();
				Field f_agent = c.getDeclaredField("obj");
				f_agent.setAccessible(true);
				System.out.println("======>" + f_agent.get(h));
			}
		}
		
		Method[] ms = clazz.getDeclaredMethods();
		for (Method f : ms) {
			System.out.println(f.getName() + "--" + f.getReturnType().getName());
		}

		System.out.println("proxy.getClass();=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		clazz = proxy.getClass();
		clsName = clazz.getName();
		System.out.println(clsName);
		fs = clazz.getDeclaredFields();
		for (Field f : fs) {
			System.out.println(f.getName() + "--" + f.getType().getName());
		}
		ms = clazz.getDeclaredMethods();
		for (Method f : ms) {
			System.out.println(f.getName() + "--" + f.getReturnType().getName());
		}

		System.out.println("agent.getClass();=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		clazz = agent.getClass();
		clsName = clazz.getName();
		System.out.println(clsName);
		fs = clazz.getDeclaredFields();
		for (Field f : fs) {
			System.out.println(f.getName() + "--" + f.getType().getName());
		}
		ms = clazz.getDeclaredMethods();
		for (Method f : ms) {
			System.out.println(f.getName() + "--" + f.getReturnType().getName());
		}
			
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		List<String> list = new ArrayList<>();
		for (Class<?> cls : list.getClass().getInterfaces()) {
			System.out.println(cls.getName());
		}
		List<String> newList = (List)Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new AgentDemo(list));
		list.add("123");
		newList.add("456");
		newList.size();
		
		System.out.println(list);
	}

}
