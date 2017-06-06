package org.jimmy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectDemo {
	private final String cls = "org.jimmy.reflect.ReflectDemo";
	private String name = null;
	private int age = 0;
	
	public ReflectDemo() {
		
	}
	
	public ReflectDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) throws Exception {
		ReflectDemo demo = new ReflectDemo("Jimmy Wu", 18);
		System.out.println("==>" + demo);
		Object cpDemo = demo.reflect4(demo);
		System.out.println("-->" + cpDemo);
		
//		demo.reflect3("org.jimmy.reflect.ReflectDemo");
		
//		demo.reflect2("org.jimmy.reflect.ReflectDemo");
		
//		demo.reflect1("java.util.List");
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//		demo.reflect1(demo);
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//		demo.reflect1(ReflectDemo.class);
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	// Copy object
	private Object reflect4(Object obj) throws Exception {
		Class<?> clazz = Class.forName(obj.getClass().getName());
		Field[] fs = clazz.getDeclaredFields();
		Constructor<?> c = clazz.getConstructor(new Class[]{});
		Object instance = c.newInstance(new Object[]{});
		for (Field f : fs) {
			String fName = f.getName();
			Class<?> fType = f.getType();
			if (Modifier.isFinal(f.getModifiers())) {
				System.out.println(fName + "/" + f.getModifiers());
				continue;
			}
			
			// 获取属性的Set方法
			String fSetMethod = "set" + fName.substring(0, 1).toUpperCase() + fName.substring(1);
			String gSetMethod = "get" + fName.substring(0, 1).toUpperCase() + fName.substring(1);
			Method setMethod = clazz.getDeclaredMethod(fSetMethod, new Class[]{fType});
			Method getMethod = clazz.getDeclaredMethod(gSetMethod, new Class[]{});
			setMethod.invoke(instance,  getMethod.invoke(obj, new Object[]{}));
			
		}
		return instance;
	}
	
	private void reflect3(String cls) throws Exception {
		Class<?> clazz = Class.forName(cls);
		// 无参构造器
		Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{});
		Object instance = constructor.newInstance(new Object[]{});
		System.out.println(instance);

		// 两个参数的构造器
		constructor = clazz.getDeclaredConstructor(new Class[]{String.class, int.class});
		instance = constructor.newInstance(new Object[]{"Jimmy", 18});
		System.out.println(instance);
//
//		constructor = clazz.getDeclaredConstructor(new Class[]{String.class, int.class});
//		instance = constructor.newInstance(new Object[]{"Jazz", 18});
//		System.out.println(instance);
//		
		// 获取所有方法
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			String methodName = m.getName();
			// 找寻set方法
			boolean startWith = methodName.startsWith("set");
			if (startWith) {
				String filedName = methodName.substring(3);
				filedName = filedName.substring(0, 1).toLowerCase() + filedName.substring(1);
				Field field = clazz.getDeclaredField(filedName);
				Class<?> type = field.getType();
				System.out.println(methodName + ":" + filedName + " / " + type.getName());
				if (type == String.class && "name".equals(filedName)) {
					// 执行方法，第二个参数是参数列表 new Object[]{}
					m.invoke(instance, new Object[]{"Jimmy Wu"});
				}

				if (type == int.class && "age".equals(filedName)) {
					m.invoke(instance, new Object[]{28});
				}
				
				System.out.println("-----------------");
			} else if (methodName.startsWith("get")) {
				// invoke 方法返回
			 	System.out.println(methodName + " / " + m.invoke(instance, new Object[]{}));
			 	
			 	// !!!!!!静态方法调用时， invoke的第一个参数设置为 null
			 
			}
		}
		System.out.println(instance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private void reflect2(String cls) throws Exception {
		Class<?> clazz = Class.forName(cls);
		Field field = clazz.getDeclaredField("cls");
		System.out.println(field);
		
		Method method = clazz.getDeclaredMethod("reflect1", new Class[]{Object.class});
		System.out.println(method);
		
		method = clazz.getDeclaredMethod("main", new Class[]{String[].class});
		System.out.println(method);

		method = clazz.getDeclaredMethod("main", String[].class);   // clazz.getDeclaredMethod("main", new Class[] { [Ljava.lang.String.class });   自动装箱
		System.out.println(method);

		method = clazz.getDeclaredMethod("testMethod1", new Class[]{String[].class});
		System.out.println(method);

		method = clazz.getDeclaredMethod("testMethod1", String[].class);  // clazz.getDeclaredMethod("testMethod1", new Class[] { [Ljava.lang.String.class });   自动装箱
		System.out.println(method);
		
		method = clazz.getDeclaredMethod("testMethod2", new Class[]{String.class, String.class});
		System.out.println(method);

		method = clazz.getDeclaredMethod("testMethod3", new Class[]{});  // clazz.getDeclaredMethod("testMethod3", new Class[0]);
		System.out.println(method);
		
		Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{});
		System.out.println(constructor);
	}
	
	private void testMethod1(String ... strings ) {}
	
	private void testMethod2(String str1, String str2 ) {}

	private void testMethod3() {}
	
	private void reflect1(Object obj) throws Exception {
		this.reflect1(obj.getClass());
	}
	
	private void reflect1(Class<?> cls) throws Exception {
		this.reflect1(cls.getName());
	}
	
	private void reflect1(String cls) throws Exception {

		Class<?> clazz = Class.forName(cls);
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
		System.out.println("======================================");
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f);
		}
		System.out.println("======================================");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> c : constructors) {
			System.out.println(c);
		}

	}
	
	public String toString() {
		return "我的自定义Class" + ":" + this.getClass().getName() + "@" + this.hashCode() + 
				"\n" + "Name=" + this.name + "  // Age=" + this.age;
		
	}

}
