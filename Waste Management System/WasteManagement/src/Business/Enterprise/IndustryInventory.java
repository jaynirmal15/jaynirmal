/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

/**
 *
 * @author ashis
 */
public class IndustryInventory {
     private String industryWaste;
    private int industryQuantity;
    private int buyingPrice;
    private int inventoryID;
    private static int count = 0;

    public IndustryInventory() {
        count++;
        inventoryID = count;
    }

    public String getIndustryWaste() {
        return industryWaste;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public void setIndustryWaste(String ndustryWaste) {
        this.industryWaste = ndustryWaste;
    }

    public int getIndustryQuantity() {
        return industryQuantity;
    }

    public void setIndustryQuantity(int industryQuantity) {
        this.industryQuantity = industryQuantity;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        IndustryInventory.count = count;
    }

    

    

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }
    
    public IndustryInventory addInventory(String name,int quantity, int price){
    IndustryInventory  industry = new IndustryInventory();
    if(!industry.getIndustryWaste().equals(name)){
    industry.setIndustryWaste(name);
    industry.setBuyingPrice(price);
    industry.setIndustryQuantity(quantity);
    }
    return industry;
    
    }
   

    @Override
    public String toString() {
        return industryWaste;
    }
}
