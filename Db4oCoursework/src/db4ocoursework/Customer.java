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
public class Customer {
    private String customerNo;
    private String firstName;
    private String lastName;
    private String address; 
    private Project project;

    
    /**
     *
     */
    public Customer(){
        this.customerNo = null;
        this.firstName = null;
        this.lastName = null;
        this.address = null;
        this.project = null;
    }
    
    /**
     *
     * @param custNo
     * @param fn
     * @param ln
     * @param addr
     * @param proj
     */
    public Customer (String custNo, String fn, String ln, String addr, Project proj){
        this.customerNo = custNo;
        this.firstName = fn;
        this.lastName = ln;
        this.address = addr;
        this.project = proj;
        proj.setCust(this);
    }

    /**
     *
     * @return
     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     *
     * @param customerNo
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public Project getProject() {
        return project;
    }

    /**
     *
     * @param project
     */
    public void setProject(Project project) {
        this.project = project;
        project.setCust(this);
    }
   
    @Override
    public int hashCode(){
        return getCustomerNo().hashCode() * 31 + getFirstName().hashCode() * 31 + getLastName().hashCode() * 31 + getAddress().hashCode() * 31 + getProject().hashCode();     
    }
    
    public boolean equals (Object o){
                if (o instanceof Customer) {
            Customer c = (Customer)o;
            return  c.getCustomerNo() == getCustomerNo() &&
                    c.getFirstName().equals(getFirstName()) &&
                    c.getLastName().equals(getLastName()) &&
                    c.getAddress().equals(getAddress()) &&
                    c.getProject().equals(getProject());
        } else {
            return false;
        }              
    }
    
        public String toString() {
        return  
                "Internal Customer |" +                
                "customer number: " + getCustomerNo()+ ", " +
                "first name: " + getFirstName()+ ", " +
                "surname: " + getLastName()+ ", " +
                "address: " + getAddress()+ ", " + 
                "project: " + getProject();
    }
}

