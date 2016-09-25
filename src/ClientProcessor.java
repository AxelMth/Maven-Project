import java.io.*;
import java.net.Socket;

class ClientProcessor extends Thread {
	
	private Socket socket;
	
	public ClientProcessor(Socket socket){
		
		this.socket = socket;
		
	}
	
	public void run()
	{
		
		try { 
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream()) ;
			
			pw.println("World");
			
			pw.flush();
			
			InputStreamReader ir = new InputStreamReader(socket.getInputStream()) ;
			BufferedReader rd = new BufferedReader(ir);
			
		    String message_distant = rd.readLine();
		    System.out.println(message_distant);
		    
		    socket.close();
		    
		}
		
		catch (Exception e) {}
	}

}