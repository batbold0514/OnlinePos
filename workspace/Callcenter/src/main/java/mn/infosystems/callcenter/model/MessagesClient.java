package mn.infosystems.callcenter.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessagesClient {
	private ObjectOutputStream output;		// to write on the socket
	private Socket socket;
	private String server;
	private int port;
	
	public MessagesClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	public boolean start() {
		// try to connect to the server
		System.out.println("****************************************");
		try {
			socket = new Socket(server, port);
			output = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO) {
			return false;
		}

		// creates the Thread to listen from the server 
//		new ListenFromServer().start();
		// Send our username to the server this is the only message that we
		// will send as a String. All other messages will be ChatMessage objects
		// success we inform the caller that it worked
		return true;
	}
	public void stop(){
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
	public void sendMessage(String msg) {
		try {
			output.writeObject(msg);
		}
		catch(IOException e) {
		}
	}
}
