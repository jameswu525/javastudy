package org.jimmy.server;

import java.io.IOException;
import java.net.ServerSocket;

public class HttpSocket extends ServerSocket {
	
	public boolean status = false;

	public HttpSocket(int port) throws IOException {
		super(port);
	}

}
