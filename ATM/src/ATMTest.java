import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


public class ATMTest extends JFrame{ //implements ActionListener{
   //panel parts
   private JPanel panel, layer1, layer2, keypad, control, functions;
   private JButton one,two,three,four,five,six,seven,eight,nine,zero,enter,clear,
                   accept,cancel,deposit,withdraw,accountInfo;
   //private JLabel;
   //private JTextField;
   private JFormattedTextField textField, pinArea;
   
   public ATMTest(){
      //create panels
      panel = new JPanel();
      layer1 = new JPanel(new GridLayout(2,1));
      layer2 = new JPanel();
      control = new JPanel(new FlowLayout());
      keypad = new JPanel(new GridLayout(4,3));
      functions = new JPanel(new GridLayout(5,1));
      
      textField = new JFormattedTextField();
      textField.setEditable(false);
      textField.setColumns(25);
      
      layer1.add(textField);
      
      pinArea = new JFormattedTextField(/*new MaskFormatter("****")*/);
      pinArea.setEditable(false);
      pinArea.setColumns(4);
      layer2.add(pinArea);
      
      accept = new JButton("Accept");
      Font newButtonFont=new Font(accept.getFont().getName(),Font.BOLD,accept.getFont().getSize());
      accept.setFont(newButtonFont);
      //accept.addActionListener(this);
      functions.add(accept);
      
      accountInfo = new JButton("Account Information");
      accountInfo.setFont(newButtonFont);
      //accept.addActionListener(this);
      functions.add(accountInfo);
      
      withdraw = new JButton("Account Withdraw");
      withdraw.setFont(newButtonFont);
      //accept.addActionListener(this);
      functions.add(withdraw);
      
      deposit = new JButton("Account Deposit");
      deposit.setFont(newButtonFont);
      //accept.addActionListener(this);
      functions.add(deposit);
      
      cancel = new JButton("Cancel");
      cancel.setFont(newButtonFont);
      //accept.addActionListener(this);
      functions.add(cancel);
      
      
        one = new JButton(String.valueOf(1));
        two = new JButton(String.valueOf(2));
        three = new JButton(String.valueOf(3));
        keypad.add(one);
        keypad.add(two);
        keypad.add(three);

        
        four = new JButton(String.valueOf(4));
        five = new JButton(String.valueOf(5));
        six = new JButton(String.valueOf(6));
        keypad.add(four);
        keypad.add(five);
        keypad.add(six);

        
        seven = new JButton(String.valueOf(7));
        eight = new JButton(String.valueOf(8));
        nine = new JButton(String.valueOf(9));
        keypad.add(seven);
        keypad.add(eight);
        keypad.add(nine);

        enter = new JButton("Enter");
        keypad.add(enter);
        
        zero = new JButton(String.valueOf(0));
        keypad.add(zero);
        
        clear = new JButton("Clear");
        keypad.add(clear);
       
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
   
   //main 
   public static void main(String[] args){
      ATMTest ATM = new ATMTest();
   }
}