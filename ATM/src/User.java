import java.util.ArrayList

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
   
   public double getAccBalance(int accindex)//Not sure what this is. Account array index?
   {
   
   }
   
   public String getAccID(int accindex)//Not sure what this is. same as above
   {
   
   }
   
   public void printAccHistory(int accindex)
   {
   
   }
   
   public void addAccTransaction(int accindex, double amount, String memo)
   {
   
   }
   
   public boolean validatePin(String aPin)
   {
   
   }
   
   public void printAccountsSummary()
   {
   
   }
}
