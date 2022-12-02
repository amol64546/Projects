/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc_connection;

/**
 *
 * @author amol
 */
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","oooo9999");
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from customers");             
                while(rs.next()){
                     System.out.println(rs.getString(2));
                }
            con.close();
            st.close();
             
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error to connect with database");
        }
        catch(SQLException e){
            System.out.println("Wrong SQL query ");
        }
        





    }
}
