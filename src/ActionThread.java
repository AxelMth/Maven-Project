import java.util.Random;

public final class ActionThread extends Thread {

	private Fork left;
	private Fork right;
	private long begin;
	private ThreadPrinter tpw;
	private long timeToStop;
	
	public ActionThread(String name, Fork left, Fork right, ThreadPrinter tpw, long begin, long timeToStop){
		
		super(name);
		this.left = left;
		this.right = right;
		this.begin = begin;
		this.tpw = tpw;
		this.timeToStop = timeToStop;
		
	}
	
	public synchronized void take(int i) throws InterruptedException {
		
		Random rand = new Random();
		
		int timeToEat = rand.nextInt(256);
		
		if (!(left.getBool() && right.getBool())){
			
			wait();
			
			System.out.println(getName() + " attend de manger ");
			
			tpw.write(getName() + " attend de manger ");
			
		}
		
		else{
			
			left.take();
			right.take();
			
			Thread.sleep(timeToEat);
			
			System.out.println(getName() + " mange pendant " + timeToEat + " ms" + " pour la " + (i+1) + " ème fois");
			
			tpw.write(getName() + " mange pendant " + timeToEat + " ms" + " pour la " + (i+1) + " ème fois");
			
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
		
		System.out.println(getName() + " commence par penser pendant " + timeToThink + " ms");
		
		tpw.write(getName() + " commence par penser pendant " + timeToThink + " ms");
		
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
			
			System.out.println(getName() + " a fini de manger " + " et se remet à penser ");
			
			tpw.write(getName() + " a fini de manger " + " et se remet à penser ");
			
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
