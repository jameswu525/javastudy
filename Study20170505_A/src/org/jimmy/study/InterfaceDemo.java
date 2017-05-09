package org.jimmy.study;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这是测试的第一个例子，创建一只两牺动物。
 * @author JimmyWu
 *
 */
public class InterfaceDemo implements IWalker, ISwim {

	private static Scanner sc;

	public void walk() {
		System.out.println("I can walk on road");
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		System.out.print("tell me:");
		// 控制台读取输入
//		Console con = System.console();
//		String line = con.readLine();
//		System.out.println(line);
		System.out.print("Input your string:"); 
		sc = new Scanner(System.in);
		String line2 = sc.nextLine();
		System.out.println(line2);
		
		InterfaceDemo demo = new InterfaceDemo();
		demo.walk();
		demo.swim();
	}

	public void swim() {
		System.out.println("I can swim in the river");
	}

}
