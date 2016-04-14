import java.util.ArrayList;

//Aggregates from account
public class User
{
   private String firstName;
   private String lastName;
   private String userID;
   private int pin;
   private Account account;
   
   public User(String firstName, String lastName,  String userID, int pin, double balence)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.pin = pin;
      this.userID = userID;//unless you want a random id number.
      this.account = new Account();
      account.deposit(balence);
   }
   
   //empty constructor version
   public User(){}
   
   public String getName()
   {
      return firstName + " " + lastName;
   }
   
   public String getUserID()
   {
      return userID;
   }
   
   public int getPin()
   {
      return pin;
   }
   
   //public Account getAccount()
   
   public boolean validatePin(int aPin)
   {
      if (aPin == this.pin)
         return true;
      else
         return false;
         
   }
   
   //deposit a given amount
   public void deposit(double amount)
   {
	   account.deposit(amount);
   }
   
   //withdraw a given amount
   public void withdraw(double amount)
   {
	   account.withdraw(amount);
   }
   
   //get total moneyz
   public double getBalance()
   {
	   return account.getBalance();
   }
   public String AccountsSummary()
   {
	   return account.showTransactionLogs();
   }
}
