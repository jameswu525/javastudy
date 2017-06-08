package org.jimmy.test;

public class TestOverride {

	public static void main(String[] args) {
		SuperClass s = new SuperClass();
		s.printSomething("xyz");
		
		SuperClass sun = new SunClass();
		sun.printSomething("abc");
		/*
		 * protected ==> 子类会覆盖父类的方法，实现多态。
		 * SuperClass  xyz
			SunClass  abc

		 */
		
		/*
		 * private ==> 子类！！！不会！！！覆盖父类的方法
		 * SuperClass  xyz
			SuperClass  abc

		 */
	}

}


class SuperClass {
	public void printSomething(String something) {
		print(something);
	}
	
	protected void print(String something) {
		System.out.println("SuperClass  " + something);
	}
}

class SunClass extends SuperClass {
	protected void print(String something) {
		System.out.println("SunClass  " + something);
	}
}