package db4ocoursework;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import com.db4o.query.*;


public class Db4oCoursework {
    
        private final File file;
        private ObjectContainer db;

    public Db4oCoursework () throws IOException {
        file = new File("./customers.db");
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }
    }
        
    private void open() {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(db4ocoursework.Project.class).cascadeOnUpdate(true);
        config.common().objectClass(db4ocoursework.Customer.class).cascadeOnUpdate(true);
        config.common().objectClass(db4ocoursework.Project.class).objectField("employees").cascadeOnDelete(true);
        db = Db4oEmbedded.openFile(config, file.getAbsolutePath());
    }   
        
    private void close() {
        db.close();
    }
    @SuppressWarnings({"unchecked"})
    
    public void addCustomers() throws IOException {
        System.out.println("Add Customers");
        
        open();
        
        Project p1 = db.query(new Predicate<Project>() {
                                @Override
                                public boolean match(Project p) {
                                    return p.getProjectId().equals("P01627");
                                }
                            }).get(0);  
        
        Project p2 = db.query(new Predicate<Project>() {
                                @Override
                                public boolean match(Project p) {
                                    return p.getProjectId().equals("P01122");
                                }
                            }).get(0);
        
        Project p3 = db.query(new Predicate<Project>() {
                                @Override
                                public boolean match(Project p) {
                                    return p.getProjectId().equals("P02920");
                                }
                            }).get(0);         
        
        
        Customer c1 = new Customer("1", "Christian", "Bale", "9 Gordon St", p1 );
        Customer c2 = new Customer("2", "Jude", "Law", "59 Byron Bay", p2 ); 
        Customer c3 = new Customer("3", "Anthony", "Hopkins", "32 Maroochydore Dr.", p3 ); 
        ExternalCustomer exc1 = new ExternalCustomer("4", "Frankie", "Boyle", "65 Pitt St", "Papua New Guinea", p1);
        ExternalCustomer exc2 = new ExternalCustomer("5", "Sean", "Connery", "83 Belhaven Avenue", "Solomon Islands", p2);        
        
        db.set(c1);
        db.set(c2);
        db.set(c3);
        db.store(exc1);
        db.store(exc2);
        db.commit();
        
        System.out.println("-----------");        
        
        close();   
    }
    
    public void listCustomers() {
        System.out.println("List Customers");
        
        open();
        
        List<Customer> customerList = db.query(new Predicate<Customer>() {
        public boolean match(Customer c) { return true; }
        });
        
        System.out.println(customerList.size() + " module (s) found:");
        for (Iterator iter = customerList.iterator(); iter.hasNext();) {
            Customer c = (Customer) iter.next();
            System.out.println(c);
        }
                
        System.out.println("-----------");
        
        close();
        
        }  
    
    public void addProjects() throws IOException {
        System.out.println("Add Projects");
        open();
        
        System.out.println("\n***Creating project objects...");   
        Project p1 = new Project("P01627", "Create basic website using PHP", "07-Oct-2012", "14", null);
        Project p2 = new Project("P01122", "Manage I.T. projects with Prince2", "21-Sep-2013", "12", null);
        Project p3 = new Project("P02980", "Cloud computing management Azure", "29-Jan-2012", "21", null);        
        Project p4 = new Project("P02920", "Cloud computing with Amazon Web Services", "16-Feb-2014", "16", null); 
        Project p5 = new Project("P00901", "Games development using Dark Basic ", "12-Dec-2014", "28", null);        
        
        System.out.println("\n***Employee objects retrieved");     
        
        Employee e1 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) {
                return e.getEmployeeNo().equals("E1");
            }
        }).get(0); 
                      
        Employee e2 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) { 
                return e.getEmployeeNo().equals("E2");
            }
        }).get(0); 
        
        Employee e3 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) { 
                return e.getEmployeeNo().equals("E3");
            }
        }).get(0);     
        
        Employee e4 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) { 
                return e.getEmployeeNo().equals("E4");
            }
        }).get(0);    

        Employee e5 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) { 
                return e.getEmployeeNo().equals("E5");
            }
        }).get(0);

        Employee e6 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) { 
                return e.getEmployeeNo().equals("E6");
            }
        }).get(0);   
        
        Employee e7 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) { 
                return e.getEmployeeNo().equals("E7");
            }
        }).get(0);
        
        Employee e8 = db.query(new Predicate<Employee>() {
            public boolean match(Employee e) { 
                return e.getEmployeeNo().equals("E8");
            }
        }).get(0);        
        
        Set<Employee> p1Employees = new HashSet(Arrays.asList(e1, e2, e3, e4));
        Set<Employee> p2Employees = new HashSet(Arrays.asList(e5, e6, e7));
        Set<Employee> p3Employees = new HashSet(Arrays.asList(e5, e6, e8)); 
        Set<Employee> p4Employees = new HashSet(Arrays.asList(e2, e7));
        Set<Employee> p5Employees = new HashSet(Arrays.asList(e4, e5, e6, e7, e8));        
        
        
        System.out.println("\n***Attach employees to projects");        
        
        p1.setEmployees(p1Employees);
        p2.setEmployees(p2Employees);
        p3.setEmployees(p3Employees);
        p4.setEmployees(p4Employees);
        p5.setEmployees(p5Employees);
        
        db.set(p1);
        db.set(p2);
        db.store(p3);
        db.store(p4);
        db.store(p5);
        db.commit();

        System.out.println("\n***Project objects saved...");
        
        System.out.println("-----------");        
        close();   
    }
    
    public void listProjects() {
        System.out.println("List Projects");
        
        open();
        
        List<Project> projectList = db.query(new Predicate<Project>() {
        public boolean match(Project p) { return true; }
        });
        
        System.out.println(projectList.size() + " module (s) found:");
        for (Iterator iter = projectList.iterator(); iter.hasNext();) {
            Project p = (Project) iter.next();
            System.out.println(p);
        }
                
        System.out.println("-----------"); 
        close();  
        }    
   
    public void addEmployees() throws IOException {
        
        System.out.println("Add Employees");
        open();
        
        System.out.println("\n***Creating employee objects...");          
        Employee e1 = new Employee("E1", "Johnatan", "66 Bath Lane", "Analyst");
        Employee e2 = new Employee("E2", "Benji", "21 Maloolaba St", "Software Programmer");        
        Employee e3 = new Employee("E3", "Charlie", "81 Coolum Dr", "System Administrator"); 
        Employee e4 = new Employee("E4", "Jerry", "86 East Avenue", "Application Engineer");    
        Employee e5 = new Employee("E5", "Ashton", "98 Avenue Place", "Database Administrator");   
        Employee e6 = new Employee("E6", "Joshua", "12 Bailey Place", "Network Engineer");     
        Employee e7 = new Employee("E7", "Marko", "49 West George St", "Web Developer");
        Employee e8 = new Employee("E8", "Marshall", "22 Jump Place", "Network Administrator");
        Employee e9 = new Employee("E9", "Brian", "23 Summerhill Dr", "Project Manager");
        Employee e10 = new Employee("E10", "George", "61 West George St", "Senior Programmer");         
        
        db.store(e1);
        db.store(e2);
        db.store(e3);
        db.store(e4);
        db.store(e5);
        db.store(e6);
        db.store(e7);
        db.store(e8);
        db.store(e9);
        db.store(e10);
        db.commit();
        
        System.out.println("\n***Employee objects saved...");
        
        System.out.println("-----------");
        close();
    }
        
    public void listEmployees() {
        System.out.println("List Employees");
        
        open();
        
        List<Employee> employeeList = db.query(new Predicate<Employee>() {
        public boolean match(Employee e) { return true; }
        });
        
        System.out.println(employeeList.size() + " module (s) found:");
        for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
            Employee e = (Employee) iter.next();
            System.out.println(e);
        }
                
        System.out.println("-----------");
        close();
        }
    
    public void retrieveProjectDetails (final String projectId) {
        
        System.out.println("Retrieve Project Details");     
        
        open();
        
        Project p = db.query(new Predicate<Project>() {
            public boolean match (Project p) {
                return p.getProjectId().equals(projectId);
            }   
        }).get(0);
        
        System.out.println(p);  
        System.out.println("-----------");        
        close();
    }
    
    public void updateProject (final String projectId, String allocatedDays, String empRemoved, String empAdded ) {
        
        System.out.println("Update Project");  
        open();
        
        List<Project> projectList = db.query(new Predicate<Project>() {
            public boolean match (Project p) {
                return p.getProjectId().equals(projectId);
            }
        });
        
        Project p = projectList.get(0);
        p.setAllocatedDays(allocatedDays);
        p.getEmployees().remove(empRemoved);  
//        p.getEmployees().add(null);
//        p.getEmployees().add(empAdded);
        
        db.store(p);

        System.out.println(p);   
        System.out.println("-----------");          
        close();
    }
    
    public void deleteEmployee (final String employeeNo) {
        
        System.out.println("Delete Employee");
        open();
        
        //retrieve Employee object using native query
        List<Employee> employeeList = db.query(new Predicate<Employee> () {
            public boolean match (Employee e) {
                return e.getEmployeeNo().equals(employeeNo);
            }
        });        
//        System.out.println(employeeList.size() + " employee(s) found:" );
//        for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
//            Employee e = (Employee) iter.next();
//            e.getEmployeeNo().equals(employeeNo);
//            db.store(e);       
//        }
        Employee e = employeeList.get(0);
        db.delete(e);
        System.out.println("Deleted employee: " + employeeList );    
        
        System.out.println("-----------");         
        close();
    } 
    
    public void listCustomerProjects (final String custNo) {
        
        System.out.println("List Project for specified customer");   
        open();
        
        List<Project> projectList = db.query(new Predicate<Project>() {
            public boolean match(Project p) {
                return p.getCust().getCustomerNo().equals(custNo);
                
            }
        });        
//       
        System.out.println(projectList.size() + " project(s) found:");
        for (Iterator iter = projectList.iterator(); iter.hasNext();) {
            Project p = (Project) iter.next();
            System.out.println(p);
        }
        
        System.out.println("-----------");  
        close();  
    }
    
    public void listCustomerEmployees (final String employeeNo) {
        
        System.out.println("List customer for specified employee");   
        open();        
        
        List<Customer> customerList = db.query(new Predicate<Customer>() {
            public boolean match(Customer c) {
                Project p = c.getProject();
                for (Employee e : p.getEmployees())
                    if(e.getEmployeeNo().equals(employeeNo))
                        return true;
                return false; 
            }
        });        
        
        System.out.println(customerList.size() + " customer(s) found:");
            for (Iterator iter2 = customerList.iterator(); iter2.hasNext();) {
                Customer c = (Customer) iter2.next();    
                System.out.println(c.getFirstName() + "," + c.getLastName() + " associated with " + c.getProject());
            }        
        System.out.println("-----------");
        close();
    }
    
    public void admin() {
        try {
            
            addEmployees();
            listEmployees();
            
            addProjects();
            listProjects();            
            
            addCustomers();
            listCustomers(); 
            
            listCustomerProjects("3");
            listCustomerEmployees("E2");

            retrieveProjectDetails("P02980");
            updateProject("P00901", "99", "E8", "E1");
            //listProjects();
            
            deleteEmployee("E6");
            //listEmployees();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        finally {
            close();
        }
    }
    
    public static void main (String[] args) {
        try {
            Db4oCoursework run = new Db4oCoursework();
            run.admin();
        } catch (Exception e) { e.printStackTrace();
        }
    }
    
}
