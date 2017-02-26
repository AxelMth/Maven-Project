package TP3;

import java.io.*;

public class DataSerializer {

	private ObjectOutputStream obj; // DataSerializer is an object that just contains an ObjectOutputStream
	
	public DataSerializer(String s) throws FileNotFoundException, IOException{
		
		this.obj = new ObjectOutputStream( new FileOutputStream (s));
		// Definition of the file in which the data will be written 
	}
	
	public void writeObject(HelloData data) throws IOException{
		
		obj.writeObject(data); // Same function than ObjectOutputStream but with an HelloData for argument 
		
	}
	
	public void close() throws IOException{
		
		obj.close(); // Same function close
		
	}
}

