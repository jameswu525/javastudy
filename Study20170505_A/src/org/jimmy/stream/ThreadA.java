package org.jimmy.stream;

import java.io.IOException;
import java.io.PipedInputStream;

public class ThreadA implements Runnable {
	private PipedInputStream pis = null;

	public ThreadA(PipedInputStream pis) {
		this.pis = pis;
	}

	@Override
	public void run() {
		int len = -1;
		try {
			while ((len = pis.read()) != -1) {
				System.out.println("->" + (char)len);
				Thread.sleep(1000);
			}
			pis.close();
			System.out.println("====没有更多了");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
