/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jay
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name,String address,int number,String email){
        Employee employee = new Employee();
        if((name.equals("")) || (name.isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Please insert a correct value");
        }
        else employee.setName(name);
         if((address.equals("")) || (address.isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Please insert a correct value");
        }
         else employee.setAddress(address);
         
          employee.setNumber(number);
        employee.setEmail(email);
        employeeList.add(employee);
        return employee;
    }
}