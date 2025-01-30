
package bank.management;
import javax.swing.*;
import java.awt.*;//this has image class
import java.awt.event.*;//action
import java.sql.*;
public class Login extends JFrame implements ActionListener{//to add action to the buttons
    
    JButton login,signup,clear;
    JTextField cardTextField;JPasswordField pinTextField;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);//it will take custom layout
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        //we cannot place an icon on the frame directly
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);//to set the image
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Ostward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
         
        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        //to input entry we need to add a box
        cardTextField =new  JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
         
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField =new  JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        //height left-right height width
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
    }
    //to override actionlistener
    public void actionPerformed(ActionEvent ae){
        //what to do after button is clicked
        if(ae.getSource()==clear)
        {
          cardTextField.setText("");
          pinTextField.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select* from login where cardnumber= '"+cardnumber+"'and pin='"+pinnumber+"'";
            try{
              ResultSet rs=  conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
                
            }catch (Exception e){
                System.out.println(e);
            }
        
        
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}
