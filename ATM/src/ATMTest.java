import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.net.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;


public class ATMTest extends JFrame implements ActionListener
{
   //panel parts
   private JPanel panel, layer1, layer2, keypad, control, functions;
   private JButton one,two,three,four,five,six,seven,eight,nine,zero,enter,clear,
                   log,cancel,deposit,withdraw,accountInfo;
   private JLabel info, keyBlankL, keyBlankR;
   //private JTextField;
   private JFormattedTextField textField, pinArea;
   
   //Bank parts
   private Bank bank = new Bank("JoelBank");
   private User user;
   private Account account;
   private Transaction transaction;
   private char buttonState = 'l';	/* when a button is pressed the value of this variable will change
   								   used for checking which button has been pressed */
   
   public ATMTest() throws ParseException{
      //create panels
      panel = new JPanel();
      layer1 = new JPanel(new GridLayout(2,1));
      layer1.setBackground(Color.LIGHT_GRAY);
      layer2 = new JPanel();
      layer2.setBackground(Color.LIGHT_GRAY);
      control = new JPanel(new FlowLayout());
      keypad = new JPanel(new GridLayout(5,3));
      functions = new JPanel(new GridLayout(5,1));

	     
	  info = new JLabel("Enter your User ID and PIN to log in.");
	  info.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
	  panel.add(info);
	  info.setVisible(true);

      textField = new JFormattedTextField(new MaskFormatter("*********"));
      textField.setEditable(true);
      textField.setColumns(25);
      
      layer1.add(textField);
      
      pinArea = new JFormattedTextField(new MaskFormatter("****"));
      pinArea.setEditable(false);
      pinArea.setColumns(5);
      pinArea.setBackground(Color.black);
      pinArea.setDisabledTextColor(Color.WHITE);
      pinArea.setSelectedTextColor(Color.BLACK);
      pinArea.setSelectionColor(Color.WHITE);
      pinArea.setForeground(Color.WHITE);
      keyBlankL = new JLabel();
      keyBlankR = new JLabel();
      keypad.add(keyBlankL);
      keypad.add(pinArea);
      keypad.add(keyBlankR);
      keypad.setBackground(Color.lightGray);
      
      log = new JButton("Transaction Log");
      Font newButtonFont=new Font(log.getFont().getName(),Font.BOLD,log.getFont().getSize());
      log.setFont(newButtonFont);
      //log.addActionListener(this);
      log.setBackground(Color.WHITE);
      log.addActionListener(this);
      functions.setBackground(Color.lightGray);
      functions.add(log);
      
      
      accountInfo = new JButton("Account Information");
      accountInfo.setFont(newButtonFont);
      accountInfo.addActionListener(this);
      accountInfo.setBackground(Color.WHITE);
      functions.add(accountInfo);
      
      withdraw = new JButton("Account Withdraw");
      withdraw.setFont(newButtonFont);
      withdraw.addActionListener(this);
      withdraw.setBackground(Color.WHITE);
      functions.add(withdraw);
      
      deposit = new JButton("Account Deposit");
      deposit.setFont(newButtonFont);
      deposit.addActionListener(this);
      deposit.setBackground(Color.WHITE);
      functions.add(deposit);
      
      cancel = new JButton("Log Out");
      cancel.setFont(newButtonFont);
      cancel.addActionListener(this);
      cancel.setBackground(Color.WHITE);
      functions.add(cancel);
      
      
     one = new JButton(String.valueOf(1));
     two = new JButton(String.valueOf(2));
     three = new JButton(String.valueOf(3));
     //change the colours
     one.setBackground(Color.GRAY);
     two.setBackground(Color.GRAY);
     three.setBackground(Color.GRAY);
     keypad.add(one);
     one.addActionListener(this);
     keypad.add(two);
     two.addActionListener(this);
     keypad.add(three);
     three.addActionListener(this);

        
     four = new JButton(String.valueOf(4));
     five = new JButton(String.valueOf(5));
     six = new JButton(String.valueOf(6));
     four.setBackground(Color.GRAY);
     five.setBackground(Color.GRAY);
     six.setBackground(Color.GRAY);
     keypad.add(four);
     four.addActionListener(this);
     keypad.add(five);
     five.addActionListener(this);
     keypad.add(six);
     six.addActionListener(this);

        
     seven = new JButton(String.valueOf(7));
     eight = new JButton(String.valueOf(8));
     nine = new JButton(String.valueOf(9));
     seven.setBackground(Color.GRAY);
     eight.setBackground(Color.GRAY);
     nine.setBackground(Color.GRAY);
     keypad.add(seven);
     seven.addActionListener(this);
     keypad.add(eight);
     eight.addActionListener(this);
     keypad.add(nine);
     nine.addActionListener(this);

     enter = new JButton("Enter");
     enter.setBackground(Color.GREEN);
     keypad.add(enter);
     enter.addActionListener(this);
        
     zero = new JButton(String.valueOf(0));
     zero.setBackground(Color.GRAY);
     keypad.add(zero);
     zero.addActionListener(this);
        
     clear = new JButton("Clear");
     clear.setBackground(Color.YELLOW);
     keypad.add(clear);
     clear.addActionListener(this);
       
      control.add(functions);
      control.add(keypad);
      layer1.add(layer2);
      panel.add(layer1);
      panel.add(control);
      layer1.setBackground(Color.LIGHT_GRAY);
      layer2.setBackground(Color.LIGHT_GRAY);
      panel.setBackground(Color.LIGHT_GRAY);
      panel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
      
      //make the panel
      add(panel);
      setTitle("ATM Test");
      setSize(470,300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      //update the Bank file with users from the text file
      System.out.println(textField.getText());
      ReadWrite rw = new ReadWrite();
      try {
			String something = rw.updateData(bank);
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
   }
   
   @Override
    public final void actionPerformed(ActionEvent e)
   {
        JButton source = (JButton)e.getSource();
        if(source.equals(enter))
        {
        	//checks for which button has been pressed
        	if (buttonState == 'w')
        	{
        		pinArea.setColumns(8);
        		if (Integer.parseInt(pinArea.getValue().toString()) > 0)
	            {
	            	user.withdraw(Integer.parseInt(pinArea.getValue().toString()));
	            	pinArea.setValue(null);
	            	accountInfo.doClick();
	            }
        	}
        	else if (buttonState == 'd')
        	{
        		pinArea.setColumns(8);
	            if (Integer.parseInt(pinArea.getValue().toString()) > 0)
	            {
	            	user.deposit(Integer.parseInt(pinArea.getValue().toString()));
	            	pinArea.setValue(null);
	            	accountInfo.doClick();
	            }
        	}
        	else if (buttonState == 'l')
        	{
        		pinArea.setColumns(4);
            	user = bank.findUser(textField.getText());
            	if (user != null)
            	{
            		if (user.validatePin((Integer.parseInt(pinArea.getText()))))
            		{
            			JOptionPane.showMessageDialog(this, "Valid PIN, Hello " + user.getName(), "Valid", JOptionPane.INFORMATION_MESSAGE);
            			textField.setValue(null);
            			pinArea.setValue(null);
            			accountInfo.doClick();
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(this, "Invalid PIN!", "Invalid PIN", JOptionPane.INFORMATION_MESSAGE);
            			user = null;
            		}
            	}
        	}
        }
        else if(source.equals(clear)){
            pinArea.setValue(null);
        }
        else{
            StringBuilder sb = new StringBuilder();
            if(pinArea.getValue() != null){
                for(char c: pinArea.getValue().toString().toCharArray()){
                    sb.append(c);
                }
            }

            if(sb.length() != pinArea.getColumns()){
                sb.append(source.getText());
                pinArea.setValue(sb);
            }
        }
        if (user != null)
        {
        	
	        if (e.getSource() == accountInfo){
	        	info.setText("Account ID: " + user.getUserID() + " Name: " + user.getName() + " Balance " + user.getBalance());
	            pinArea.setValue(null);
	            textField.setValue(null);
	            buttonState = 'n';
	            pinArea.setColumns(8);
	            
	            
	        }
	        if (e.getSource() == withdraw){
	            info.setText("Insert how much you wish to withdraw.");
	            pinArea.setValue(null);
	            textField.setValue(null);
	            buttonState = 'w';
	            pinArea.setColumns(8);
	        }
	        if (e.getSource() == deposit){
	            info.setText("Insert how much you want to deposit.");
	            pinArea.setValue(null);
	            textField.setValue(null);
	            buttonState = 'd';
	            pinArea.setColumns(8);
	        }
	        if (e.getSource() == cancel){
	            info.setText("Enter your User ID and PIN");
	            pinArea.setValue(null);
	            textField.setValue(null);
	            buttonState = 'l';
	            user = null;
	            pinArea.setColumns(4);
	        }
	        if (e.getSource() == log)
	        {
	        	JOptionPane.showMessageDialog(this, user.AccountsSummary(), "Transaction Log", JOptionPane.INFORMATION_MESSAGE);
	        	pinArea.setValue(null);
	        }
        }
    }
   
   //main 
   public static void main(String[] args){
      try
      {
         ATMTest ATM = new ATMTest();
      }catch (ParseException e) {
         e.printStackTrace();
       }
       
   }
}
