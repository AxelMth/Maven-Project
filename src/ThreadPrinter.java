import java.io.IOException;
import java.io.PrintWriter;

public class ThreadPrinter {

	private PrintWriter pw ;
	
	public ThreadPrinter(String name) throws IOException {
	
		this.pw  = new PrintWriter(name);

	}
	
	public synchronized void write (String thingsToWrite){
		
		pw.write(thingsToWrite);
		
	}
	
}
