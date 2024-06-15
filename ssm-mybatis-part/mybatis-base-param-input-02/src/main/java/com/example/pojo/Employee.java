package com.example.pojo;

import lombok.Data;

@Data
public class Employee {

    private Integer empId;
    private String empName;
    private Double empSalary;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}