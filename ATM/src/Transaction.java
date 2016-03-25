import java.util.Date;

//Transaction class

public class Transaction
{
   private double amount;
   private String memo;
   //private Account inAccount; - requires account to be finished
   private Date timeStamp; //unsure of usage. Utilize java.time.LocalDateTime??
   
   public Transaction(double amount /*, Account inAccount*/);
   {
   
   }
   
   public Transaction(double amount, String memo /*, Account inAccount*/);
   {
   
   }
   
   public double getAmount()
   {
      return amount;
   }
   
   public String getSummaryLine()
   {
      return memo;
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
