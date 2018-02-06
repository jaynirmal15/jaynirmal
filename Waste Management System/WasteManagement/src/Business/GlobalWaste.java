/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Jay
 */
public class GlobalWaste {
    private String wasteNsme;
    private int price;
    private int wasteID;
    private static int  count =0 ;
    
    public GlobalWaste(){
    count++;
    wasteID = count;
    }

    public int getWasteID() {
        return wasteID;
    }

    public void setWasteID(int wasteID) {
        this.wasteID = wasteID;
    }
    
    
    public String getWasteNsme() {
        return wasteNsme;
    }

    public void setWasteNsme(String wasteNsme) {
        this.wasteNsme = wasteNsme;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
    @Override
    public String toString(){
    
    return wasteNsme;
    }
}
