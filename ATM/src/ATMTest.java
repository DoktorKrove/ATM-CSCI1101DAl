import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;


public class ATMTest extends JFrame implements ActionListener{
   //panel parts
   private JPanel panel, layer1, layer2, keypad, control, functions;
   private JButton one,two,three,four,five,six,seven,eight,nine,zero,enter,clear,
                   accept,cancel,deposit,withdraw,accountInfo;
   private JLabel front, welcome, info, withdrawMes, depositMes, withYes, depYes;
   //private JTextField;
   private JFormattedTextField textField, pinArea;
   
   //Bank parts
   private Bank bank;
   private User user;
   private Account account;
   private Transaction transaction;
   
   public ATMTest() throws ParseException{
      //create panels
      panel = new JPanel();
      layer1 = new JPanel(new GridLayout(2,1));
      layer2 = new JPanel();
      control = new JPanel(new FlowLayout());
      keypad = new JPanel(new GridLayout(4,3));
      functions = new JPanel(new GridLayout(5,1));
      
      Bank bank = new Bank("JoelBank");
      User u1 = new User("Joel", "Fong",  "123456789", 1111);
      bank.addUser(u1);
      
      front = new JLabel("Hello welcome to "+ bank.getName() + "! For use, please insert BankID and PIN.");
      panel.add(front);
      
      welcome = new JLabel("Welcome user" + /*user.getName() +*/ ". What do you want to do?");
      panel.add(welcome);
      welcome.setVisible(false);
      
      withdrawMes = new JLabel("Insert how much you wish to withdraw.");
      panel.add(withdrawMes);
      withdrawMes.setVisible(false);
      
      depositMes = new JLabel("Insert how much you want to deposit.");
      panel.add(depositMes);
      depositMes.setVisible(false);
      
      withYes = new JLabel("Withdraw Success");
      panel.add(withYes);
      withYes.setVisible(false);
      
      depYes = new JLabel("Deposit Success");
      panel.add(depYes);
      depYes.setVisible(false);
      
      info = new JLabel("User name: Name \n User ID: ID \n User Balance: Monayyyy");
      panel.add(info);
      info.setVisible(false);
      
      textField = new JFormattedTextField(new MaskFormatter("*********"));
      textField.setEditable(true);
      textField.setColumns(25);
      
      layer1.add(textField);
      
      pinArea = new JFormattedTextField(new MaskFormatter("****"));
      pinArea.setEditable(false);
      pinArea.setColumns(5);
      layer2.add(pinArea);
      
      accept = new JButton("Accept");
      Font newButtonFont=new Font(accept.getFont().getName(),Font.BOLD,accept.getFont().getSize());
      accept.setFont(newButtonFont);
      //accept.addActionListener(this);
      functions.add(accept);
      
      accountInfo = new JButton("Account Information");
      accountInfo.setFont(newButtonFont);
      accountInfo.addActionListener(this);
      functions.add(accountInfo);
      
      withdraw = new JButton("Account Withdraw");
      withdraw.setFont(newButtonFont);
      withdraw.addActionListener(this);
      functions.add(withdraw);
      
      deposit = new JButton("Account Deposit");
      deposit.setFont(newButtonFont);
      deposit.addActionListener(this);
      functions.add(deposit);
      
      cancel = new JButton("Cancel");
      cancel.setFont(newButtonFont);
      cancel.addActionListener(this);
      functions.add(cancel);
      
      
        one = new JButton(String.valueOf(1));
        two = new JButton(String.valueOf(2));
        three = new JButton(String.valueOf(3));
        keypad.add(one);
        one.addActionListener(this);
        keypad.add(two);
        two.addActionListener(this);
        keypad.add(three);
        three.addActionListener(this);

        
        four = new JButton(String.valueOf(4));
        five = new JButton(String.valueOf(5));
        six = new JButton(String.valueOf(6));
        keypad.add(four);
        four.addActionListener(this);
        keypad.add(five);
        five.addActionListener(this);
        keypad.add(six);
        six.addActionListener(this);

        
        seven = new JButton(String.valueOf(7));
        eight = new JButton(String.valueOf(8));
        nine = new JButton(String.valueOf(9));
        keypad.add(seven);
        seven.addActionListener(this);
        keypad.add(eight);
        eight.addActionListener(this);
        keypad.add(nine);
        nine.addActionListener(this);

        enter = new JButton("Enter");
        keypad.add(enter);
        enter.addActionListener(this);
        
        zero = new JButton(String.valueOf(0));
        keypad.add(zero);
        zero.addActionListener(this);
        
        clear = new JButton("Clear");
        keypad.add(clear);
        clear.addActionListener(this);
       
      control.add(functions);
      control.add(keypad);
      layer1.add(layer2);
      panel.add(layer1);
      panel.add(control);
      
      //make the panel
      add(panel);
      setTitle("ATM Test");
      setSize(450,300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   @Override
    public final void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if(source.equals(enter)){
            if(pinArea.getValue() != null && pinArea.getValue().toString().length() != 4){
                JOptionPane.showMessageDialog(this, "Invalid PIN - must be 4 digits long.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Valid PIN length.", "Valid", JOptionPane.INFORMATION_MESSAGE);
            }
            clear.doClick();
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

            if(sb.length() != 4){
                sb.append(source.getText());
                pinArea.setValue(sb);
            }
        }
        
        if (e.getSource() == accountInfo){
            info.setVisible(true);
            front.setVisible(false);
            welcome.setVisible(false);
            withdrawMes.setVisible(false);
            depositMes.setVisible(false);
            withYes.setVisible(false);
            depYes.setVisible(false);
            pinArea.setValue(null);
            textField.setValue(null);
        }
        if (e.getSource() == withdraw){
            info.setVisible(false);
            front.setVisible(false);
            welcome.setVisible(false);
            withdrawMes.setVisible(true);
            depositMes.setVisible(false);
            withYes.setVisible(false);
            depYes.setVisible(false);
            pinArea.setValue(null);
            textField.setValue(null);
        }
        if (e.getSource() == deposit){
            info.setVisible(false);
            front.setVisible(false);
            welcome.setVisible(false);
            withdrawMes.setVisible(false);
            depositMes.setVisible(true);
            withYes.setVisible(false);
            depYes.setVisible(false);
            pinArea.setValue(null);
            textField.setValue(null);
        }
        if (e.getSource() == cancel){
            info.setVisible(false);
            front.setVisible(false);
            welcome.setVisible(true);
            withdrawMes.setVisible(false);
            depositMes.setVisible(false);
            withYes.setVisible(false);
            depYes.setVisible(false);
            pinArea.setValue(null);
            textField.setValue(null);
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
