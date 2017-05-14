package org.jimmy.threadCommunicateLock;

public class Productor implements Runnable {
	private SharedObj obj = null;

	public Productor(SharedObj obj) {
		this.obj = obj;
	}
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (i % 2 == 0) {
				obj.push("x x x x x x x x x x x x x x x x x " + i, "男");
			} else {
				obj.push("y" + i, "女");
			}
		}
	}

}
