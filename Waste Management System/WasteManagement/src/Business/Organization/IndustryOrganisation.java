/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.IndustryRole;
import Business.Role.Role;
import Business.WorkQueue.IndustryWorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class IndustryOrganisation extends Organization{
    private IndustryWorkRequest industryWorkRequest;
     public IndustryOrganisation() {
        super(Organization.Type.Industry.getValue());
       
    }

    public IndustryWorkRequest getIndustryWorkRequest() {
        return industryWorkRequest;
    }

    public void setIndustryWorkRequest(IndustryWorkRequest industryWorkRequest) {
        this.industryWorkRequest = industryWorkRequest;
    }
     
     

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new IndustryRole());
        return roles;
    }
    
}
