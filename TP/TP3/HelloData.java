package TP3;

import java.io.Serializable;

public class HelloData implements Serializable {

	private static final long serialVersionUID = 1L; // UID for Serialization

	private String message; // Message that will be sent
	
	transient String transientMessage; // Message that won't be serialized 
	
	public HelloData (String message, String transientMessage){ // Definition of the messages 
		
		this.message = message;
		this.transientMessage = transientMessage;
		
	}
	
	public String getMessage (){
		
		return message; // Test to show which message has been sent
		
	}
	
	public String getTransientMessage(){
		
		return transientMessage; // IDEM
		
	}
	
	public void setMessage(String message){
		
		this.message = message;
		
	}
	
	public void setTransientMessage(String transientMessage){
		
		this.transientMessage = transientMessage;
		
	}
	
}
