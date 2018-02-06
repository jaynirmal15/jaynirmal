/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author ashis
 */
public class IndustryInventoryDirectory {
    private ArrayList<IndustryInventory> industoryList;
    
    
    public IndustryInventoryDirectory(){
        this.industoryList=new ArrayList<>();
    }

    public ArrayList<IndustryInventory> getIndustoryList() {
        return industoryList;
    }

    public void setIndustoryList(ArrayList<IndustryInventory> industoryList) {
        this.industoryList = industoryList;
    }
    
}


