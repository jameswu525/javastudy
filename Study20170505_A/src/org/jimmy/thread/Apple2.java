package org.jimmy.thread;

public class Apple2 implements Runnable {
	private int num = 50;

	public void run() { // 同步代码块，synchronized(同一个资源对象)
		for (int i = 1; i <= 50; i++) {
			synchronized (this) { // synchronized不能修饰到for之前，否则代码全被一个线程执行完。
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

}
