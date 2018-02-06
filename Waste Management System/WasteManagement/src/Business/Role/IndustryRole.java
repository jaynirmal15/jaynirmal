/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.IndustryRole.IndustryWorkAreaJPanel;
import Business.Organization.IndustryOrganisation;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Jay
 */
public class IndustryRole extends Role{
    
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
         return new IndustryWorkAreaJPanel(userProcessContainer, account, (IndustryOrganisation)organization, enterprise,business);
    }
    
    
}
