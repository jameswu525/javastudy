package org.jimmy.thread;

public class Apple3 implements Runnable {
	private int num = 50;

	public void run() { // 同步方法 如果直接用synchronized修饰run，第一个线程可能就执行完整个方法。
		for (int i = 1; i <= 50; i++) {
			doWork();
		}
	}
	
	private synchronized void doWork() {
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
