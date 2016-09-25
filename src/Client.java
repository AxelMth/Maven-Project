import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		
		InetAddress addr = InetAddress.getByName("127.0.0.1");
	
		Socket socket = new Socket(addr,49155);
		
		ClientProcessor rp = new ClientProcessor(socket);
		
		rp.start();
		
	}

}
