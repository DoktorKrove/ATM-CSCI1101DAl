import java.util.ArrayList;


public class Bank
{
	private String name;
	private ArrayList<User> users = new ArrayList<User>();
   	
	//constructor
	public Bank(String name)
	{
		this.name = name;
		users = new ArrayList<User>();
	}
   
   public String getName()
	{
		return this.name;
	}
	
   public void addUser(User user)
   {
      users.add(user);
   }
   
   public boolean findUser(User user)
   {
      if (users.contains(user))
         return true;
      else
         return false;
   }
	
	
}
