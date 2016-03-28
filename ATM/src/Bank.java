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
		users = new ArrayList<User>();
		accounts = new ArrayList<Account>();
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
		this.accounts.add(newAccount);
	}
	
	public User userLogin(String userID, String pin)
	{
	}
	
	public String getName()
	{
		return this.name;
	}
}
