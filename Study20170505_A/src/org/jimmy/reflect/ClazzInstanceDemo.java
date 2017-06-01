package org.jimmy.reflect;

import java.lang.reflect.Constructor;
import java.util.Date;

public class ClazzInstanceDemo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException {
		System.out.println(int.class);	// int
		System.out.println(boolean.class);	// boolean
		System.out.println(void.class);	// void
		System.out.println(Integer.TYPE);	// int  包装类对应的基本数据类型的class实例
		System.out.println(Integer.class);   //class java.lang.Integer
		System.out.println(int[][].class);   //class [[I
		System.out.println(boolean[][].class);   //class [[Z
		System.out.println(Integer[].class);   //class [Ljava.lang.Integer;
		System.out.println(Integer[][].class);   //class [[Ljava.lang.Integer;
		System.out.println(String[][].class);   //class [[Ljava.lang.String;
		System.out.println(int[][].class);   //class java.lang.Integer
		
		System.out.println(int.class == Integer.class);   // false
		
		System.out.println("==========================");
		// 1
		Class<Date> clz1 = Date.class;
		// 2
		Date date = new Date();
		Class<?> clz2 = date.getClass();
		// 3 推荐使用的！！！
		Class<?> clz3 = Class.forName("java.util.Date");

		System.out.println(clz1);
		System.out.println(clz2);
		System.out.println(clz3);
		System.out.println(clz1.hashCode());
		System.out.println(clz3.hashCode());
		System.out.println(clz3.hashCode());
		try {
			System.out.println(clz2.newInstance());
			System.out.println(clz2.newInstance().getClass());
			System.out.println("=======================");

			PrivateClass o1 = PrivateClass.getInstance();
			System.out.println(o1.getClass().hashCode());

			Class<?> clz4 = Class.forName("org.jimmy.reflect.PrivateClass");
			System.out.println(clz4.hashCode());
//			System.out.println(clz4.getDeclaredFields().length);
//			for (Field f : clz4.getDeclaredFields()) {
//				f.setAccessible(true);
//				System.out.println();
//			}

			for (Constructor<?> c : clz4.getDeclaredConstructors()) {
				c.setAccessible(true); // AccessibleObject
				PrivateClass pvC = (PrivateClass) c.newInstance();
				System.out.println(pvC.getClass().hashCode());    // 通过 throw new CannotNewSingleInstanceException("不能多次生成单例实例。");  禁止反射
			}

			//System.out.println(clz4.newInstance()); // java.lang.IllegalAccessException:
													// Class
													// org.jimmy.reflect.ClazzInstanceDemo
													// can not access a member
													// of class
													// org.jimmy.reflect.PrivateClass
													// with modifiers "private"
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
