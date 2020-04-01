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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.beans.PropertyEditorManager;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public  class ServerClass extends JFrame implements ActionListener {
     // private JTextArea mainWindowForPerson;
     // private JTextField typingSpaceForPerson;
      private ObjectOutputStream[] output;
      private ObjectInputStream[] input;
      private Socket programConnection;
      private ServerSocket server;
      private JTextArea mainWindow;
      private JTextField typingSpace;
      private int client=0;
     // private Button chatOption,writeOption;

    public ServerClass() throws ClassNotFoundException, InterruptedException
    {
       
        super("This is the Server");
        Font f = new Font("Verdana",Font.BOLD,18);
        mainWindow  = new JTextArea();
        mainWindow.setFont(f);
        add(new JScrollPane(mainWindow));
        setSize(400,900);
        setVisible(true);
        mainWindow.setEditable(false);
        typingSpace = new JTextField();
        typingSpace.setEditable(false);
        typingSpace.setFont(f);
        typingSpace.setPreferredSize( new Dimension( 200, 50 ) );
        //typingSpace.setSize(12, 23);
        typingSpace.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent b)
                    {
                        try {
                            //showMessage(b.getActionCommand());
                            flushMessage(b.getActionCommand());
                            typingSpace.setText("");
                        } catch (IOException ex) {
                            Logger.getLogger(ServerClass.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
        add(typingSpace,BorderLayout.SOUTH);
       
     
        
    }
    
    public void setvi()
    {
        setVisible(true);
    }
    
public  void whileProcessingtheApplication1() throws ClassNotFoundException, InterruptedException, IOException
{
   

        
        server = new ServerSocket(4563,3);
 
        try
    {
        beforeChatting();
        //whileSettingupStreams();
      //  whileBeingConnected();
        
    }
        catch(EOFException eo)
    {
        printText("The connection is ended");
        eo.printStackTrace();
    }
        finally
                {
                    endEverything();
                }
    }
  
private void runThread(Socket conn,int client) throws IOException, ClassNotFoundException
{
    int i=client;
    whileSettingupStreams(i);
    whileBeingConnected(i);
    //endEverything();
}

private void beforeChatting() throws IOException
{
   // System.out.println("Please wait . . .");
    printText("Waiting for the connection");
    while(true)
    {
    programConnection = server.accept();
    client++;
//printText("There is a connection");
        Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                runThread(programConnection,client);
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            } catch (IOException ex) {
                Logger.getLogger(ServerClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    t.start();
    }
}

private void whileSettingupStreams(int i) throws IOException
{
    
    output[i] = new ObjectOutputStream(programConnection.getOutputStream());
    output[i].flush();
    input[i] = new ObjectInputStream(programConnection.getInputStream());
}

private void whileBeingConnected(int i) throws IOException, ClassNotFoundException
{
    printText("A client is connected");
    String text = null;
    permissionToType(true);
    while(text != "end")
    {
        
        System.out.println("\n");
        printText((String) input[i].readObject());
        
    }
            
}

private void endEverything() throws IOException
{
    int i= client;
    input[i].close();
    output[i].close();
    programConnection.close();
}

private void flushMessage(String text) throws IOException 
{
   
    for(int i=0;i<client;i++)
    {
    output[i].writeObject("\nServer " + programConnection.getPort() + text);
    output[i].flush();
    //printText("\nServer : " + text);
    
    }
    
    printText("\nServer : " + text);
}

private void printText(final String text)
{
    SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
          mainWindow.append(text);
        }
    }
    );
 
}


private void permissionToType(boolean b)
{
    SwingUtilities.invokeLater(new Runnable(){
        public void run()
        {
            typingSpace.setEditable(b);
        }
    });
}
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
