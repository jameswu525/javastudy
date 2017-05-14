package org.jimmy.threadCommunicate;

public class ThreadCommDemo {

	public static void main(String[] args) {
		SharedObj obj = new SharedObj();
		new Thread(new Productor(obj)).start();
		new Thread(new Consumer(obj)).start();
	}

}
