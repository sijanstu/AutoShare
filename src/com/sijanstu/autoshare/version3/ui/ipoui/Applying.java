package com.sijanstu.autoshare.version3.ui.ipoui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.sijanstu.autoshare.version3.dto.ipo.IPOUser;
import com.sijanstu.autoshare.version3.dto.ipo.Scrip;
import com.sijanstu.autoshare.version3.exceptions.CredentialsException;
import org.jsoup.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/**
 * @author Sijan Bhandari
 */
public class Applying extends javax.swing.JFrame {
    private Scrip scrip;
    ArrayList<UserSelection> userSelections = new ArrayList<>();

    public Applying() {
        initComponents();
        setTheme();

    }

    public Applying(Scrip scrip) {
        initComponents();
        nameL2.setText(scrip.getCompanyName());
        this.scrip = scrip;
        setTheme();
        ArrayList<IPOUser> users = IPOUser.getIPOUsers();
        int location = 50;
        for (IPOUser user : users) {
            UserSelection userSelection = new UserSelection(user);
            userSelections.add(userSelection);
            panel.add(userSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, location, -1, -1));
            location += 60;
        }
        panel.revalidate();
    }

    void setTheme() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ApplyIPO.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlatLaf.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.sijanstu.autoshare.version3.ui.RoundPanel();
        nameL1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        nameL3 = new javax.swing.JLabel();
        selectAll = new javax.swing.JCheckBox();
        applyIpoButton = new RSComponentShade.RSButtonRippleShade();
        kitta = new javax.swing.JTextField();
        nameL2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Applying");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        roundPanel1.setBackground(new java.awt.Color(0, 0, 0));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameL1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameL1.setForeground(new java.awt.Color(255, 255, 255));
        nameL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameL1.setText("Applied Kitta Number (Multiple of 10)");
        roundPanel1.add(nameL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 326, 337, 39));

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(51, 51, 51));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameL3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nameL3.setForeground(new java.awt.Color(255, 255, 255));
        nameL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameL3.setText("Select Users");
        panel.add(nameL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 53));

        selectAll.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectAll.setForeground(new java.awt.Color(255, 255, 255));
        selectAll.setText("Select All");
        selectAll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectAll.setOpaque(false);
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });
        panel.add(selectAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 150, 50));

        jScrollPane1.setViewportView(panel);

        roundPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 250));

        applyIpoButton.setBackground(new java.awt.Color(0, 204, 0));
        applyIpoButton.setText("Apply IPO");
        applyIpoButton.setBgHover(new java.awt.Color(102, 255, 102));
        applyIpoButton.setBgShade(new java.awt.Color(204, 0, 0));
        applyIpoButton.setFgHover(new java.awt.Color(0, 0, 0));
        applyIpoButton.setFgText(new java.awt.Color(0, 0, 0));
        applyIpoButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        applyIpoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyIpoButtonActionPerformed(evt);
            }
        });
        roundPanel1.add(applyIpoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 431, 131, 62));

        kitta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kitta.setForeground(new java.awt.Color(255, 255, 255));
        kitta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kitta.setText("10");
        kitta.setOpaque(false);
        kitta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kittaActionPerformed(evt);
            }
        });
        roundPanel1.add(kitta, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 372, 152, 46));

        nameL2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nameL2.setForeground(new java.awt.Color(255, 255, 255));
        nameL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameL2.setText("Company Name");
        roundPanel1.add(nameL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 337, 53));

        getContentPane().add(roundPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void applyIpoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyIpoButtonActionPerformed
        try {
            if (kitta.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Kitta");
            } else if (Integer.parseInt(kitta.getText()) % 10 != 0) {
                JOptionPane.showMessageDialog(this, "Kitta Number Must be Multiple of 10");
            }
            userSelections.forEach((userSelection) -> {
                if (userSelection.isSelected()) {
                   // System.out.println("Selected User: " + userSelection.getUser().getUsername());
                    Apply apply = new Apply();
                    JDialog dialog;
                    JOptionPane pane;
                    try {
                        Connection.Response response = apply.applyIPO(userSelection.getUser(), kitta.getText(), scrip.getCompanyShareId().toString());
                        if (response.statusCode() < 300 && response.statusCode() >= 200) {
                            dialog = new JDialog(this, "Success", false);
                            pane = new JOptionPane("IPO Applied Successfully" + " for" + userSelection.getUser().getUsername(), JOptionPane.INFORMATION_MESSAGE);
                            dialog.setContentPane(pane);
                            dialog.pack();
                            dialog.setVisible(true);
                            dialog.setAlwaysOnTop(true);
                            dialog.setLocationRelativeTo(this);
                        } else {
                            //already applied or some error
                            //dialog with error message
                            //print response body
                            System.out.println(response.body());
                            dialog = new JDialog(this, "Error", false);
                            pane = new JOptionPane("Error in Applying IPO for " + scrip.getCompanyName() + "BY " + userSelection.getUser().getUsername(), JOptionPane.ERROR_MESSAGE);
                            dialog.setContentPane(pane);
                            dialog.pack();
                            dialog.setVisible(true);
                            dialog.setAlwaysOnTop(true);
                            dialog.setLocationRelativeTo(this);
                        }
                        //close dialog after 2 seconds
                        Timer timer =new Timer(2000, (ActionEvent e) -> {
                            dialog.dispose();
                        });
                        timer.setRepeats(false);
                        timer.start();
                        timer.setCoalesce(true);
                    } catch (IOException | CredentialsException e) {
                        JOptionPane.showMessageDialog(this, e.toString());
                    }
                }
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_applyIpoButtonActionPerformed

    private void kittaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kittaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kittaActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        userSelections.forEach((userSelection) -> {
            userSelection.setSelected(selectAll.isSelected());
        });
    }//GEN-LAST:event_selectAllActionPerformed

    /**
     * @param scrip takes scrip to be applied
     */
    public static void main(Scrip scrip) {
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Applying.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Applying(scrip).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSComponentShade.RSButtonRippleShade applyIpoButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kitta;
    private javax.swing.JLabel nameL1;
    private javax.swing.JLabel nameL2;
    private javax.swing.JLabel nameL3;
    private javax.swing.JPanel panel;
    private com.sijanstu.autoshare.version3.ui.RoundPanel roundPanel1;
    private javax.swing.JCheckBox selectAll;
    // End of variables declaration//GEN-END:variables
}