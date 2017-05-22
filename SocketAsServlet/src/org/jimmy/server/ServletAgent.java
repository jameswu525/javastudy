package org.jimmy.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ServletAgent implements Runnable {

	Socket client = null;
	StringBuilder strContent = null;

	public ServletAgent(Socket client, StringBuilder strContent) {
		this.client = client;
		this.strContent = strContent;
	}

	public void run() {

		try (PrintStream out = new PrintStream(client.getOutputStream());
				Scanner sc = new Scanner(new FileInputStream(new File("index.html")));) {
			out.println("HTTP/1.1 200 OK");
			out.println("Date:" + new Date().toString());
			out.println("Content-Type: text/html; charset=UTF-8");
			out.println();
			while (sc.hasNextLine()) {
				out.print(sc.nextLine());
			}
			out.println(Thread.currentThread().getName() + "<h3>收到如下请求内容：</h3>");
			out.println(strContent.toString());
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
