package TP3;

import java.io.*;

public class DataSerializer {

	private ObjectOutputStream obj;
	
	public DataSerializer(String s) throws FileNotFoundException, IOException{
		
		this.obj = new ObjectOutputStream( new FileOutputStream (s));
		
	}
	
	public void writeObject(HelloData data) throws IOException{
		
		obj.writeObject(data);
		
	}
	
	public void close() throws IOException{
		
		obj.close();
		
	}
}

