package org.jimmy.thread;

public class StartMultiThreadDemo {

	public static void main(String[] args) {
//		Runtime rt = Runtime.getRuntime();
//		rt.exec("Notepad");
//		
//		ProcessBuilder pb = new ProcessBuilder("Notepad");
//		pb.start();
//		Apple1 apple = new Apple1();
		Apple3 apple = new Apple3();
		new Thread(apple, "小A").start();
		new Thread(apple, "小B").start();
		new Thread(apple, "小C").start();
		
		
	}

}
