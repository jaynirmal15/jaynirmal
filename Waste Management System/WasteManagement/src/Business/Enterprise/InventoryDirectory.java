/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class InventoryDirectory {

    private ArrayList<WareHouseInventory> inventoryList;

    public InventoryDirectory() {
        this.inventoryList = new ArrayList<>();

    }

    public WareHouseInventory searchByName(String name) {
        for (WareHouseInventory wi : inventoryList) {
            if (name != null) {
                if (wi.getInventoryName() != null) {
                    if (wi.getInventoryName().equals(name)) {
                        return wi;
                    }
                }
            }
        }
        WareHouseInventory wi = new WareHouseInventory();
        wi.setInventoryName(name);
        inventoryList.add(wi);
        return wi;

    }

    public ArrayList<WareHouseInventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<WareHouseInventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

}
