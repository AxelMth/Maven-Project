
public class Main {

	public static void main(String[] args) {

		Fork  f1 = new Fork(true,1);
		Fork  f2 = new Fork(true,2);
		Fork  f3 = new Fork(true,3);
		Fork  f4 = new Fork(true,4);
		Fork  f5 = new Fork(true,5);
		                                                     
		ActionThread Aristote = new ActionThread("Aristote", f1, f2);
		ActionThread Socrate = new ActionThread("         Socrate", f2, f3);
		ActionThread Platon = new ActionThread("                 Platon", f3, f4);
		ActionThread Epicure = new ActionThread("                         Epicure", f4, f5);
		ActionThread Seneque = new ActionThread("                                 Seneque", f5, f1);
		
		Aristote.start();
		Socrate.start();
		Platon.start();
		Epicure.start();
		Seneque.start();
		
	}

}
