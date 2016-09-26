package TP3;

import java.io.Serializable;

public class HelloData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	
	transient String transientMessage;
	
	public HelloData (String message, String transientMessage){
		
		this.message = message;
		this.transientMessage = transientMessage;
		
	}
	
	public String getMessage (){
		
		return message;
		
	}
	
	public String getTransientMessage(){
		
		return transientMessage;
		
	}
}
