/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.QualityAssuarance;

import Business.Customer.Custreq;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.IndustryEnterprise;
import Business.Enterprise.LogisticsEnterprise;
import Business.Enterprise.WareHouseEnterprise;
import Business.Enterprise.WareHouseInventory;
import Business.Enterprise.WasteProviderEnterprise;
import Business.Network.Network;
import Business.Organization.QualityAssuaranceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CustomerWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jay
 */
public class ApproveCustomerRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private QualityAssuaranceOrganization qualityOrganisation;
    private Enterprise enterprise;
    private EcoSystem system;
    public static final String ACCOUNT_SID = "ACd4095d88d754fc03cea158fb4661ac18";
    public static final String AUTH_TOKEN = "e42e473d568c94f2e9a78ee1ad6c4a7e";

    /**
     * Creates new form ApproveCustomerRequestJPanel
     */
    public ApproveCustomerRequestJPanel() {
        initComponents();
    }

    ApproveCustomerRequestJPanel(JPanel userProcessContainer, UserAccount account, QualityAssuaranceOrganization qualityOrganisation, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.qualityOrganisation = qualityOrganisation;
        this.enterprise = enterprise;
        this.system = system;
        populateTable();
    }
    
    public void textMessage(){
 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
 
 com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
 .creator(new PhoneNumber("+1 857-544-9985"), new PhoneNumber("+1 424-289-6752 "),
 "Waste Accepted!").create();
 
 System.out.println(message.getSid());
 }
    
    public void SendMailSSL(){
        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("gurav.ashish1@gmail.com","9757384888a");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("gurav.ashish1@gmail.com"));
			 int selectedRow = workRequestJTable.getSelectedRow();
                        WorkRequest request=(WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
			message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(request.getSender().getEmployee().getEmail()));
			message.setSubject("Testing Subject");
			message.setText("Waste Accepted");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void RejectMailSSL(){
        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("gurav.ashish1@gmail.com","9757384888a");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("gurav.ashish1@gmail.com"));
                        int selectedRow = workRequestJTable.getSelectedRow();
                        WorkRequest request=(WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(request.getSender().getEmployee().getEmail()));
			message.setSubject("Testing Subject");
			message.setText("Sorry your Recylable Waste Request is Rejected ");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
    
   

    

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if(request instanceof CustomerWorkRequest){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();

            row[2] = request.getQualityResult();
            row[3] = ((CustomerWorkRequest) request).getWasteQuantity();
            

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        rejectRequestBtn = new javax.swing.JButton();
        acceptRequestBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Result", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        refreshBtn.setBackground(new java.awt.Color(0, 0, 255));
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        rejectRequestBtn.setText("Reject");
        rejectRequestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectRequestBtnActionPerformed(evt);
            }
        });

        acceptRequestBtn.setText("Accept");
        acceptRequestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptRequestBtnActionPerformed(evt);
            }
        });

        jButton2.setText("< back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(acceptRequestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(98, 98, 98)
                            .addComponent(rejectRequestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rejectRequestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptRequestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void rejectRequestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectRequestBtnActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row");
        }  else {

            request.setReceiver(account);
            request.setQualityResult("Reject");
            populateTable();
            RejectMailSSL();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_rejectRequestBtnActionPerformed

    private void acceptRequestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptRequestBtnActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row");
        } 
        else {

            request.setReceiver(account);
            request.setQualityResult("Approved");
            SendMailSSL();
            textMessage();
            
            
            

            for (Network network : system.getNetworkList()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if ((ent instanceof LogisticsEnterprise) && request.getQualityResult().equals("Approved")) {

                        ent.getWorkQueue().getWorkRequestList().add(request);
                        

                    }

                }
            }
            for (Network network : system.getNetworkList()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if ((ent instanceof WasteProviderEnterprise) && request.getQualityResult().equals("Approved")) {

                        ent.getWorkQueue().getWorkRequestList().add(request);
                        

                    }

                }
            }
            
            
            for (Network network : system.getNetworkList()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if ((ent instanceof WareHouseEnterprise) && request.getQualityResult().equals("Approved")) {

                        ent.getWorkQueue().getWorkRequestList().add(request);
                        

                    }

                }
            }
            populateTable();

        }
    }//GEN-LAST:event_acceptRequestBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptRequestBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton rejectRequestBtn;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
