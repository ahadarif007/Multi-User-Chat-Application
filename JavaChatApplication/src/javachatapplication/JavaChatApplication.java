/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatapplication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author ADG
 */
public class JavaChatApplication extends JFrame {

    LoginForm lf;
    public void main1() throws ClassNotFoundException, InterruptedException, IOException {
       
        
       StatusClass s = new StatusClass();
       JFrame J = new JFrame();
       J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       J.setSize(800,600);
       J.setVisible(true);
       Font f = new Font("sans-serif", Font.PLAIN, 24);
       UIManager.put("MenuBar.font", f);
       UIManager.put("Menu.font", f);
       UIManager.put("MenuItem.font", f);
       JMenuBar JB = new JMenuBar();
       JMenu open = new JMenu("Open");
       
       JB.add(open);
       JMenuItem frame = new JMenuItem("Open Status Option");
       open.add(frame);
       
       JMenuItem frameSecond = new JMenuItem("Open chat option");
       open.add(frameSecond);
       
        
       J.setJMenuBar(JB);
       frame.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            J.dispose();
                  // TODO code application logic here
           
       //ServerClass s = new ServerClass();
       s.whileProcessingtheApplication();
       //DesignClass d = new DesignClass();
       //StatusClass st = new StatusClass();
       s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //s.whileProcessingtheApplication();
        
           }
       });
       
       frameSecond.addActionListener(new ActionListener() {
          
           
           public void actionPerformed(ActionEvent e) {
               
               subClass s1 = new subClass();
               Thread t1 = new Thread(s1);
               t1.start();
               J.dispose();
           
           };
       
      
        
    }
       );
   
}

  
}