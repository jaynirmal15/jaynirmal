/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Manufacturer;

import Business.Customer.Custreq;
import java.util.ArrayList;

/**
 *
 * @author ashis
 */
public class ManufacturerList {
    private ArrayList<Manufacturer> manufacturerList;
    
    public ManufacturerList(){
    
    this.manufacturerList = new ArrayList<>();
    }

    public ArrayList<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }

    public void setManufacturerList(ArrayList<Manufacturer> manufacturerList) {
        this.manufacturerList = manufacturerList;
    }

    
    
    public Manufacturer addManufacturerReq(){
        Manufacturer manu = new Manufacturer();
        manufacturerList.add(manu);
        return manu;
    }
    
}
