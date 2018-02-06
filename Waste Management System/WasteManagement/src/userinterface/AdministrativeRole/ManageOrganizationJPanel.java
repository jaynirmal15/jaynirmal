/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.IndustryEnterprise;
import Business.Enterprise.LogisticsEnterprise;
import Business.Enterprise.QualityAssuarance;
import Business.Enterprise.WareHouseEnterprise;
import Business.Enterprise.WasteProviderEnterprise;
import Business.Organization.CustomerOrganisation;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.WorkQueue.CustomerWorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jay
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private Enterprise enterprise;
    private JPanel userProcessContainer;
    private CustomerOrganisation customerOrganisation;

    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.customerOrganisation = customerOrganisation;

        populateTable();
        populateCombo();
//        populatecCombo();
        populateComb();
        
    }

    private void populateComb() {
        organizationJComboBox.removeAllItems();
        for (Type type : Organization.Type.values()) {
            if (!type.getValue().equals(Type.Admin.getValue())) {
                if ((enterprise instanceof WasteProviderEnterprise)) {
                    if (!type.getValue().equals(Type.Industry.getValue()) && !type.getValue().equals(Type.Invertory.getValue()) && !type.getValue().equals(Type.QualityAssuarance.getValue()) && !type.getValue().equals(Type.Logistics.getValue()) && !type.getValue().equals(Type.WareHouse.getValue()) && !type.getValue().equals(Type.WasteProvider.getValue()) && !type.getValue().equals(Type.Manufacturer.getValue())) {
                        organizationJComboBox.addItem(type);
                        typeComboBox.setEnabled(true);
                        nameTextField.setEnabled(true);
                        

                    }
                }
                
                else if ((enterprise instanceof LogisticsEnterprise)) {
                    if (!type.getValue().equals(Type.Industry.getValue()) && !type.getValue().equals(Type.Invertory.getValue()) && !type.getValue().equals(Type.QualityAssuarance.getValue()) && !type.getValue().equals(Type.Customer.getValue()) && !type.getValue().equals(Type.WareHouse.getValue()) && !type.getValue().equals(Type.WasteProvider.getValue()) && !type.getValue().equals(Type.Manufacturer.getValue())) {
                        organizationJComboBox.addItem(type);
                        typeComboBox.setEnabled(false);
                        nameTextField.setEnabled(false);
                    }
                } 
                else if ((enterprise instanceof IndustryEnterprise)) {
                    if (!type.getValue().equals(Type.Logistics.getValue()) && !type.getValue().equals(Type.Invertory.getValue()) && !type.getValue().equals(Type.QualityAssuarance.getValue()) && !type.getValue().equals(Type.Customer.getValue()) && !type.getValue().equals(Type.WareHouse.getValue()) && !type.getValue().equals(Type.WasteProvider.getValue()) ) {
                        organizationJComboBox.addItem(type);
                        typeComboBox.setEnabled(false);
                        nameTextField.setEnabled(false);

                    }
                } 
                else if ((enterprise instanceof WareHouseEnterprise)) {
                    if (!type.getValue().equals(Type.Logistics.getValue()) && !type.getValue().equals(Type.Invertory.getValue()) && !type.getValue().equals(Type.QualityAssuarance.getValue()) && !type.getValue().equals(Type.Customer.getValue()) && !type.getValue().equals(Type.Industry.getValue()) && !type.getValue().equals(Type.WasteProvider.getValue()) && !type.getValue().equals(Type.Manufacturer.getValue())) {
                        organizationJComboBox.addItem(type);
                        typeComboBox.setEnabled(false);
                        nameTextField.setEnabled(false);

                    }
                } 
                else if ((enterprise instanceof QualityAssuarance)) {
                    if (!type.getValue().equals(Type.Logistics.getValue()) && !type.getValue().equals(Type.Invertory.getValue()) && !type.getValue().equals(Type.WareHouse.getValue()) && !type.getValue().equals(Type.Customer.getValue()) && !type.getValue().equals(Type.Industry.getValue()) && !type.getValue().equals(Type.WasteProvider.getValue()) && !type.getValue().equals(Type.Manufacturer.getValue())) {
                        organizationJComboBox.addItem(type);
                        typeComboBox.setEnabled(false);
                        nameTextField.setEnabled(false);

                    }
                } 
                
            }
        }
    }

//    private void populatecCombo() {
//        organizationJComboBox.removeAllItems();
//        for (Type type : Organization.Type.values()) {
//            if (!type.getValue().equals(Type.Admin.getValue())) {
//                if (!(enterprise instanceof WasteProviderEnterprise)) {
//                    if (!type.getValue().equals(Type.Customer.getValue())) {
//                        organizationJComboBox.addItem(type);
//
//                    }
//                } else {
//                    organizationJComboBox.addItem(type);
//                }
//            }
//        }
//    }
    private void populateCombo() {
        organizationJComboBox.removeAllItems();
        for (Type type : Organization.Type.values()) {
            if (!type.getValue().equals(Type.Admin.getValue())) {
                organizationJComboBox.addItem(type);
            }
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);
        int count = 0;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(organization instanceof CustomerOrganisation){
            
            Object[] row = new Object[4];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            row[2] = ((CustomerOrganisation) organization).getType();
            row[3] = ((CustomerOrganisation) organization).getOrganisationName();
            model.addRow(row);
            if(((CustomerOrganisation) organization).getType().equalsIgnoreCase("HOUSE HOLD")){
                    count++;
                }
            }
            
            // row[2]=organizatio
            else{
            
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            

            // row[2]=organizatio
            model.addRow(row);
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
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        typeComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Organization", "Type", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
            organizationJTable.getColumnModel().getColumn(1).setResizable(false);
            organizationJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Organization Type ");

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "House Hold", "Food", "Medical" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Type");

        jLabel3.setText("Name : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addJButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(typeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 109, Short.MAX_VALUE)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(175, 184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addJButton)
                .addGap(15, 15, 15)
                .addComponent(backJButton)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        Type type = (Type) organizationJComboBox.getSelectedItem();
        Organization org = enterprise.getOrganizationDirectory().createOrganization(type);
        if (org instanceof CustomerOrganisation) {
            ((CustomerOrganisation) org).setType(typeComboBox.getSelectedItem().toString());
            
            ((CustomerOrganisation) org).setOrganisationName(nameTextField.getText());
            
        }
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables
}
