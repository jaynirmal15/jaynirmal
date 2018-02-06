/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Organization.Organization;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Jay
 */
public class Custreq {
    
    private  String wasteName;
    private    int quantity;
    private Organization organization;
    private WorkQueue workQueue;
    private WorkRequest workRequest;
    private String type ;
    
    public  Custreq(){
    
    this.organization = organization;
    this.workQueue = workQueue;
    this.workRequest = workRequest;
    }

    public String getWasteName() {
        return wasteName;
    }

    public void setWasteName(String wasteName) {
        this.wasteName = wasteName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public WorkRequest getWorkRequest() {
        return workRequest;
    }

    public void setWorkRequest(WorkRequest workRequest) {
        this.workRequest = workRequest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
    
}
