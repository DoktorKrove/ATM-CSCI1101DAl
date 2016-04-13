import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadWrite {
	
	public ReadWrite() {
		
	}
	
	public String updateData(String id) throws FileNotFoundException {
		
		String filename = "bank.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try{
		  String line;
		  //as long as there are lines in the file, print them
		  while((line = reader.readLine()) != null){ 
		    System.out.println(line);
		    
		    if (line.equals(("BANKID:"+id).trim()) ) {
		    	line = reader.readLine();
		    	line = reader.readLine();
		    	String name = line;
		    	line = reader.readLine();
		    	String balance = line;
		    	
		    	return name + "  " + balance;
		    	
		    }
    
		  }
		} catch (IOException e) {
		  e.printStackTrace();
		}
		return "invalid";
		
	}
		
	}