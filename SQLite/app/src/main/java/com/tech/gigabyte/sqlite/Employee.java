package com.tech.gigabyte.sqlite;

/**
 * Created by GIGABYTE on 5/27/2017.
 */

//Employee Class
public class Employee {
    int id;
    String employeeFirstName;
    String employeeLasttName;
    String employeeAge;
    String employeeSex;

    public Employee(){

    }

    public Employee(int id, String employeeFirstName, String employeeLasttName, String employeeAge, String employeeSex){
        this.id = id;
        this.employeeFirstName = employeeFirstName;
        this.employeeLasttName = employeeLasttName;
        this.employeeAge = employeeAge;
        this.employeeSex = employeeSex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLasttName() {
        return employeeLasttName;
    }

    public void setEmployeeLasttName(String employeeLasttName) {
        this.employeeLasttName = employeeLasttName;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }
}
