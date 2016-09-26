package TP2_Excercice_2;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException, InterruptedException {

	ServerSocket server = new ServerSocket(49155); //Definition of the port
	
	Socket socket = server.accept(); 			   // listening for a connexion from the client and connect it
	
	ServerProcessor rp = new ServerProcessor(socket); // thread that respond to the client message
	
	rp.start();
	
	rp.join();
	
	server.close();

	}
	
}	
