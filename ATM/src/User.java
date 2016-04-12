import java.util.ArrayList;

//Aggregates from account
public class User
{
   private String firstName;
   private String lastName;
   private String userID;
   private int pin;
   private Account account;
   
   public User(String firstName, String lastName,  String userID, int pin)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.pin = pin;
      this.userID = userID;//unless you want a random id number.
      this.account = new Account();
   }
   
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
   
   /*public void printAccountsSummary()
   {
   
   }*/
}
