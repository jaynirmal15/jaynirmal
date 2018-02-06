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
 * @author ashis
 */
public class WareHouseEnterprise extends Enterprise {

    private InventoryDirectory inventoryDirectory;

    public WareHouseEnterprise(String name) {

        super(name, Enterprise.EnterpriseType.WareHouse);
        this.inventoryDirectory = new InventoryDirectory();

    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }

    public void setInventoryDirectory(InventoryDirectory inventoryDirectory) {
        this.inventoryDirectory = inventoryDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

}
