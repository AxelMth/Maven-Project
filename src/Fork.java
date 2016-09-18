public final class Fork {
	
	private boolean bool;
	private int id;
	
	public Fork(boolean bool, int id){
		
		this.bool = bool;
		this.id = id;
	}
	
	public boolean getBool(){
		
		return bool;
		
	}
	
	public void take(){
		
		this.bool = false;
		
	}
	
	public void release(){
		
		this.bool = true;
		
	}
	
}
