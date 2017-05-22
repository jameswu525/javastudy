package org.jimmy.server;

import java.net.Socket;

public interface IServlet extends Runnable{
	void service();
	void setClient(Socket client);
}
