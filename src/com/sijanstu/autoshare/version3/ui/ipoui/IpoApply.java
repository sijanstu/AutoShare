/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sijanstu.autoshare.version3.ui.ipoui;

import com.sijanstu.autoshare.version3.dto.ipo.HistoryScript;
import com.sijanstu.autoshare.version3.dto.ipo.Scrip;
import com.sijanstu.autoshare.version3.httprequests.Request;
import com.sijanstu.autoshare.version3.ui.Main;

import java.io.IOException;

/**
 *
 * @author Sijan Bhandari
 */
public class IpoApply extends javax.swing.JPanel {
    private Scrip scrip;
    public IpoApply() {
        initComponents();
    }
    public IpoApply(Scrip scrip) {
        initComponents();
        nameL.setText(scrip.getCompanyName());
        nameS.setText(scrip.getScrip());
        type.setText(scrip.getShareTypeName());
        type1.setText(scrip.getShareGroupName());
        type2.setText(scrip.getSubGroup());
        endDate.setText(scrip.getIssueCloseDate());
        this.scrip=scrip;
        
        if(scrip.getAction()!=null&&scrip.getAction().equals("edit")){
            applyIpoButton.setText("Applied");
            applyIpoButton.setEnabled(false);
        }
        if(scrip.getApplicantFormId()!=null) {
            try {
                HistoryScript historyScript = new Request(Main.currentUser).getHistoryScript(scrip.getApplicantFormId());
                applyIpoButton.setText(historyScript.getStatusName());
                applyIpoButton.setEnabled(false);
            } catch (IOException e) {
                System.out.println("Error in getting history script");
            }
        }
        switch (applyIpoButton.getText()) {
            case "Alloted":
                applyIpoButton.setBackground(new java.awt.Color(0, 255, 0));
                break;
            case "Unverified":
                applyIpoButton.setBackground(new java.awt.Color(255, 255, 0));
                break;
            case "Rejected":
                applyIpoButton.setBackground(new java.awt.Color(255, 0, 0));
                break;
            case "Applied":
                applyIpoButton.setBackground(new java.awt.Color(0, 0, 255));
                break;
            case "Cancelled":
                applyIpoButton.setBackground(new java.awt.Color(255, 0, 255));
                break;
            case "Not Alloted":
                applyIpoButton.setBackground(new java.awt.Color(255, 20, 20));
                break;
            case "Partially Rejected":
                applyIpoButton.setBackground(new java.awt.Color(255, 255, 255));
                break;
            case "Partially Cancelled":
                applyIpoButton.setBackground(new java.awt.Color(255, 255, 255));
                break;
            default:
                applyIpoButton.setBackground(new java.awt.Color(255, 255, 255));
                break;
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

        roundPanel1 = new com.sijanstu.autoshare.version3.ui.RoundPanel();
        nameS = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        endDate = new javax.swing.JLabel();
        type2 = new javax.swing.JLabel();
        nameL = new javax.swing.JLabel();
        applyIpoButton = new RSComponentShade.RSButtonRippleShade();

        setBackground(new java.awt.Color(31, 31, 31));
        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(0, 0, 0));
        roundPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameS.setForeground(new java.awt.Color(255, 255, 255));
        nameS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameS.setText("EHL");
        roundPanel1.add(nameS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 310, 40));

        type.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type.setText("IPO");
        roundPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 70));

        type1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        type1.setForeground(new java.awt.Color(255, 255, 255));
        type1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type1.setText("Ordinary Shares");
        roundPanel1.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 171, 30));

        endDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        endDate.setForeground(new java.awt.Color(255, 255, 255));
        endDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endDate.setText("2022-10-18 5:00 PM ");
        roundPanel1.add(endDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 160, 70));

        type2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        type2.setForeground(new java.awt.Color(255, 255, 255));
        type2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type2.setText("For General Public");
        roundPanel1.add(type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 180, 30));

        nameL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameL.setForeground(new java.awt.Color(255, 255, 255));
        nameL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameL.setText("Eastern Hydropower Ltd. ");
        roundPanel1.add(nameL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 310, 40));

        applyIpoButton.setBackground(new java.awt.Color(153, 255, 153));
        applyIpoButton.setForeground(new java.awt.Color(0, 0, 0));
        applyIpoButton.setText("Apply");
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
        roundPanel1.add(applyIpoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applyIpoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyIpoButtonActionPerformed
        Applying.main(scrip);
    }//GEN-LAST:event_applyIpoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSComponentShade.RSButtonRippleShade applyIpoButton;
    private javax.swing.JLabel endDate;
    private javax.swing.JLabel nameL;
    private javax.swing.JLabel nameS;
    private com.sijanstu.autoshare.version3.ui.RoundPanel roundPanel1;
    public javax.swing.JLabel type;
    private javax.swing.JLabel type1;
    private javax.swing.JLabel type2;
    // End of variables declaration//GEN-END:variables
}
