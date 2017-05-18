package org.jimmy.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 8888);
		Scanner sc = new Scanner(s.getInputStream());
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
		s.close();
	}

}
