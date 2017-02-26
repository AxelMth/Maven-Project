package TP3;

import java.io.IOException;

public class Main {

	public static void main (String arg[]) throws IOException, ClassNotFoundException{
		
		HelloData data = new HelloData("Hello ", "World"); // Definition of an object 
		HelloData data2 = new HelloData("Hello2 ", "Guys"); // Definition of an other object
		
		System.out.println(data.getMessage() + data.getTransientMessage() + "\n" + data2.getMessage() + data2.getTransientMessage());
		// Show the value of the attributes 
		
		DataSerializer ser = new DataSerializer ("data.ser"); 
		ser.writeObject(data); // Writing data
		ser.writeObject(data2); // Writing data
		
		data.setTransientMessage("Guys"); // Try to change the Transient Message
		data2.setTransientMessage("World"); // Try to change the Transient Message
		
		data.setMessage("Hi "); // Try to change the message, but don't work !
		data.setMessage("Hi2 "); // Try to change the message, but don't work !
		
		DataUnSerializable unser = new DataUnSerializable("data.ser");
		HelloData newData = unser.readObject(); // Get the first object we saved
		HelloData newData2 = unser.readObject(); // Get the second object we saved
		
		// The order is fully satisfied !
		
		System.out.println(newData.getMessage() + newData.getTransientMessage() + "\n" + newData2.getMessage() + newData2.getTransientMessage() );
		
		// The transient messages don't have been saved !
		
	}
		
	
}
