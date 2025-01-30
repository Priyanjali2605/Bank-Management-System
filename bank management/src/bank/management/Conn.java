
package bank.management;

import java.sql.*;



public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
       //because we use sql therefore we need try and catch 
        //connection string
         c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Guddan@26");
        s =c.createStatement();
         
        
        
        }catch(Exception e)
        {
           System.out.print(e);
        }
    }
    
}
