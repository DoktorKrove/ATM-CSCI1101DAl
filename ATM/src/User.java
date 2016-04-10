import java.util.ArrayList;

//Aggregates from account
public class User
{
   private String firstName;
   private String lastName;
   private String userID;
   private byte pinHash[];//Gonna need an explination on this.
   private ArrayList<Account> accounts;//multiple accounts per user, requires Account to be done
   
   public User(String firstName, String lastName, String pin, Bank theBank)
   {
      //requires bank to be finished
   }
   
   public String getUserID()
   {
      return userID;
   }
   
   public void addAccount(Account acc)
   {
      //requires Account
   }
   
   public int numAccounts()
   {
      //returns size of account arraylist
   }
   
   public double getAccBalance(int accindex)
   {
      return this.accounts.get(accindex).getBalance();
   }
   
   public String getAccID(int accindex)
   {
      return this.accounts.get(accindex).getUserID();

   }
   
   public void printAccHistory(int accindex)
   {
      this.accounts.get(accindex).printTransHistory();
   }
   
   public void addAccTransaction(int accindex, double amount, String memo)
   {
      this.accounts.get(accindex).addTransaction(amount, memo);
   }
   
   public boolean validatePin(String aPin)
   {
      try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
		} 
		catch (Exception e) 
		{
			System.err.println("error, caught exeption : " + e.getMessage());
			System.exit(1);
		}
		
		return false;
   }
   
   public void printAccountsSummary()
   {
      System.out.printf("\n\n%s's accounts summary\n", this.firstName);
		for (int a = 0; a < this.accounts.size(); a++) 
		{
			System.out.printf("%d) %s\n", a+1, 
					this.accounts.get(a).getSummaryLine());
		}
		System.out.println();
   }
}
