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
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Server extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> labels = new ArrayList<>();
	private TextField text = new TextField();
	public boolean accept = true;
	private static Scanner socketIn;

	public Server(String title) {
		super(title);
	}

	public static void main(String[] args) throws IOException {
		Server panel = new Server("http socket");
		panel.startup();
		int port = 10086;
		HttpSocket http = null;
		Socket client = null;
		int loop = 1;
		try {
			http = new HttpSocket(port);
			String status = "Service is listening on http://" + http.getInetAddress().getLocalHost().getHostAddress()
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
				boolean isEnd = false;
				while (!isEnd && socketIn.hasNextLine()) {
					head = socketIn.nextLine();
					acceptContent.append(head);
					acceptContent.append("<br/>");
					if (isFirst) {
						isFavicon = "/favicon.ico".equals(head.substring(head.indexOf("/"), head.indexOf(" HTTP/")));
						isFirst = false;
					}
					if ("".equals(head)) {
						isEnd = true;
					}
				}
				// socketIn.close();
				if (!isFavicon) {
					System.out.println(
							new Date().toLocaleString() + " --> some one arrived : " + client.getInetAddress());
					new Thread(new ServletAgent(client, acceptContent), "Thread " + String.valueOf(loop++)).start();
				}
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
