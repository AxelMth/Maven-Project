import java.io.*;
import java.net.Socket;

class ServerProcessor extends Thread {
	
	private Socket socket;
	
	public ServerProcessor(Socket socket)
	{
		
		this.socket = socket;
		
	}
	
	public void run()
	{
		
		try { 
			
			InputStreamReader ir = new InputStreamReader(socket.getInputStream()) ;
			BufferedReader rd = new BufferedReader(ir);
			
		    String message = rd.readLine(); //read the message from the client
		   
			PrintWriter pw = new PrintWriter(socket.getOutputStream()) ;
			
			pw.println("Hello " + message + " !"); //Send the response 
			
			pw.flush();
			
			socket.close();
			
		}
		
		catch (Exception e) {}

	}

}