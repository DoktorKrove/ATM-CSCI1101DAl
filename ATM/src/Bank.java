import java.util.ArrayList;

//Aggregates from account and user
public class Bank
{
	private String name;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	//constructor
	public Bank(String name)
	{
		this.name = name;
	}
	
	public String getNewUserID()
	{
	}
	
	public String getNewAccountID()
	{
	}
	
	public User addUser(String firstName, String lastName, String pin)
	{
	}

	public void addAccount(Account newAccount)
	{
	}
	
	public User userLogin(String userID, String pin)
	{
	}
	
	public String getName()
	{
	}
}
