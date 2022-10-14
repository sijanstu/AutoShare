package com.sijanstu.autoshare.version3.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.sijanstu.autoshare.version3.Config;
import com.sijanstu.autoshare.version3.dto.ipo.Capital;
import com.sijanstu.autoshare.version3.dto.ipo.IPOUser;
import com.sijanstu.autoshare.version3.httprequests.Request;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan
 */
public class AddUser extends javax.swing.JFrame {
static File file = new File(Config.PROPERIES_PATH);
    /**
     * Creates new form AddUser
     *
     * @param user
     */
    IPOUser user;
    Capital[] capitals;
    public AddUser(IPOUser user)  {
        this.user = user;
        initComponents();
        compComboBox.removeAllItems();
        capitals = new Capital[0];
        try {
            capitals = new Request(null).getCapitals();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error while fetching capitals");
        }
        for (Capital capital : capitals) {
            compComboBox.addItem(capital.getName());
        }
        if (user != null) {
            compComboBox.setSelectedItem(user.getSecurity());
            username.setText(user.getUsername());
            password.setText(user.getPassword());
            crn.setText(user.getCRN());
            pin.setText(user.getPIN());
        }
        setDark(true);
    }
    public void setDark(boolean dark) {
        try {
            if (dark) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                FlatLaf.updateUI();
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
                FlatLaf.updateUI();
            }
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compComboBox = new javax.swing.JComboBox<>();
        pin = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        crn = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add User");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        compComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        compComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(compComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 280, 39));

        pin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 210, 43));

        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 210, 43));

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 210, 43));

        crn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(crn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 210, 43));

        submit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submit.setText("Add User");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 210, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("PIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 100, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("DP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 70, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 100, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 100, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("CRN");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 100, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add User");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 440, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       if (username.getText().equals("") || password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "You must enter username and password");
        } else {
            try {
                Properties p = new Properties();
                if (file.exists()) {
                    p.load(new FileReader(file));
                }
                int i = 1;
                String userNumber;
                if (user != null) {
                    while (true) {
                        userNumber = "user" + i;
                        if (p.containsKey(userNumber + ".username")) {
                            if (!p.getProperty(userNumber + ".username").equals(user.getUsername())) {
                                i++;
                                continue;
                            }
                        }
                        Integer dpId = 128;
                        for (Capital capital : capitals) {
                            if (capital.getName().equals(compComboBox.getSelectedItem())) {
                                dpId = capital.getId();
                                break;
                            }
                        }
                        p.setProperty(userNumber + ".dp", compComboBox.getSelectedItem().toString());
                        p.setProperty(userNumber + ".dpId", dpId.toString());
                        p.setProperty(userNumber + ".username", username.getText());
                        p.setProperty(userNumber + ".password", password.getText());
                        p.setProperty(userNumber + ".crn", crn.getText());
                        p.setProperty(userNumber + ".pin", pin.getText());
                        p.store(new FileWriter(file), "updated User: " + username.getText());
                        UserList.refresh();
                        break;
                    }
                } else {
                    while (true) {
                        userNumber = "user" + i;
                        if (p.containsKey(userNumber + ".username")) {
                            i++;
                            System.out.println(i);
                            continue;
                        }
                        p.setProperty(userNumber + ".dp", compComboBox.getSelectedItem().toString());
                        p.setProperty(userNumber + ".username", username.getText());
                        p.setProperty(userNumber + ".password", password.getText());
                        p.setProperty(userNumber + ".crn", crn.getText());
                        p.setProperty(userNumber + ".pin", pin.getText());
                        p.store(new FileWriter(file), "Added User: " + username.getText());
                        UserList.refresh();
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
    }//GEN-LAST:event_submitActionPerformed

    public static void main(IPOUser user) {
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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddUser(user).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> compComboBox;
    private javax.swing.JTextField crn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField password;
    private javax.swing.JTextField pin;
    private javax.swing.JButton submit;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
