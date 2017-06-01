package org.jimmy.reflect;

public class UseFactory {
	public static void main(String[] args) {
		String ret = BeanFactory.INSTANCE.asString(1);
		System.out.println(ret);
	}
}
