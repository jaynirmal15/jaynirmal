/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.IndustryEnterprise;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory(){
    
    this.organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
       
         if (type.getValue().equals(Type.Invertory.getValue())){
            organization = new InventoryOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.WasteProvider.getValue())){
            organization = new WasteProviderOrganisation();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Customer.getValue())){
            organization = new CustomerOrganisation();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Logistics.getValue())){
            organization = new LogisticsOrganisation();
            organizationList.add(organization);
        }
          else if (type.getValue().equals(Type.QualityAssuarance.getValue())){
            organization = new QualityAssuaranceOrganization();
            organizationList.add(organization);
        }
          else if (type.getValue().equals(Type.Industry.getValue())){
            organization = new IndustryOrganisation();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.WareHouse.getValue())){
            organization = new WareHouseOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Manufacturer.getValue())){
            organization = new ManufacturerOrganization();
            organizationList.add(organization);
        }
         
        return organization;
    }

    
}
