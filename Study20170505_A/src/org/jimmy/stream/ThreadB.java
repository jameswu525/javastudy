package org.jimmy.stream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class ThreadB implements Runnable {
	private PipedOutputStream pos = null;

	public ThreadB(PipedOutputStream pos) {
		this.pos = pos;
	}

	@Override
	public void run() {
		try {
			for(int i = 65; i < 100; i++) {
				pos.write(i);
				System.out.println("'======写出通道写： '" + i);
				Thread.sleep(500);
				if (i == 80) {
					Thread.sleep(20000);
				}
			}
			pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
