package TP2_Excercice_2;
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
			
			pw.println("World"); // Send the message world to the Server
			
			pw.flush();
			
			InputStreamReader ir = new InputStreamReader(socket.getInputStream()) ;
			BufferedReader rd = new BufferedReader(ir);
			
		    String message = rd.readLine(); // Receive the response from the server
		    
		    System.out.println(message); // Write the response in the console
		    
		    socket.close();
		    
		}
		
		catch (Exception e) {}
	}

}