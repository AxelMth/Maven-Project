public final class Fork {
	
	// Simple object with a boolean that says if the Fork is taken or not 
	
	private boolean bool;
	
	public Fork(boolean bool){
		
		this.bool = bool;
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
