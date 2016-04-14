import java.util.ArrayList;


public class Bank
{
	private String name;
	public ArrayList<User> users = new ArrayList<User>();
   	
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
   
   public User findUser(String userID)
   {
      for (User user: users)
      {
    	  if (user.getUserID().equals(userID))
    	  {
    		  return user;
    	  }
      }
      return null;
   }
   
   public User matchPin(int pin)
   {
	   for (int i = 0; i < users.size(); i++)
	   {
		   if (users.get(i).getPin() == pin)
			   return users.get(i);
	   }
	   //if a user isn't found returns null
	   return null;
   }
	
	
}
