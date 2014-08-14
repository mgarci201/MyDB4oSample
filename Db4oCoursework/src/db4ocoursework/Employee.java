/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db4ocoursework;

/**
 *
 * @author supermario
 */
public class Employee {
    private String employeeNo;
    private String employeeName;
    private String employeeAddress;
    private String employeeRole;
    
    /**
     *
     */
    public Employee() {
        this.employeeNo = null;
        this.employeeName = null; 
        this.employeeAddress = null;
        this.employeeRole = null;
    }
    
    public Employee (String employeeNo, String employeeName, String employeeAddr, String employeeRole) {
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddr;
        this.employeeRole = employeeRole;
    }    

    /**
     *
     * @return
     */
    public String getEmployeeNo() {
        return this.employeeNo;
    }

    /**
     *
     * @param employeeNo
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.employeeName;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.employeeName = name;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return this.employeeAddress;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.employeeAddress = address;
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return this.employeeRole;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.employeeRole = role;
    }
    
    public int hashCode (){
        return employeeNo.hashCode() * 37 + employeeName.hashCode() * 37 + employeeAddress.hashCode() * 37 + employeeRole.hashCode() * 37;
    }
    
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee)o;
            return  e.getEmployeeNo().equals(getEmployeeNo()) &&
                    e.getName().equals(getName()) &&
                    e.getAddress().equals(getAddress()) &&
                    e.getRole().equals(getRole());

        } else {
            return false;
        }
    }
        
    public String toString() {
        return  "employee number: " + getEmployeeNo() + ", " +
                "employee name: " + getName() + ", " +
//                "employee address: " + getAddress()+ ", " +
                "employee role: " + getRole();
    }  
    
}

