/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WareHouse;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.WareHouseOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.QualityAssuarance.QualityAssuranceInventoryJPanel;

/**
 *
 * @author ashis
 */
public class WareHouseWorkAreaJPanel extends javax.swing.JPanel {

    
    private JPanel userProcessContainer;
    private UserAccount account;
    private WareHouseOrganization wareHouseOrganization;
    private Enterprise enterprise;
    private EcoSystem business;

    public WareHouseWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, WareHouseOrganization wareHouseOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.enterprise = enterprise;
        this.wareHouseOrganization = wareHouseOrganization;

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wareHouseInventoryJButton = new javax.swing.JButton();
        GlobalWasteJButton = new javax.swing.JButton();
        AcceptIndustryJbutton = new javax.swing.JButton();
        myInventoryJbutton = new javax.swing.JButton();
        industryAnaluticsJButton = new javax.swing.JButton();

        wareHouseInventoryJButton.setText("WareHouse Inventory");
        wareHouseInventoryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wareHouseInventoryJButtonActionPerformed(evt);
            }
        });

        GlobalWasteJButton.setText("Create global Waste");
        GlobalWasteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GlobalWasteJButtonActionPerformed(evt);
            }
        });

        AcceptIndustryJbutton.setText("AcceptIndustryRequest");
        AcceptIndustryJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptIndustryJbuttonActionPerformed(evt);
            }
        });

        myInventoryJbutton.setText("MyInventory");
        myInventoryJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myInventoryJbuttonActionPerformed(evt);
            }
        });

        industryAnaluticsJButton.setText("IndustryAnalytics");
        industryAnaluticsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryAnaluticsJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AcceptIndustryJbutton)
                .addGap(140, 140, 140))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(wareHouseInventoryJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(GlobalWasteJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(industryAnaluticsJButton)
                            .addComponent(myInventoryJbutton))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(wareHouseInventoryJButton)
                .addGap(18, 18, 18)
                .addComponent(GlobalWasteJButton)
                .addGap(18, 18, 18)
                .addComponent(AcceptIndustryJbutton)
                .addGap(18, 18, 18)
                .addComponent(myInventoryJbutton)
                .addGap(35, 35, 35)
                .addComponent(industryAnaluticsJButton)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void industryAnaluticsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryAnaluticsJButtonActionPerformed
 IndustryAnalyticsJPanel IndustryAnalyticsJPanel = new IndustryAnalyticsJPanel(userProcessContainer, account, wareHouseOrganization, enterprise, business);
        userProcessContainer.add("IndustryAnalyticsJPanel", IndustryAnalyticsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);        
// TODO add your handling code here:
    }//GEN-LAST:event_industryAnaluticsJButtonActionPerformed

    private void wareHouseInventoryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wareHouseInventoryJButtonActionPerformed
       WareHouseInventoryJPanel WareHouseInventoryJPanel = new WareHouseInventoryJPanel(userProcessContainer, account, wareHouseOrganization, enterprise, business);
        userProcessContainer.add("WareHouseInventoryJPanel", WareHouseInventoryJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_wareHouseInventoryJButtonActionPerformed

    private void GlobalWasteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GlobalWasteJButtonActionPerformed
  CreateWasteJPanel CreateWasteJPanel = new CreateWasteJPanel(userProcessContainer, account, wareHouseOrganization, enterprise, business);
        userProcessContainer.add("CreateWasteJPanel", CreateWasteJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_GlobalWasteJButtonActionPerformed

    private void AcceptIndustryJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptIndustryJbuttonActionPerformed
      AcceptIndustryRequestJPanel AcceptIndustryRequestJPanel = new AcceptIndustryRequestJPanel(userProcessContainer, account, wareHouseOrganization, enterprise, business);
        userProcessContainer.add("AcceptIndustryRequestJPanel", AcceptIndustryRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_AcceptIndustryJbuttonActionPerformed

    private void myInventoryJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myInventoryJbuttonActionPerformed
     MyInventoryJPanel MyInventoryJPanel = new MyInventoryJPanel(userProcessContainer, account, wareHouseOrganization, enterprise, business);
        userProcessContainer.add("MyInventoryJPanel", MyInventoryJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_myInventoryJbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptIndustryJbutton;
    private javax.swing.JButton GlobalWasteJButton;
    private javax.swing.JButton industryAnaluticsJButton;
    private javax.swing.JButton myInventoryJbutton;
    private javax.swing.JButton wareHouseInventoryJButton;
    // End of variables declaration//GEN-END:variables
}