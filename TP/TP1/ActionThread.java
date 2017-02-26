import java.util.Random;

// Action represents the philosophes and their actions (eat, wait)

public final class ActionThread extends Thread {

	private Fork left;				// Definition of their Fork and their place in 
	private Fork right;				// the table
	private long begin;				// Starting time of the main program
	private ThreadPrinter tpw;		// Object that allows the thread to write in a text file
	private long timeToStop;		// Global time that threads can't exceed
	private boolean output;			// output parameter (console, text file)
	
	public ActionThread(String name, Fork left, Fork right, ThreadPrinter tpw, long begin, long timeToStop,boolean output){
		
		super(name);
		this.left = left;
		this.right = right;
		this.begin = begin;
		this.tpw = tpw;
		this.timeToStop = timeToStop;
		this.output = output;
		
	}
	
	public synchronized void take(int i) throws InterruptedException {
		
		// Parameter i only define how many times a philosophe ate 
		
		Random rand = new Random();
		
		int timeToEat = rand.nextInt(256);
		
		if (!(left.getBool() && right.getBool())){ // true when Left and Right Forks 
												   // are not available
			wait();
			
			if (output){ // Writing the result in the console
			
			System.out.println(getName() + " attend de manger ");
			
			}
			
			else{ // Writing the result in the text file
				
				tpw.write(getName() + " attend de manger ");
				
			}
			
			
		}
		
		else{
			
			left.take();  // Take the left Fork and prevent his left neighbour from eating
			right.take(); // Take the right Fork and prevent his right neighbour from eating
			
			Thread.sleep(timeToEat); // Eat while timeToEat secs
			
			if (output){
			
			System.out.println(getName() + " mange pendant " + timeToEat + " ms" + " pour la " + (i+1) + " ème fois");
			
			}
			
			else{
				
				tpw.write(getName() + " mange pendant " + timeToEat + " ms" + " pour la " + (i+1) + " ème fois");
			}
			
			
			
		}
		
	}
	
	public synchronized void release(){
		
		left.release();   		// put The left Fork on the table 
		right.release();		// put The right Fork on the table 
		
		notifyAll();			// Allow his neighbour to eat
		
	}
	
	public void run()
	{
		
	Random rand = new Random();
	
	int timeToThink = rand.nextInt(256);
	
	try {
		
		Thread.sleep(timeToThink);			// Think for the first time
		
		if (output){
			
			System.out.println(getName() + " commence par penser pendant " + timeToThink + " ms");	
		
		}
		
		else{
			
			tpw.write(getName() + " commence par penser pendant " + timeToThink + " ms");
			
		}
		
		
	}
	
	catch(Exception e){
		
		e.printStackTrace();
		
	}
		
	for (int i=0 ; i<10; i++){		
		
		if (System.currentTimeMillis() - begin < timeToStop){
		// Philosophe have a time limit to eat
			
			try {
				take(i); // Philosophe eating 
			} 
				
			catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			release();  // Philosophe finished eating 
			
			if (output){
			
			System.out.println(getName() + " a fini de manger " + " et se remet à penser ");
			
			}
			
			else{
			
				tpw.write(getName() + " a fini de manger " + " et se remet à penser ");
				
			}
			
			
			try {
				Thread.sleep(rand.nextInt(256));
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
				
		}
	
	}
	
	}
	
}
