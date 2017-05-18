package org.jimmy.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class SimpleTomcatDemo {

	public static void main(String[] args) throws Exception, IOException {
		String header = "<!DOCTYPE html><html xmlns=\" http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />";
		Properties p = new Properties();
		p.load(new FileInputStream(new File("resource/db.properties")));
		Integer port = Integer.parseInt(p.getProperty("tomcat_port", "9999"));
		ServerSocket server = new ServerSocket(port.intValue());
		boolean accept = true;
		System.out.println("server running on " + server.getInetAddress() + " : " + server.getLocalPort());
		while (accept) {
			Socket client = server.accept();
			System.out.println(new Date().toLocaleString() + " accept : " + client.getInetAddress());
			PrintStream ps = new PrintStream(client.getOutputStream());
			Scanner sc = new Scanner(new FileInputStream(new File("resource/index.html")));
//			ps.println(header);
			int loop = 0;
			while(sc.hasNextLine()) {
				loop ++;
				ps.print(sc.nextLine());
			}
			System.out.println("reed" + loop + "次");
			sc.close();
		}
		server.close();
	}

}
