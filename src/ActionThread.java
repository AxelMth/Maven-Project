import java.util.Random;

public final class ActionThread extends Thread {

	private Fork left;
	private Fork right;
	private long begin;
	private ThreadPrinter tpw;
	private long timeToStop;
	private boolean output;
	
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
		
		Random rand = new Random();
		
		int timeToEat = rand.nextInt(256);
		
		if (!(left.getBool() && right.getBool())){
			
			wait();
			
			if (output){
			
			System.out.println(getName() + " attend de manger ");
			
			}
			
			else{
				
				tpw.write(getName() + " attend de manger ");
				
			}
			
			
		}
		
		else{
			
			left.take();
			right.take();
			
			Thread.sleep(timeToEat);
			
			if (output){
			
			System.out.println(getName() + " mange pendant " + timeToEat + " ms" + " pour la " + (i+1) + " ème fois");
			
			}
			
			else{
				
				tpw.write(getName() + " mange pendant " + timeToEat + " ms" + " pour la " + (i+1) + " ème fois");
			}
			
			
			
		}
		
	}
	
	public synchronized void release(){
		
		left.release();
		right.release();
		
		notifyAll();
		
	}
	
	public void run()
	{
		
	Random rand = new Random();
	
	int timeToThink = rand.nextInt(256);
	
	try {
		
		Thread.sleep(timeToThink);
		
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
				
			try {
				take(i);
			} 
				
			catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			release();
			
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
