package org.jimmy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructorDemo {
	public static void main(String[] args) {
		try {
			Class<?> clz = Class.forName("org.jimmy.reflect.TUser");

			Constructor[] cs1 = clz.getConstructors();
			for(Constructor c : cs1) {
				System.out.println(c);
			}
			
			Constructor[] cs2 = clz.getDeclaredConstructors();
			for(Constructor c : cs2) {
				System.out.println(c);
			}
			
			Constructor c1 = clz.getConstructor();
			System.out.println(c1);

			Constructor c2 = clz.getConstructor(String.class);
			System.out.println(c2);
			
			Constructor c3 = clz.getDeclaredConstructor(String.class, int.class);
			System.out.println(c3);
			c3.setAccessible(true);
			Object obj = c3.newInstance("XYZ", 1);
			System.out.println(obj);
			
			System.out.println("===================================");
			Method m = clz.getMethod("strGetName");
			System.out.println(m.invoke(obj));
			
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
}


class TUser {
	public String name;
	public int age;
	
	public TUser() {
		
	}
	
	public TUser(String str) {
		this.name = str;
	}
	
	private TUser(String str, int age) {
		this.name = str;
		this.age = age;
	}
	
	public String strGetName() {
		return this.name;
	}
	
	public String toString() {
		return this.name + "/" + this.age;
	}
}