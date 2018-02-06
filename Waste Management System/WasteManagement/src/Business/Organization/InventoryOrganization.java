/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.InventoryManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jay
 */
public class InventoryOrganization extends Organization{
    
  
    public InventoryOrganization() {
        super(Organization.Type.Invertory.getValue());
       
    }

    

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InventoryManagerRole());
        return roles;
    }
     
}