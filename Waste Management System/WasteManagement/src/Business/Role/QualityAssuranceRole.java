/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import userinterface.QualityAssuarance.QualityAssuaranceWorkAreaJPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import userinterface.Logistic.LogisticsWorkAreaJPanel;
import Business.Organization.QualityAssuaranceOrganization;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.InventoryRole.InventoryWorkAreaJPanel;

/**
 *
 * @author Jay
 */
public class QualityAssuranceRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new QualityAssuaranceWorkAreaJPanel(userProcessContainer, account, (QualityAssuaranceOrganization)organization, enterprise,system);
    }
    
}
