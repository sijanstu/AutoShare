package com.sijanstu.autoshare.version3.ui;

import com.sijanstu.autoshare.version3.dto.ipo.IPOUser;

import javax.swing.*;

/**
 *
 * @author Sijan Bhandari
 */
public class UserUI extends javax.swing.JPanel {

    /**
     * Creates new form UserUI
     * @param user
     */
    private IPOUser user;
    public UserUI(IPOUser user) {
        this.user=user;
        initComponents();
        hideUserName(true);
    }
    public void hideUserName(boolean hide){
        if (hide) {
            username.setText(user.getUsername().substring(0, 2) + "***");
        }else {
            username.setText(user.getUsername());
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
        delete = new rojeru_san.rsbutton.RSButtonRound();
        update = new rojeru_san.rsbutton.RSButtonRound();
        username = new RSMaterialComponent.RSButtonMaterialRipple();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        delete.setBackground(new java.awt.Color(255, 204, 204));
        delete.setText("Delete");
        delete.setColorHover(new java.awt.Color(204, 0, 0));
        delete.setColorText(new java.awt.Color(255, 0, 0));
        delete.setFocusPainted(false);
        delete.setFocusable(false);
        delete.setFont(new java.awt.Font("Roboto Bold", 1, 13)); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 204));
        update.setText("Update");
        update.setColorHover(new java.awt.Color(204, 204, 0));
        update.setColorText(new java.awt.Color(153, 153, 0));
        update.setFocusPainted(false);
        update.setFocusable(false);
        update.setFont(new java.awt.Font("Roboto Bold", 1, 13)); // NOI18N
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        username.setBackground(new java.awt.Color(0, 51, 51));
        username.setText("rSButtonMaterialRipple1");
        username.setBackgroundHover(new java.awt.Color(0, 51, 51));
        username.setBorderPainted(false);
        username.setContentAreaFilled(true);
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        username.setFocusPainted(false);
        username.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       //confirm delete
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Delete User", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            //delete user
            if (user.delete()) {
                JOptionPane.showMessageDialog(this, "User deleted successfully");
                NewUserList.newUserList.refresh();
            }else {
                JOptionPane.showMessageDialog(this, "Error deleting user");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       AddUser.main(user);
    }//GEN-LAST:event_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRound delete;
    private javax.swing.JPanel jPanel1;
    private rojeru_san.rsbutton.RSButtonRound update;
    private RSMaterialComponent.RSButtonMaterialRipple username;
    // End of variables declaration//GEN-END:variables
}
