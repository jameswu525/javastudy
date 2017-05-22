package org.jimmy.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class LoginServlet implements IServlet {
	private Socket client = null;

	public void service() {
		System.out.println(this.getClass().getName());
	}

	@Override
	public void run() {

		try (PrintStream out = new PrintStream(client.getOutputStream());
				Scanner sc = new Scanner(new FileInputStream(new File("login.html")));) {
			out.println("HTTP/1.1 200 OK");
			out.println("Date:" + new Date().toString());
			out.println("Content-Type: text/html; charset=UTF-8");
			out.println();
			while (sc.hasNextLine()) {
				out.print(sc.nextLine());
			}
			out.print("</body> </html>");
			out.println();
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Finished... ...");
	}

	@Override
	public void setClient(Socket client) {
		this.client = client;
	}

}
