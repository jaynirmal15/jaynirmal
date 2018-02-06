/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Customer.CustomerQueue;
import Business.Role.CustomerRole;
import Business.Role.InventoryManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class CustomerOrganisation extends Organization {
    private String Type;
    private String organisationName;
    
    
    
    public CustomerOrganisation() {
        super(Organization.Type.Customer.getValue());
      
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }
    
   
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    
    
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CustomerRole());
        return roles;
    }
    
   @Override
    public String toString()
    {
    return organisationName;
    
    }
}
