package com.swiss.re.bean;

public class Employee {
    private String Id;
    private String firstName;
    private String lastName;
    private Double salary;
    private String mangerId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getMangerId() {
        return mangerId;
    }

    public void setMangerId(String mangerId) {
        this.mangerId = mangerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + Id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", mangerId='" + mangerId + '\'' +
                '}';
    }
}
