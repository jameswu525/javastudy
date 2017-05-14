package org.jimmy.threadCommunicate;

public class SharedObj {
	private String name = "";
	private String general = "";
	private boolean isEmpty = true;

	public synchronized void push(String name, String general) {
		try {
			if (!isEmpty) {
				this.wait();
			}
			this.name = name;
			this.general = general;
			Thread.sleep(10);
			this.isEmpty = false;
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void pop() {
		try {
			if (isEmpty) {
				this.wait();
			}
			Thread.sleep(10);
			System.out.println(this.name + "-" + this.general);
			this.isEmpty = true;
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
