
public class Main {

	public static void main(String[] args) throws Exception {
		
		long begin = System.currentTimeMillis();
		int timeToStop = 1000;
		
		ThreadPrinter tpw = new ThreadPrinter("philosophe.txt");
		
		Fork  f1 = new Fork(true);
		Fork  f2 = new Fork(true);
		Fork  f3 = new Fork(true);
		Fork  f4 = new Fork(true);
		Fork  f5 = new Fork(true);
		                                                     
		ActionThread Aristote = new ActionThread("Aristote", f1, f2,tpw,begin);
		ActionThread Socrate = new ActionThread("         Socrate", f2, f3,tpw,begin);
		ActionThread Platon = new ActionThread("                 Platon", f3, f4,tpw,begin);
		ActionThread Epicure = new ActionThread("                         Epicure", f4, f5,tpw,begin);
		ActionThread Seneque = new ActionThread("                                 Seneque", f5, f1,tpw,begin);
		
		Aristote.start();
		Socrate.start();
		Platon.start();
		Epicure.start();
		Seneque.start();
		
		while(System.currentTimeMillis() - begin < timeToStop){
			
		}
		
		

	}

}
