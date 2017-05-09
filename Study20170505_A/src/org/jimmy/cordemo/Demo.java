package org.jimmy.cordemo;

public class Demo {
	public static void Compare() {
		// 常量池   
		//编译常量池 : 字节码加载进JVM，存储的字节码信息
		// 运行常量池: 存储运行时的常量
		String str1 = "ABCD";   // 存在与 方法区（运行常量池）内。
		String str2 = new String("ABCD");  // String存储在堆内，String内引用方法区的运行常量池，堆内内存地址赋值给栈内的变量。

		System.out.println("===========");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str1 == str2);  // false
		
			
	}

	public static void main(String[] args) {
		String s1 = "ABCDEFG";
		StringBuffer sb1 = new StringBuffer(s1);
		StringBuilder sb2 = new StringBuilder();
		System.out.println(s1);
		System.out.println(s1.hashCode());
		s1 = "BCD";
		System.out.println(s1.hashCode());
		
		Demo.Compare();
		
		Demo.BuildString();
	}

	private static void BuildString() {
		char[] cs = new char[]{'A', 'B', 'C'};
		String str1 = new String(cs);
		
		System.out.println("ABCDEFG".charAt(4));
		System.out.println("ABCDEFG".indexOf('C'));
		System.out.println("ABCDEFGAACDEF".lastIndexOf("EF"));
		
		System.out.println("ABCDEFG".equals("AbcdEFG"));
		System.out.println("ABCDEFG".equalsIgnoreCase("AbcdEFG"));
	}

}
