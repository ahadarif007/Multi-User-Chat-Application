package javachatapplication;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
import java.sql.*;
import javachatapplication.LoginForm;
import javax.swing.*;
import java.util.*;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.*; 


/**
 *
 * @author ADG
 */
public class CreateidForm extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    /**
     * Creates new form CreateidForm
     */
   
    public CreateidForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mailId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        password2 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(620, 515));
        setMinimumSize(new java.awt.Dimension(620, 515));
        setPreferredSize(new java.awt.Dimension(615, 490));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("USER ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 149, 73, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 190, 121, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 310, 121, 17);

        userId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdActionPerformed(evt);
            }
        });
        getContentPane().add(userId);
        userId.setBounds(183, 149, 160, 30);

        firstName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });
        getContentPane().add(firstName);
        firstName.setBounds(183, 191, 150, 30);

        SaveButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/notes.png"))); // NOI18N
        SaveButton.setText("Create New Account");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton);
        SaveButton.setBounds(190, 400, 260, 62);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/login.png"))); // NOI18N
        jButton2.setText("Log In");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(180, 80, 100, 34);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Already have an account?");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 86, 191, 20);

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(183, 310, 200, 30);

        jLabel5.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        jLabel5.setText("                GUI Based Chat Application");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 11, 540, 62);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Last Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 230, 121, 17);

        lastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });
        getContentPane().add(lastName);
        lastName.setBounds(183, 230, 150, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("email address");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 270, 121, 17);

        mailId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailIdActionPerformed(evt);
            }
        });
        getContentPane().add(mailId);
        mailId.setBounds(183, 270, 300, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Retype Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 340, 121, 20);

        password2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });
        getContentPane().add(password2);
        password2.setBounds(183, 350, 200, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/contact.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(140, 270, 24, 24);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/users.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(141, 149, 24, 24);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/user-name.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(141, 191, 24, 24);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/user-name.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(141, 226, 24, 24);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/key-tool.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(140, 310, 24, 24);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/key-tool.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(140, 340, 24, 24);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javachatapplication/background2.jpg"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 600, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        LoginForm l = new LoginForm();
        l.main2();
        dispose();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        //connecting database 
           conn=MySqlConnect.ConnectDB();
        //preparing string
        String sql="insert  into user_data values(?,?,?,?,?);";
        //inserting value throw query 
        try{
            //getting data ->-> 1,2,3,4,5->->?,?,?,?,?
            pst= conn.prepareStatement(sql);
            pst.setString(1,userId.getText());
            pst.setString(2,firstName.getText());
            pst.setString(3,lastName.getText());
            pst.setString(4,mailId.getText());
            pst.setString(5,password.getText());
            if(!(password.getText().matches(password2.getText())))
            {
                JOptionPane.showMessageDialog(null,"both password not matched");
                password.setText("");
                password2.setText("");
                
            }
                
            
            else
            {
                 pst.executeUpdate();
                 JOptionPane.showMessageDialog(null,"welcome , new id created successfully");
                 LoginForm l = new LoginForm();
                 l.main2();
                 dispose();
            }
        }
        catch(Exception e)
                {
                JOptionPane.showMessageDialog(null,e);
                } 
       /** 
        LoginForm l = new LoginForm();
        l.main2();
        dispose();**/
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void userIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_userIdActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameActionPerformed

    private void mailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailIdActionPerformed

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password2ActionPerformed

    


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       
           
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateidForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField firstName;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField mailId;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password2;
    private javax.swing.JTextField userId;
    // End of variables declaration//GEN-END:variables
}