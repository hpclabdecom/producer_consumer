
package problem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class SerializeObjectImpl <T>{
	private String dir;
	
	public SerializeObjectImpl(String dir){
		super();
		this.dir = dir;
	}
	
	private String nameCleaner(String input){
		//System.err.println("before: " + input);
		input = input.replaceAll("[^a-zA-Z 0-9]+","");	
		//System.err.println("after: " + input);
		return input;
	}
		 
	//To serialize (save the Object state to a file) :
	public void serializeToFile(T obj, String objName){
		  objName = nameCleaner(objName);
		  try {
		      BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(dir + objName+".dat", false));
		      ObjectOutputStream oos = new ObjectOutputStream(fout);
		      oos.writeObject(obj);
		      //fout.flush();
		      oos.flush();
		      oos.close();
		      
		      fout.flush();
		      fout.close();
		      //
		      
		      fout = null;
		      oos = null;
		      obj = null;			      
	          
		      }
		   catch (Exception e) { System.err.println("not serialized: " + objName);}
		
	}
	
	public T unserializeToFile(String objName){
		T obj;
		
	   try {		
	    BufferedInputStream fin = new BufferedInputStream(new FileInputStream(dir + objName+".dat"));
		//BufferedInputStream fin = new BufferedInputStream(new FileInputStream(dir + objName));
	    ObjectInputStream ois = new ObjectInputStream(fin);
	    obj = (T)ois.readObject();
		ois.close();
		fin.close();
	    return obj;
	    }
	   catch (Exception e) { 
		   //e.printStackTrace();
		   return null;
		 }
	  	 
	}
	
	public T unserializeToFileFullPath(String objName){
		T obj;
		
	   try {		
	    BufferedInputStream fin = new BufferedInputStream(new FileInputStream(dir + objName));
	    ObjectInputStream ois = new ObjectInputStream(fin);
	    obj = (T)ois.readObject();
		ois.close();
		fin.close();
	    return obj;
	    }
	   catch (Exception e) { 
		   //e.printStackTrace();
		   return null;
		 }
	  	 
	}

	
	public void setDir(String dir) {
		this.dir = dir;		
	}	

}
