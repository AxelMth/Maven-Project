import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	public static void main(String[] args) throws IOException, InterruptedException {

	ServerSocket server = new ServerSocket(49155);
	
	Socket socket = server.accept(); 
	
	ServerProcessor rp = new ServerProcessor(socket);
	
	rp.start();
	
	rp.join();
	
	server.close();

	}
	
}	
