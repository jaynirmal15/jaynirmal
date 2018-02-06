/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class CustomerQueue {
    
    private ArrayList<Custreq> custQueue;
    
    public CustomerQueue(){
    
    this.custQueue = new ArrayList<>();
    }

    public ArrayList<Custreq> getCustQueue() {
        return custQueue;
    }

    public void setCustQueue(ArrayList<Custreq> custQueue) {
        this.custQueue = custQueue;
    }
    
    public Custreq addCust(){
        Custreq cust = new Custreq();
        custQueue.add(cust);
        return cust;
    }
    public void removeVaccine(Custreq vac){
        custQueue.remove(vac);
    }
    
}
