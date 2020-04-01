package javachatapplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*; 
import javax.swing.*; 
/**
 *
 * @author ahada
 */
public class MySqlConnect {
    
     Connection conn = null; 
    public static Connection ConnectDB(){ 
        try{ 
            //loading driver
            Class.forName("com.mysql.jdbc.Driver");
            //connecting user_info database  
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info","root","admin"); 
             System.out.println("driver loaded");
            JOptionPane.showMessageDialog(null,"Connection Made"); 
            return conn; 
        }catch (Exception e){ 
            JOptionPane.showMessageDialog(null,e); 
            return null; 
        } 
    }
    
}
