import java.util.Random;

public final class ActionThread extends Thread {

	private Fork left;
	private Fork right;
	private long begin;
	private ThreadPrinter tpw;
	
	public ActionThread(String name, Fork left, Fork right, ThreadPrinter tpw, long begin){
		
		super(name);
		this.left = left;
		this.right = right;
		this.begin = begin;
		this.tpw = tpw;
		
	}
	
	public synchronized void take() throws InterruptedException {
		
		if (!(left.getBool() && right.getBool())){
			
			wait();
			
		}
		
		else{
			
			left.take();
			right.take();
			
			System.out.println(getName());
			
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
	
	try {
		Thread.sleep(rand.nextInt(256));
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	
		
		for (int i=0 ; i<10; i++){
			
			if (System.currentTimeMillis() - begin < 1000){
				
				try {
					take();
				} 
				
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				release();
				
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
