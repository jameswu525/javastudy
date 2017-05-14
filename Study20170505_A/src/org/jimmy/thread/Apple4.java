package org.jimmy.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Apple4 implements Runnable {
	private int num = 50;
	private final Lock lock = new ReentrantLock(); // 创建锁对象

	public void run() { // 同步方法 如果直接用synchronized修饰run，第一个线程可能就执行完整个方法。
		for (int i = 1; i <= 50; i++) {
			doWork();
		}
	}

	private void doWork() {
		// 加锁
		lock.lock();
		try {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + " Eat apple " + num--);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 释放锁
			lock.unlock();
		}
	}

}
