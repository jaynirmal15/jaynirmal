  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.Custreq;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author jay
 */
public abstract class WorkRequest {

    private String wasteName;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String qualityResult;
    private Custreq quantity;
    private int quant;
    private String industryResult;

    public String getIndustryResult() {
        return industryResult;
    }

    public void setIndustryResult(String industryResult) {
        this.industryResult = industryResult;
    }
   
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getQualityResult() {
        return qualityResult;
    }

    public void setQualityResult(String qualityResult) {
        this.qualityResult = qualityResult;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getWasteName() {
        return wasteName;
    }

    public void setWasteName(String wasteName) {
        this.wasteName = wasteName;
    }

   
    
    
    
    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public Custreq getQuantity() {
        return quantity;
    }

    public void setQuantity(Custreq quantity) {
        this.quantity = quantity;
    }

    
   
    
    
     @Override
    public String toString() {
        return wasteName;
    }
}
