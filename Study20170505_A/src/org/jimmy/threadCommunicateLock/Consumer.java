package org.jimmy.threadCommunicateLock;

public class Consumer implements Runnable {
	private SharedObj obj = null;

	public Consumer(SharedObj obj) {
		this.obj = obj;
	}
	public void run() {
		for (int i = 0; i < 50; i++) {
			obj.pop();
		}
	}

}
