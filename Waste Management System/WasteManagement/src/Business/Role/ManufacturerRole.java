/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.Manufacturer;
import Business.Organization.Organization;
import Business.Organization.ManufacturerOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Manufacturer.ManufacturerWorkAreaJPanel;

/**
 *
 * @author ashis
 */

   public class ManufacturerRole extends Role{
     
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new ManufacturerWorkAreaJPanel(userProcessContainer, account, (ManufacturerOrganization)organization, enterprise,system);
    }
    
} 

