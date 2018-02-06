/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

/**
 *
 * @author Jay
 */
public class WareHouseInventory {

    private String inventoryName;
    private int quanitity;
    private int inventoryID;
    private static int count = 0;
    private int sellingPrice;
    private int profit;
  

    public WareHouseInventory() {
        count++;
        inventoryID = count;
        
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    
    public int getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(int quanitity) {
        this.quanitity = quanitity;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WareHouseInventory.count = count;
    }

    @Override
    public String toString() {
        return inventoryName;
    }

}
