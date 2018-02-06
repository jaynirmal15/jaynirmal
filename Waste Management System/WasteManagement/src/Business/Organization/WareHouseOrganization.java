/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InventoryManagerRole;
import Business.Role.Role;
import Business.Role.WareHouseRole;
import java.util.ArrayList;

/**
 *
 * @author ashis
 */


public class WareHouseOrganization extends Organization {

    public WareHouseOrganization() {
        super(Organization.Type.WareHouse.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new WareHouseRole());
        return roles;
    }
    
}
