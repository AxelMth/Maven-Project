import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		
		InetAddress addr = InetAddress.getByName("127.0.0.1"); // Define the host name which is localhost
		
		Socket socket = new Socket(addr,49155);	// Connexion to the server			   
		
		ClientProcessor cp = new ClientProcessor(socket); // Definition of the process which send the message 
		
		cp.start(); // Starting the communication with the server
	
	}

}
