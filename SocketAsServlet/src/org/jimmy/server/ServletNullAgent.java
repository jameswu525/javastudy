package org.jimmy.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class ServletNullAgent implements Runnable {

	Socket client = null;

	public ServletNullAgent(Socket client) {
		this.client = client;
	}

	public void run() {

		try (PrintStream out = new PrintStream(client.getOutputStream());) {
			out.println("HTTP/1.1 200 OK");
			out.println("Date:" + new Date().toString());
			out.println("Content-Type: text/html; charset=UTF-8");
			out.println();
			out.print("<html><head><title>No service.</title></head> <body>");
			out.println(Thread.currentThread().getName() + "<h5>服务器已停止服务。</h5>");
			out.println();
			out.print("</body> </html>");
			out.println();
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Finished... ...");
	}

}
