package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author jay
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH","Huntington Ave",588555 ,"asabe@gmail.com");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("ad", "ad", employee, new SystemAdminRole());

        return system;
    }

}
