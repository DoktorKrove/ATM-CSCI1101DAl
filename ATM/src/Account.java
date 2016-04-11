import java.util.ArrayList;

//Aggregates from transaction
public class Account 
{

	private double balance;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();


	public Account()
	{
		balance = 0;
		transactions = new ArrayList<Transaction>();
	}

	public double getBalance() 
   {
		return balance;
	}
	

	public void addTransaction(double amount)
	{
	}

	
	public void addTransaction(double amount, String memo)
	{
	}

	
	public String getSummaryLine()
	{ 
	}


	public void printTransactionHistory()
	{
	} 

}
