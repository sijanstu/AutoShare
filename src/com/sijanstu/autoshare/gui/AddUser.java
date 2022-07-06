package com.sijanstu.autoshare.gui;

import com.sijanstu.autoshare.AutoShare;
import com.sijanstu.autoshare.Config;
import com.sijanstu.autoshare.entity.User;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    User user;

    public AddUser(User user) {
        this.user = user;
        initComponents();
        compComboBox.removeAllItems();
        AutoShare.companiesList.forEach((comp) -> {
            compComboBox.addItem(comp);
        });
        if (user != null) {
            compComboBox.setSelectedItem(user.getSecurity());
            username.setText(user.getUsername());
            password.setText(user.getPassword());
            crn.setText(user.getCRN());
            pin.setText(user.getPIN());
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

        jPanel1 = new javax.swing.JPanel();
        pin = new RSMaterialComponent.RSTextFieldMaterial();
        username = new RSMaterialComponent.RSTextFieldMaterial();
        password = new RSMaterialComponent.RSTextFieldMaterial();
        crn = new RSMaterialComponent.RSTextFieldMaterial();
        rSButtonRound1 = new rojeru_san.rsbutton.RSButtonRound();
        compComboBox = new rojerusan.RSComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add User");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pin.setPlaceholder("PIN");
        pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinActionPerformed(evt);
            }
        });
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 180, -1));

        username.setPlaceholder("Username");
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 180, -1));

        password.setPlaceholder("Password");
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 180, -1));

        crn.setPlaceholder("CRN");
        crn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crnActionPerformed(evt);
            }
        });
        jPanel1.add(crn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 180, -1));

        rSButtonRound1.setText("Add User");
        rSButtonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRound1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        compComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select DP" }));
        jPanel1.add(compComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pinActionPerformed

    private void crnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crnActionPerformed

    private void rSButtonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRound1ActionPerformed
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
                        p.setProperty(userNumber + ".dp", compComboBox.getSelectedItem().toString());
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
    }//GEN-LAST:event_rSButtonRound1ActionPerformed

    public static void main(User user) {
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddUser(user).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSComboBox compComboBox;
    private RSMaterialComponent.RSTextFieldMaterial crn;
    private javax.swing.JPanel jPanel1;
    private RSMaterialComponent.RSTextFieldMaterial password;
    private RSMaterialComponent.RSTextFieldMaterial pin;
    private rojeru_san.rsbutton.RSButtonRound rSButtonRound1;
    private RSMaterialComponent.RSTextFieldMaterial username;
    // End of variables declaration//GEN-END:variables
}
