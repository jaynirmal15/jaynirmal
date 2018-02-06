/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WareHouse;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.IndustryEnterprise;
import Business.Enterprise.InventoryDirectory;
import Business.Enterprise.WareHouseEnterprise;
import Business.Enterprise.WareHouseInventory;
import Business.GlobalWaste;
import Business.Network.Network;
import Business.Organization.WareHouseOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CustomerWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ashis
 */
public class WareHouseInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WareHouseInventoryJpanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private WareHouseOrganization wareHouseOrganization;
    private Enterprise enterprise;
    private EcoSystem business;

    WareHouseInventoryJPanel(JPanel userProcessContainer, UserAccount account, WareHouseOrganization wareHouseOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.account = account;
        this.business = business;
        this.enterprise = (WareHouseEnterprise)enterprise;
        this.userProcessContainer = userProcessContainer;
        populateInventoryTable();
//        popTable();
    }

    
           
    public void populateInventoryTable() {
        
        Map<String, Integer> m1 = new HashMap<String, Integer>();
        Integer revenue = 0;
        Integer temp = 0;

        for (GlobalWaste global : business.getWasteDirectory().getWasteList()) {

            for (WorkRequest wor : enterprise.getWorkQueue().getWorkRequestList()) {
                if (wor instanceof CustomerWorkRequest){
                if (global.getWasteNsme() != null) {
                    if (wor.getWasteName() != null) {
                        if (wor.getWasteName().equals(global.getWasteNsme())) {
                            revenue += ((CustomerWorkRequest)wor).getWasteQuantity();
                        }
                    }
                }
            }

                if (m1.containsKey(global.getWasteNsme())) {
                    temp = m1.get(global.getWasteNsme());
                    m1.remove(global.getWasteNsme());
                    m1.put(global.getWasteNsme(), temp + revenue);

                } else {
                    m1.put(global.getWasteNsme(), revenue);
                }
                revenue = 0;

            }
        }
    
        // System.out.println("enterprise"+enterprise.getName()+ enterprise.getWorkQueue().getWorkRequestList().size());
 
       
        DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
        model.setRowCount(0);
        WareHouseEnterprise a = (WareHouseEnterprise) enterprise;
        InventoryDirectory in = new InventoryDirectory();

        for (GlobalWaste global : business.getWasteDirectory().getWasteList()) {

            for (WorkRequest wor : enterprise.getWorkQueue().getWorkRequestList()) {
//                for(WareHouseInventory war : a.getInventoryDirectory().getInventoryList()){
                    
//                       System.out.println(war.getSellingPrice());
                if (wor.getWasteName() != null) {
                    if (wor.getWasteName().equals(global.getWasteNsme())) {

                        Object[] row = new Object[4];
                        if (wor.getQualityResult() != null) {
                            if (wor.getQualityResult().equals("Approved")) {
                                WareHouseInventory wareInventory = new WareHouseInventory();
                                if (in != null) {
                                    wareInventory.setInventoryName(wor.getWasteName());
                                    wareInventory.setQuanitity(m1.get(global.getWasteNsme()));

                                    in.getInventoryList().add(wareInventory);
                                    
                                }

                                row[0] = wareInventory;
                                row[1] = wareInventory.getQuanitity();
                                row[2] = global.getPrice();
                                row[3] = wareInventory.getSellingPrice();

                                model.addRow(row);
                                break;
                            }
                        }
                    }
                }
//            }
            }
        }

        a.setInventoryDirectory(in);

    }
    public void popTable(){
   DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
        model.setRowCount(0);
        WareHouseEnterprise a = (WareHouseEnterprise) enterprise;
        
int qq=0;
int temp=0;
        for (GlobalWaste global : business.getWasteDirectory().getWasteList()) {
            
            for (WorkRequest wor : enterprise.getWorkQueue().getWorkRequestList()) {
                if(wor instanceof CustomerWorkRequest && wor.getQualityResult().equalsIgnoreCase("Approved")){

                if (wor.getWasteName() != null) {
                    if (wor.getWasteName().equals(global.getWasteNsme())) {

                        Object[] row = new Object[4];
                        if (wor.getQualityResult() != null) {
                            
                            if(a.getInventoryDirectory()==null)
                            {
                                a.setInventoryDirectory(new InventoryDirectory());
                            }
                                WareHouseInventory wi = a.getInventoryDirectory().searchByName(wor.getWasteName());
                                
                                     
                                        qq = ((CustomerWorkRequest) wor).getWasteQuantity()+ wi.getQuanitity();
                                     wi.setQuanitity(qq);

                                row[0] = wi;
                                row[1] = wi.getQuanitity();
                                
                               

                                model.addRow(row);
                                break;
                            
                           // qq=qq+temp;
                        
                        }
                    }
                }
                
            
        }
    }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();

        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recycled Waste name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(inventoryTable);
        if (inventoryTable.getColumnModel().getColumnCount() > 0) {
            inventoryTable.getColumnModel().getColumn(0).setResizable(false);
            inventoryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
