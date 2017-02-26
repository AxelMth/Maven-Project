import java.io.IOException;
import java.io.PrintWriter;

public class ThreadPrinter { // Just a printWriter in an object

	private PrintWriter pw ;
	
	public ThreadPrinter(String name) throws IOException {
	
		this.pw  = new PrintWriter(name);

	}
	
	public void write (String thingsToWrite){
		
		pw.println(thingsToWrite);
		
	}
	
	public void close (){
		
		pw.close();
		
	}
}
