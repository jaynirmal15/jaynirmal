/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class LogisticsInventory {
    
    private ArrayList<Logistics> logisticsInventory;
    
    public LogisticsInventory(){
    this.logisticsInventory = new ArrayList<>();
    
    }

    public ArrayList<Logistics> getLogisticsInventory() {
        return logisticsInventory;
    }

    public void setLogisticsInventory(ArrayList<Logistics> logisticsInventory) {
        this.logisticsInventory = logisticsInventory;
    }
    
    
    
}
