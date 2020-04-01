package javachatapplication;

import java.net.*;
import java.io.*;
import java.util.*;

public class client_frame extends javax.swing.JFrame 
{
    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    
    //listening to new client
    
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    //adding new client to list
    
    public void userAdd(String data) 
    {
         users.add(data);
    }
    
    //Removing client from list
    
    public void userRemove(String data) 
    {
         mainWindow.append(data + " is now offline.\n");
    }
    
 
    

    //After client disconnect
    
    public void sendDisconnect() 
    {
        String bye = (username + ": :Disconnect");
        try
        {
            writer.println(bye); 
            writer.flush(); 
        } catch (Exception e) 
        {
            mainWindow.append("Could not send Disconnect message.\n");
        }
    }

    //disconnecting 
    
    public void Disconnect() 
    {
        try 
        {
            mainWindow.append("Disconnected.\n");
            sock.close();
        } catch(Exception ex) {
            mainWindow.append("Failed to disconnect. \n");
        }
        isConnected = false;
        typingWindow.setEditable(true);

    }
    
    public client_frame() 
    {
        initComponents();
    }
    
    //editing string to chat
    
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(":");

                     if (data[2].equals(chat)) 
                     {
                        mainWindow.append(data[0] + ": " + data[1] + "\n");
                        mainWindow.setCaretPosition(mainWindow.getDocument().getLength());
                     } 
                     else if (data[2].equals(connect))
                     {
                        mainWindow.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        users.clear();
                     }
                }
           }catch(Exception ex) { }
        }
    }

    //GUI design
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_connect = new javax.swing.JButton();
        b_disconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainWindow = new javax.swing.JTextArea();
        typingWindow = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Client's frame");
        setMinimumSize(new java.awt.Dimension(579, 500));
        setName("client"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        b_connect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_connect.setForeground(new java.awt.Color(51, 204, 0));
        b_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/transfer.png"))); // NOI18N
        b_connect.setText("Connect");
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });
        getContentPane().add(b_connect);
        b_connect.setBounds(10, 30, 113, 33);

        b_disconnect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_disconnect.setForeground(new java.awt.Color(255, 0, 0));
        b_disconnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/disconnect.png"))); // NOI18N
        b_disconnect.setText("Disconnect");
        b_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_disconnectActionPerformed(evt);
            }
        });
        getContentPane().add(b_disconnect);
        b_disconnect.setBounds(400, 30, 129, 33);

        mainWindow.setColumns(20);
        mainWindow.setRows(5);
        jScrollPane1.setViewportView(mainWindow);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 559, 310);
        getContentPane().add(typingWindow);
        typingWindow.setBounds(10, 430, 421, 33);

        sendButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/send.png"))); // NOI18N
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton);
        sendButton.setBounds(440, 430, 117, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/background1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 580, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connectActionPerformed
        if (isConnected == false) 
        {
            

            try 
            {
                //creating sockets and setting up strings 
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":has connected.:Connect");
                writer.flush(); 
                isConnected = true; 
            } 
            catch (Exception ex) 
            {
                mainWindow.append("Cannot Connect! Try Again. \n");
                tf_username.setEditable(true);
            }
            //starting client
            ListenThread();
            
        } else if (isConnected == true) 
        {
            mainWindow.append("You are already connected. \n");
        }
    }//GEN-LAST:event_b_connectActionPerformed
      //disconnecting
    private void b_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_disconnectActionPerformed
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_b_disconnectActionPerformed
       //setting up cursor on display 
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String nothing = "";
        if ((typingWindow.getText()).equals(nothing)) {
            typingWindow.setText("");
            typingWindow.requestFocus();
        } else {
            try {
               writer.println(username + ":" + typingWindow.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                mainWindow.append("Message was not sent. \n");
            }
            typingWindow.setText("");
            typingWindow.requestFocus();
        }

        typingWindow.setText("");
        typingWindow.requestFocus();
    }//GEN-LAST:event_sendButtonActionPerformed
    //start display  
    public static void mainMethod() 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new client_frame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_connect;
    private javax.swing.JButton b_disconnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mainWindow;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField typingWindow;
    // End of variables declaration//GEN-END:variables
}
