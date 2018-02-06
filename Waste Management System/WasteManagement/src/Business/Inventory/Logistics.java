/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Jay
 */
public class Logistics {
    private WorkQueue workqueue;
        
    private WorkRequest workRequest;
    private UserAccount name;

    public WorkQueue getWorkqueue() {
        return workqueue;
    }

    public void setWorkqueue(WorkQueue workqueue) {
        this.workqueue = workqueue;
    }

    public WorkRequest getWorkRequest() {
        return workRequest;
    }

    public void setWorkRequest(WorkRequest workRequest) {
        this.workRequest = workRequest;
    }

    public UserAccount getName() {
        return name;
    }

    public void setName(UserAccount name) {
        this.name = name;
    }
    
    
    
}
