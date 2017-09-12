package org.jimmy.server;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import org.jimmy.util.CompileXML;
import org.jimmy.util.ServletElement;

public class Server extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> labels = new ArrayList<>();
	private TextField text = new TextField();
	public boolean accept = true;
	private static Scanner socketIn;
	public HashMap<String, ServletElement> servlets = null;

	public Server(String title) {
		super(title);
	}

	public static void main(String[] args) throws IOException {
		Server panel = new Server("http socket");
		panel.servlets = new CompileXML("web.xml").getServletsMap();
		panel.startup();
		int port = 10086;
		HttpSocket http = null;
		Socket client = null;
		int loop = 1;
		try {
			http = new HttpSocket(port);
//			http.getInetAddress();
			String status = "Service is listening on http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":" + http.getLocalPort();
			System.out.println(status);
			panel.appendLabel(status);
		} catch (IOException e) {
			panel.appendLabel(String.valueOf(port) + "<启动失败>");
			e.printStackTrace();
			System.exit(1);
		}
		panel.appendLabel(String.valueOf(port));

		while (panel.accept) {
			client = http.accept();
			if (panel.accept) {
				socketIn = new Scanner(client.getInputStream());
				String head = "";
				StringBuilder acceptContent = new StringBuilder();
				boolean isFavicon = false;
				boolean isFirst = true;
				String path = "";
				while (socketIn.hasNextLine() && !isFavicon) {
					head = socketIn.nextLine();
					if ("".equals(head)) {
						break;
					}
					acceptContent.append(head);
					acceptContent.append("<br/>");
					if (isFirst) {
						path = head.substring(head.indexOf("/"), head.indexOf(" HTTP/"));
						isFavicon = "/favicon.ico".equals(path);
						isFirst = false;
					}
				}
				// socketIn.close();
				if (!isFavicon) {
					System.out.println(
							new Date().toLocaleString() + path + " --> some one arrived : " + client.getInetAddress());
					String route = path.substring(path.indexOf("/"), path.length());
					System.out.println(route);
					ServletElement servletEle = panel.servlets.get(route);
					if (servletEle != null && servletEle.getServletClz() != null) {
						IServlet servlet = servletEle.getServletClz();
						servlet.setClient(client);
						new Thread(servlet).start();
					} else {
						new Thread(new ServletAgent(client, acceptContent), "Thread " + String.valueOf(loop++)).start();
					}
				}
			} else {
				new Thread(new ServletNullAgent(client)).start();
			}
		}
		http.close();
		System.out.println("Service Stoped");
	}

	public String appendLabel(String str) {
		labels.add(str);
		return getLablesAsString();
	}

	public String removeLabel(String str) {
		for (String item : labels) {
			if (str.equals(item)) {
				labels.remove(item);
				return getLablesAsString();
			}
		}
		return getLablesAsString();
	}

	private String getLablesAsString() {
		StringBuilder sb = new StringBuilder();
		for (String item : labels) {
			sb.append(item + "\n");
		}
		text.setText(sb.toString());
		return sb.toString();
	}

	private void startup() {
		this.setLayout(new GridLayout(2, 1));
		this.setSize(400, 400);
		this.setLocation(450, 200);
		this.setResizable(false);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Button btn1 = new Button("Stop");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setEnabled(false);
				accept = false;
				text.setText("Service Stoped");
			}
		});

		this.add(btn1);
		this.add(text);

		this.setVisible(true);
	}

}
