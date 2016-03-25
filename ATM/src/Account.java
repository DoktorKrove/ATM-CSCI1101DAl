import java.util.ArrayList;

//Aggregates from transaction
public class Account {

	String name, userID;
	User holder;
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();


	public Account(String name, User holder, Bank theBank)
	{
		this.name = name;
		this.holder = holder;
	}

	public String getUserID() {
		return userID;
	}
	

	public void addTransaction(double amount)
	{
	}

	
	public void addTransaction(double amount, String memo)
	{
	}

	public double getBalence()
	{
	}

	
	public String getSummaryLine()
	{ 
	}


	public void printTransactionHistory()
	{
	} 

}
