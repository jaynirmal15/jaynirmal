/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Customer.CustomerQueue;
import Business.Role.QualityAssuranceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class QualityAssuaranceOrganization extends Organization{
    private CustomerQueue custQueue;
    public QualityAssuaranceOrganization() {
        super(Organization.Type.QualityAssuarance.getValue());
        this.custQueue = new CustomerQueue();
       
    }

    public CustomerQueue getCustQueue() {
        return custQueue;
    }

    public void setCustQueue(CustomerQueue custQueue) {
        this.custQueue = custQueue;
    }
    

    

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new QualityAssuranceRole());
        return roles;
    }
    
}
