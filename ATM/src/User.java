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
}