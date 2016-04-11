import java.time.LocalDateTime;

//Transaction class

public class Transaction
{
   private double amount;
   private LocalDateTime timeStamp; //unsure of usage. Utilize java.time.LocalDateTime??
   
   public Transaction(double amount)
   {
      this.amount = amount;
      this.timeStamp = LocalDateTime.now();

   }
   
   public double getAmount()
   {
      return amount;
   }
   
   public void getSummaryLine()
   {
      System.out.println(timeStamp);
   }
}
