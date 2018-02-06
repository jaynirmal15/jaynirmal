/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author jay
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.QualityAssuarance) {
            enterprise = new QualityAssuarance(name);
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Industry) {
            enterprise = new IndustryEnterprise(name);
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Logistics) {
            enterprise = new LogisticsEnterprise(name);
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.WasteProvider) {
            enterprise = new WasteProviderEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.WareHouse) {
            enterprise = new WareHouseEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }

}
