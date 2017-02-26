package TP3;

import java.io.*;

public class DataUnSerializable{

	private ObjectInputStream obj; // IDEM than Data Serializer
	
	public DataUnSerializable(String s) throws FileNotFoundException, IOException {
		
		this.obj = new ObjectInputStream( new FileInputStream (s)); //IDEM
		
	}
	
	public HelloData readObject() throws IOException, ClassNotFoundException{
		
		return (HelloData) obj.readObject();  // Return an HelloData from the data.ser
		
	}
	
	public void close() throws IOException{
		
		obj.close(); // IDEM
		
	}
}




