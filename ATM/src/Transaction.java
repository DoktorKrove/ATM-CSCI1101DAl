import java.time.LocalDateTime;

//Transaction class

public class Transaction
{
   private double amount;
   private LocalDateTime timeStamp;
   private String type;
   
   public Transaction(double amount, String type)
   {
      this.amount = amount;
      this.timeStamp = LocalDateTime.now();
      this.type = type;
   }
   
   public double getAmount()
   {
      return amount;
   }
   
   public String getType()
   {
      return type;
   }
   
   public String getSummaryLine()
   {
      return (type + " of $" + amount + " at " + timeStamp);
   }
}
