package org.jimmy.cordemo;

public class NativeDemo {
	public native void hello();
	
	public static void main(String[] args) {
		new NativeDemo().hello();
	}
}
