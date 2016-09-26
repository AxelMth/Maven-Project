package TP3;

import java.io.*;

public class DataUnSerializable{

	private ObjectInputStream obj;
	
	public DataUnSerializable(String s) throws FileNotFoundException, IOException {
		
		this.obj = new ObjectInputStream( new FileInputStream (s));
		
	}
	
	public HelloData readObject() throws IOException, ClassNotFoundException{
		
		return (HelloData) obj.readObject();
		
	}
	
	public void close() throws IOException{
		
		obj.close();
		
	}
}




