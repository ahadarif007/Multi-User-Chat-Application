/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatapplication;
//import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.beans.PropertyEditorManager;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ADG
 */
public class StatusClass extends JFrame implements ActionListener {
    
      private JTextArea mainWindow;
      private JTextField typingSpace;
      
      StatusClass()
      {
          //GUI design
          super("This is status Bar");
           mainWindow  = new JTextArea();
           Font f = new Font("Verdana",Font.BOLD,18);
           mainWindow.setFont(f);
        add(new JScrollPane(mainWindow));
        setSize(800,1200);
        setVisible(false);
        mainWindow.setEditable(false);
        typingSpace = new JTextField();
        typingSpace.setBackground(Color.WHITE);
         typingSpace.setFont(f);
        typingSpace.setPreferredSize( new Dimension( 200, 50 ) );
        typingSpace.setBounds(100, 100, 120, 60);
        typingSpace.setEditable(true);
        typingSpace.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent b)
                    {
                        flushMessage(b.getActionCommand());
                        typingSpace.setText("");
                    }
                });
        add(typingSpace,BorderLayout.NORTH);
        
        Date date = new Date();
      }
      
    //set the display to true
      void whileProcessingtheApplication()
      {
          setVisible(true);
      }
      
      //displaying the post on window 
      private void flushMessage(String text)
      {
          SwingUtilities.invokeLater(new Runnable()
          {
              public void run()
              {
                  Date date = new Date();
                  mainWindow.append(date.toString() + " You Posted : "  +text + "\n");
              }
          });
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
