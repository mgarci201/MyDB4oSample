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
public class ExternalCustomer extends Customer {
    
    private String siteAddress;
    
    
    public ExternalCustomer (String custNo, String fn, String ln, String addr, String siteAddress, Project proj){
    
        super(custNo, fn, ln, addr, proj);
        this.siteAddress = siteAddress;
        
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }
    
    public int hashCode(){
        return getSiteAddress().hashCode() * 31;     
    }    
    
    public boolean equals (Object o) {
                if (o instanceof ExternalCustomer) {
            ExternalCustomer exc = (ExternalCustomer)o;
            return  exc.getSiteAddress() == getSiteAddress();
                    
        } else {
            return false;
        }         
    }
    
    public String toString() {
          return
                "External Customer |" +  
                "customer number: " + getCustomerNo()+ ", " +
                "first name: " + getFirstName()+ ", " +
                "surname: " + getLastName()+ ", " +
                "address: " + getAddress()+ ", " + 
                "project: " + getProject();
//        return super.getFirstName() + " is an External Customer";
    }    
    
    
    
}
