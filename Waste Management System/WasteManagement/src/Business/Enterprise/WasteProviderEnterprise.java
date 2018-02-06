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
public class WasteProviderEnterprise extends Enterprise {
    
    public WasteProviderEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.WasteProvider);
       
    }

    

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
