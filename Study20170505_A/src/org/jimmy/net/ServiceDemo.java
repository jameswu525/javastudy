package org.jimmy.net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceDemo {
	private static final int PORT = 8888;

	public static void main(String[] args) throws IOException {
		String data = "hahahha\n 2, welcom !!! \n 3, dddddddd, bye.";
		// create server
		ServerSocket ss = new ServerSocket(PORT);
		System.out.println("Server start . ");
		boolean accept = true;
		while (accept) {
			Socket client = ss.accept();
			System.out.println("some one arrived : " + client.getInetAddress());
			PrintStream out = new PrintStream(client.getOutputStream());
			out.println(data);

			out.close();
		}
		ss.close();
	}

}
