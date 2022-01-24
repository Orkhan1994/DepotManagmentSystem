package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private GenderType gender;
    private double salary;

    List<Depot> depots = new ArrayList<>();

    public Employee(String firstName, String lastName,
                    String userName, String password,
                    GenderType gender, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.salary = salary;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public void setDepots(Depot... depot) {
     depots.addAll(Arrays.asList(depot));
    }
}
