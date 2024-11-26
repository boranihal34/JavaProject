package com.example.model;

public class Employee {
    private String name;
    private Integer employeeId;
    private Integer salary;

    public Employee(Integer employeeId , String name ,Integer salary)
    {
        this.name=name;
        this.employeeId=employeeId;
        this.salary=salary;
    }
    public Integer getEmployeeId()
    {
        return this.employeeId;
    }

    public String getEmployeeName()
    {
        return this.name;
    }

    public Integer getEmployeeSalary()
    {
        return this.salary;
    }



}
