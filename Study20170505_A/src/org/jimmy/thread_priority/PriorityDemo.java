package org.jimmy.thread_priority;

class Priority extends Thread {
	public Priority (String name) {
		super(name);
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(super.getName() + ": " + i);
		}
	}
}

public class PriorityDemo {

	public static void main(String[] args) {
		Priority min1 = new Priority("min1");
		min1.setPriority(1);
		Priority min2 = new Priority("min2");
		min2.setPriority(2);
		Priority min3 = new Priority("min3");
		min3.setPriority(3);
		Priority min4 = new Priority("min4");
		min4.setPriority(4);
		Priority max = new Priority("----max");
		max.setPriority(10);
		min1.start();
		min2.start();
		min3.start();
		min4.start();
		max.start();
		
	}

}
