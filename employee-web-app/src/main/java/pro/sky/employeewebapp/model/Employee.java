package pro.sky.employeewebapp.model;

import java.util.Random;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int departamentId;

    public Employee(String firstName, String lastName) {
        Random random= new Random();

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary=random.nextInt(10000)+1000;
        this.departamentId=random.nextInt(5)+1;
    }

    public Employee(String firstName, String lastName, int salary, int departamentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departamentId = departamentId;
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

    public String getFullName() {
        return firstName+ " "+ lastName;
    }

    public Employee() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
