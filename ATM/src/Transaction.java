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
      this.amount = amount;
      //this.inAccount = inAccount;
      this.timeStamp = timeStamp;

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
}
