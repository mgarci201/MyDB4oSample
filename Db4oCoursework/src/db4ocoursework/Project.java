package db4ocoursework;

import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author supermario
 */
public class Project {
    private String projectId;
    private String title;
    private String startDate;
    private String allocatedDays;
    private Set<Employee> employees;
    Customer cust;

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public Project(){
        this.projectId = null;
        this.title = null;
        this.allocatedDays = null;
    }
    
    public Project (String projectId, String title, String startDate, String allocatedDays, Set<Employee> employees) {
        this.projectId = projectId;
        this.title = title;
        this.startDate = startDate;
        this.allocatedDays = allocatedDays;
        this.employees = employees;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAllocatedDays() {
        return this.allocatedDays;
    }

    public void setAllocatedDays(String allocatedDays) {
        this.allocatedDays = allocatedDays;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    public int hashCode(){
        return projectId.hashCode() * 7 + title.hashCode() * 7 + startDate.hashCode() * 7 + allocatedDays.hashCode() * 7 + employees.hashCode();
        
    }
    
    public boolean equals(Object o) {
        if (o instanceof Project) {
            Project p = (Project)o;
            return  p.getProjectId().equals(getProjectId()) &&
                    p.getTitle().equals(getTitle()) &&
                    p.getStartDate().equals(getStartDate()) &&
                    p.getAllocatedDays().equals(getAllocatedDays()) &&
                    p.getEmployees().equals(getEmployees());
        } else {
            return false;
        }
    }   
    
        @Override
    public String toString() {
        return  "project Id: " + getProjectId()+ ", " +
                "title: " + getTitle()+ ", " +
                "start date: " + getStartDate()+", " +
                "allocated days: " + getAllocatedDays()+ ", " +
                "Employees:" + getEmployees();
    }
}

