/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class WasteDirectory {
    private ArrayList<GlobalWaste> wasteList;
    
    public WasteDirectory(){
    
    this.wasteList = new ArrayList<>();
    }

    public ArrayList<GlobalWaste> getWasteList() {
        return wasteList;
    }
    
    public GlobalWaste addWaste(){
        GlobalWaste waste = new GlobalWaste();
        wasteList.add(waste);
        return waste;
    }
    
}
