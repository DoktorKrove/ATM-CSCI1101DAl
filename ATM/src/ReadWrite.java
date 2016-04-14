import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadWrite {
	
	public ReadWrite() {
		
	}
	public String updateData(Bank bank) throws FileNotFoundException {
		User user;
		String filename = "bank.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try{
		  String line;
			String bankID = "";
			int bankPIN = 0;
			String userFirst = "";
			String userLast = "";
			double balance = 0.0;
		  //as long as there are lines in the file, print them
		  while((line = reader.readLine()) != null){
			  System.out.println(line);
			  if (line.contains("BANKID:"))
			  {
				  bankID = line.substring(7);
				  System.out.println(bankID);
			  }
			  else if (line.contains("BANKPIN:"))
			  {
				  bankPIN = Integer.parseInt(line.substring(8));
				  System.out.println(bankPIN);
			  }
			  else if (line.contains("Name:"))
			  {
				  userFirst = line.substring(5, line.indexOf("."));
				  userLast = line.substring(line.indexOf(".") + 1);
				  System.out.println(userFirst + " " +userLast);
			  }
			  else if (line.contains("Chequing account balance:"))
			  {
				  balance = Double.parseDouble(line.substring(25));
				  System.out.println(balance);
			  }
			  if (bankID != "" && bankPIN != 0 && userFirst != "" && balance != 0.0)
			  {
				  user = new User(userFirst, userLast, bankID, bankPIN, balance);
				  bank.addUser(user);
				  System.out.println("Added new user " + bankID);
				  //reset the values
				  bankID = "";
				  bankPIN = 0;
				  userFirst = "";
				  userLast = "";
				  balance = 0.0;
			  }
		    }
		  
    
		} catch (IOException e) {
		  e.printStackTrace();
		}
		return "invalid";
	}		
}