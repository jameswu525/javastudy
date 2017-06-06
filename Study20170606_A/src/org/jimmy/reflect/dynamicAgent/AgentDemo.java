package org.jimmy.reflect.dynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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
	}

	/**
	 * jdk动态代理的对象必须实现接口
	 * 第一个参数不需要；
	 * 第二个参数method： 被代理对象的接口方法
	 * 第三个参数args：是被代理接口方法的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before *** ===");
//		for (Object o : args) {
//			System.out.println("Parameter: " + o);
//		}
		// 实际被代理的方法
		Object invoke = method.invoke(obj,  args);
		System.out.println("After *** ===");
		return invoke;
	}
	
	public static void main(String[] args) {
		// 创建被代理的接口对象
		SuperInterface agent = new AgentImpl();
		// 创建代理， 第一个参数是类加载器，第二个参数是所有接口，第三个是自定义的代理类对象
		SuperInterface proxy = (SuperInterface)Proxy.newProxyInstance(agent.getClass().getClassLoader(), agent.getClass().getInterfaces(), new AgentDemo(agent));
		
		proxy.doWork();
		
		
		List<String> list = new ArrayList<>();
		List<String> newList = (List<String>)Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new AgentDemo(list));
		list.add("123");
		newList.add("456");
		newList.size();
		
		System.out.println(list);
	}

}
