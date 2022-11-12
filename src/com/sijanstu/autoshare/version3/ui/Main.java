package com.sijanstu.autoshare.version3.ui;

import com.sijanstu.autoshare.version3.ui.ipoui.ApplyIPO;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.sijanstu.autoshare.version3.Config;
import com.sijanstu.autoshare.version3.dto.ipo.Capital;
import com.sijanstu.autoshare.version3.dto.User;
import com.sijanstu.autoshare.version3.dto.ipo.IPOUser;
import com.sijanstu.autoshare.version3.exceptions.CredentialsException;
import com.sijanstu.autoshare.version3.httprequests.Request;
import com.sijanstu.autoshare.version3.themes.Theme;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.Color;

/**
 * @author Sijan Bhandari
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<IPOUser> ipoUsers = new ArrayList<>();
    public static ArrayList<Capital> capitals = new ArrayList<>();
    public static User currentUser;
    boolean first = true;
    String currentUsername = "";

    public Main() {
        initComponents();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlatLaf.updateUI();
        refresh();
        new InitData().start();
    }

    class InitData extends Thread {

        @Override
        public void run() {
            getCapitals();
            updatePortfolio();
            first = false;
        }
    }

    private void getCapitals() {
        try {
            capitals.addAll(Arrays.asList(new Request(null).getCapitals()));
        } catch (IOException e) {
            System.out.println("Error getting capitals" + e.getMessage());
        }
    }

    private void updatePortfolio() {
        String username = Objects.requireNonNull(usersCombo.getSelectedItem()).toString();
        //System.out.println(username);
        users.forEach((u) -> {
            if (u.getUsername().equals(username)) {
                currentUser = u;
            }
        });

            new Thread(() -> {
                try {
                    currentUser = new Request(currentUser).login();
                    portfolio.addPortfolio(currentUser.getPortfolio());
                } catch (IOException e) {
                    System.out.println("Error updating portfolio" + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error logging in");
                } catch (CredentialsException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }
            }).start();

        //System.out.println(currentUser);

    }

    void refresh() {
    new Thread(() -> {
        File file = new File(Config.PROPERIES_PATH);
        if (file.exists()) {
            try {
                Properties p = new Properties();
                p.load(new FileReader(file));
                int i = 1;
                usersCombo.removeAllItems();
                users.clear();
                while (true) {
                    String userNumber = "user" + i;
                    if (p.containsKey(userNumber + ".username")) {
                        User user = new User();
                        user.setUsername(p.getProperty(userNumber + ".username"));
                        user.setPassword(p.getProperty(userNumber + ".password"));
                        String securityName = p.getProperty(userNumber + ".dp");
                        String dpId = p.getProperty(userNumber + ".dpId");
                        user.setBranch(Integer.parseInt(dpId));
                        IPOUser ipoUser = new IPOUser();
                        ipoUser.setUsername(p.getProperty(userNumber + ".username"));
                        ipoUser.setPassword(p.getProperty(userNumber + ".password"));
                        ipoUser.setCRN(p.getProperty(userNumber + ".crn"));
                        ipoUser.setPIN(p.getProperty(userNumber + ".pin"));
                        ipoUser.setSecurity(p.getProperty(userNumber + ".dp"));
                        ipoUsers.add(ipoUser);
                        users.add(user);
                        usersCombo.addItem(user.getUsername());
                        i++;
                    } else {
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        currentUsername = Objects.requireNonNull(usersCombo.getSelectedItem()).toString();
    }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        roundPanel1 = new com.sijanstu.autoshare.version3.ui.RoundPanel();
        jPanel1 = new javax.swing.JPanel();
        portfolio = new com.sijanstu.autoshare.version3.ui.portfolio.Portfolio();
        headPanel = new javax.swing.JPanel();
        logoText = new javax.swing.JLabel();
        manageUserButton = new RSComponentShade.RSButtonRippleShade();
        usersCombo = new javax.swing.JComboBox<>();
        applyIpoButton = new RSComponentShade.RSButtonRippleShade();
        themechanger = new javax.swing.JCheckBox();
        profile = new RSComponentShade.RSButtonRippleShade();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoShare 3.0");
        setType(java.awt.Window.Type.POPUP);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(0, 255, 51));
        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(portfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        headPanel.setBackground(new java.awt.Color(0, 0, 0));

        logoText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoText.setForeground(new java.awt.Color(223, 242, 249));
        logoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoText.setText("AutoShare 3.0");

        manageUserButton.setBackground(new java.awt.Color(0, 0, 0));
        manageUserButton.setText("Manage Users");
        manageUserButton.setBgHover(new java.awt.Color(102, 255, 102));
        manageUserButton.setBgShade(new java.awt.Color(204, 0, 0));
        manageUserButton.setFgHover(new java.awt.Color(0, 0, 0));
        manageUserButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        manageUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserButtonActionPerformed(evt);
            }
        });

        usersCombo.setBackground(new java.awt.Color(0, 0, 0));
        usersCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usersCombo.setForeground(new java.awt.Color(255, 255, 255));
        usersCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        usersCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 51)));
        usersCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersComboActionPerformed(evt);
            }
        });
        usersCombo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                usersComboPropertyChange(evt);
            }
        });

        applyIpoButton.setBackground(new java.awt.Color(0, 0, 0));
        applyIpoButton.setText("Apply IPO");
        applyIpoButton.setBgHover(new java.awt.Color(102, 255, 102));
        applyIpoButton.setBgShade(new java.awt.Color(204, 0, 0));
        applyIpoButton.setFgHover(new java.awt.Color(0, 0, 0));
        applyIpoButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        applyIpoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyIpoButtonActionPerformed(evt);
            }
        });

        themechanger.setSelected(true);
        themechanger.setText("Dark Theme");
        themechanger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themechangerActionPerformed(evt);
            }
        });

        profile.setBackground(new java.awt.Color(0, 0, 0));
        profile.setText("Profile");
        profile.setBgHover(new java.awt.Color(102, 255, 102));
        profile.setBgShade(new java.awt.Color(204, 0, 0));
        profile.setFgHover(new java.awt.Color(0, 0, 0));
        profile.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addComponent(logoText, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(themechanger, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usersCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyIpoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(manageUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applyIpoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usersCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themechanger, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(roundPanel1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (portfolio.getBounds().getY() < 10) {
           // System.out.println("need menu");
        }
    }//GEN-LAST:event_formComponentResized

    private void themechangerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themechangerActionPerformed
        try {
            if (themechanger.isSelected()) {
                new Theme().setDarkTheme(true);
                changeTheme(true);
            } else {
                new Theme().setDarkTheme(false);
                changeTheme(false);
            }
        } catch (UnsupportedLookAndFeelException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlatLaf.updateUI();
    }//GEN-LAST:event_themechangerActionPerformed

    private void applyIpoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyIpoButtonActionPerformed
    ApplyIPO.main(null);
    }//GEN-LAST:event_applyIpoButtonActionPerformed

    private void usersComboPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_usersComboPropertyChange

    }//GEN-LAST:event_usersComboPropertyChange

    private void usersComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersComboActionPerformed
        if (!first) {
            if (!usersCombo.getSelectedItem().toString().equals(currentUsername)) {
               // System.out.println("pressed");
                currentUsername = usersCombo.getSelectedItem().toString();
                new InitData().start();
            }
        }
    }//GEN-LAST:event_usersComboActionPerformed

    private void manageUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserButtonActionPerformed
        NewUserList.main(null);
    }//GEN-LAST:event_manageUserButtonActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
     Profile.main(currentUser);
    }//GEN-LAST:event_profileActionPerformed
    void changeTheme(boolean isDark) {
        if (isDark) {
            headPanel.setBackground(Color.WHITE);
            logoText.setForeground(Color.BLACK);
            themechanger.setForeground(Color.BLACK);
            usersCombo.setForeground(Color.BLACK);
            usersCombo.setBackground(Color.WHITE);
            manageUserButton.setBackground(Color.WHITE);
            manageUserButton.setFgText(Color.BLACK);
            applyIpoButton.setBackground(Color.WHITE);
            applyIpoButton.setFgText(Color.BLACK);
        } else {
            headPanel.setBackground(Color.BLACK);
            logoText.setForeground(Color.WHITE);
            themechanger.setForeground(Color.WHITE);
            usersCombo.setForeground(Color.WHITE);
            usersCombo.setBackground(Color.BLACK);
            manageUserButton.setBackground(Color.BLACK);
            manageUserButton.setFgText(Color.WHITE);
            applyIpoButton.setBackground(Color.BLACK);
            applyIpoButton.setFgText(Color.WHITE);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSComponentShade.RSButtonRippleShade applyIpoButton;
    private javax.swing.JPanel headPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoText;
    private RSComponentShade.RSButtonRippleShade manageUserButton;
    private com.sijanstu.autoshare.version3.ui.portfolio.Portfolio portfolio;
    private RSComponentShade.RSButtonRippleShade profile;
    private com.sijanstu.autoshare.version3.ui.RoundPanel roundPanel1;
    private javax.swing.JCheckBox themechanger;
    private javax.swing.JComboBox<String> usersCombo;
    // End of variables declaration//GEN-END:variables
}
