package org.jimmy.threadCommunicateLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObj {
	private String name = "";
	private String general = "";
	private boolean isEmpty = true;
	private ReentrantLock lock = new ReentrantLock();
	private Condition con = lock.newCondition();

	public void push(String name, String general) {
		lock.lock();
		try {
			while (!isEmpty) {
				con.await();
			}
			this.name = name;
			this.general = general;
			Thread.sleep(10);
			con.signalAll();
			isEmpty = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void pop() {
		lock.lock();
		try {
			while (isEmpty) {
				con.await();
			}
			Thread.sleep(10);
			System.out.println(this.name + "-" + this.general);
			isEmpty = true;
			con.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
