package com.strelnikov.models;

/**
 * Employee of a animal house.
 */
public class Employee {
    
    /** Employee's id number. */
    private int id;
    /** Employee's full name. */
    private String fullName;
    /** Employee's phone number. */
    private String phoneNumber;
    /** Date of employment. */
    private String employmentDate;
    /** Employee's post */
    private String post;
    /** Employee's salary for a month. */
    private int salary;
    
    /**
     * @param string the command line arguments.
     */
    public Employee (String[] string) {
        this.id = Integer.parseInt(string[0]);
        this.fullName= string[1];
        this.phoneNumber= string[2];
        this.employmentDate = string[3];
        this.post= string[4];
        this.salary = Integer.parseInt(string[5]);
    }
    
    public int getId() {
        return id;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
   
    public String getEmploymentDate() {   
        return employmentDate;
    }
   
    public String getPost() {
        return post;
    }
   
    public int getSalary() {
        return salary;
    }
    
    public static Employee fromString(String[] string) {
        return new Employee(string);
    }
   
    @Override
    public String toString() {
        return id + "," + fullName + "," + phoneNumber + "," + employmentDate 
                + "," + post + "," + salary;
    }
    
    /**
     * @param object the command line arguments.
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee)) return false;
        Employee EmployeeClassObject = (Employee)object;
        return (id == EmployeeClassObject.getId());
    }
    
    /**
     * @return 
     */
    @Override
    public int hashCode() {
        return getId();
    }
}