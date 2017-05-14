package org.jimmy.thread;

public class Apple1 implements Runnable {
	private int num = 50;
	public void run() { // 无同步机制
		for (int i = 1; i <= 50; i++) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + " Eat apple " + num--);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
