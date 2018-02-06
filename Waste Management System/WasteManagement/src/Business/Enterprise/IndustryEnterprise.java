/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class IndustryEnterprise extends Enterprise{
    
    private IndustryInventoryDirectory industryDirectory;
    
    public IndustryEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Industry);
        this.industryDirectory = new IndustryInventoryDirectory();
    }

    public IndustryInventoryDirectory getIndustryDirectory() {
        return industryDirectory;
    }

    public void setIndustryDirectory(IndustryInventoryDirectory industryDirectory) {
        this.industryDirectory = industryDirectory;
    }

    
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
