/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Jay
 */
public class IndustryWorkRequest extends WorkRequest{
    
    private int indquantity;
    private int price;
    private String name;
    private String orderResult;

    public int getIndquantity() {
        return indquantity;
    }

    public void setIndquantity(int indquantity) {
        this.indquantity = indquantity;
    }

    public String getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(String orderResult) {
        this.orderResult = orderResult;
    }

    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
    
    return name;
    }
}
