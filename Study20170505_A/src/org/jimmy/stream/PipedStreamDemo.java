package org.jimmy.stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
	public static void main(String[] args) throws IOException {

		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream(in);
		new Thread(new ThreadA(in)).start();
		new Thread(new ThreadB(out)).start();
		System.out.println("|||||||||||||||||||||||||||||||||||");
	}
}
