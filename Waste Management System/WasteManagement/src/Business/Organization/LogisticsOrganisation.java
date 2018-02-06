/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LogisticsRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class LogisticsOrganisation extends Organization {
    
    public LogisticsOrganisation() {
        super(Organization.Type.Logistics.getValue());
       
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LogisticsRole());
        return roles;
    }
    
    
    
    
    
}
