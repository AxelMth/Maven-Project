
public class Main {

	public static void main(String[] args) throws Exception {
		
		long begin = System.currentTimeMillis();// Starting time
		long timeToStop = 1000;					// Stopping time
		
		ThreadPrinter tpw = new ThreadPrinter("philosophe.txt");
		
		boolean output = true; // Output in the console
		
		Fork  f1 = new Fork(true);
		Fork  f2 = new Fork(true);
		Fork  f3 = new Fork(true);
		Fork  f4 = new Fork(true);
		Fork  f5 = new Fork(true);
		                                                     
		ActionThread Aristote = new ActionThread("Aristote", f1, f2,tpw,begin,timeToStop,output);
		ActionThread Socrate = new ActionThread("Socrate", f2, f3,tpw,begin,timeToStop,output);
		ActionThread Platon = new ActionThread("Platon", f3, f4,tpw,begin,timeToStop,output);
		ActionThread Epicure = new ActionThread("Epicure", f4, f5,tpw,begin,timeToStop,output);
		ActionThread Seneque = new ActionThread("Seneque", f5, f1,tpw,begin,timeToStop,output);
		
		Aristote.start();
		Socrate.start();
		Platon.start();
		Epicure.start();
		Seneque.start();
		
		while(System.currentTimeMillis() - begin < timeToStop){
			// Loop to close the PrintWriter after the end of threads' execution 
		}
		
		tpw.close();

	}

}
