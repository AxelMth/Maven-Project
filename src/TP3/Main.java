package TP3;

import java.io.IOException;

public class Main {

	public static void main (String arg[]) throws IOException, ClassNotFoundException{
		
		HelloData data = new HelloData("Hello ", "World");
		
		System.out.println(data.getMessage() + data.getTransientMessage());
		
		DataSerializer ser = new DataSerializer ("data.ser");
		ser.writeObject(data);
		
		DataUnSerializable unser = new DataUnSerializable("data.ser");
		HelloData my_new_data = unser.readObject();
		
		System.out.println(my_new_data.getMessage() + my_new_data.getTransientMessage());
		
		
	}
		
	
}
