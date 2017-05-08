package org.jimmy.study;

/**
 * 这是测试的第一个例子。
 * @author JimmyWu
 *
 */
public class InterfaceDemo implements IWalker, ISwim {

	public void walk() {
		System.out.println("I can walk on road");
	}

	public static void main(String[] args) {
		InterfaceDemo demo = new InterfaceDemo();
		demo.walk();
		demo.swim();
	}

	public void swim() {
		System.out.println("I can swim in the river");
	}

}
