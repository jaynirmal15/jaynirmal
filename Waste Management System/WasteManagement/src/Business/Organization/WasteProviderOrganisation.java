/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InventoryManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class WasteProviderOrganisation extends Organization {
 
    
    public WasteProviderOrganisation() {
        super(Organization.Type.WasteProvider.getValue());
       
    }

    

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InventoryManagerRole());
        return roles;
    }
}
