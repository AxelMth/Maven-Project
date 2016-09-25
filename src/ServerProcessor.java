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
			
		    String message = rd.readLine();
		   
			PrintWriter pw = new PrintWriter(socket.getOutputStream()) ;
			
			pw.println("Hello " + message + " !");
			
			pw.flush();
			
			socket.close();
			
		}
		
		catch (Exception e) {}

	}

}