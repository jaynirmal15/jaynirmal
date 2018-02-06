

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author jay
 */
public class CustomerWorkRequest extends WorkRequest{
    
    private int total;
    private String type;
    private String address;
    private String organisationName;
    private String points;
    private int wasteQuantity;
    public int getTotal() {
        return total;
    }

    
    public void setTotal(int total) {
        this.total = total;
    }

    public int getWasteQuantity() {
        return wasteQuantity;
    }

    public void setWasteQuantity(int wasteQuantity) {
        this.wasteQuantity = wasteQuantity;
    }

    

    
    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

    
    
    
}
