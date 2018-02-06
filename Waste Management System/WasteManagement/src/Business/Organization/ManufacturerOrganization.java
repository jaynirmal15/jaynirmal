/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InventoryManagerRole;
import Business.Role.ManufacturerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author ashis
 */

public class ManufacturerOrganization extends Organization {
 private String type;
    
    public ManufacturerOrganization() {
        super(Organization.Type.Manufacturer.getValue());
       
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManufacturerRole());
        return roles;
    }
}    

