package com.dw.firstapp.model;

public class Department {
    private String departmentNumber; // 부서번호
    private String DepartmentName; // 부서명

    public Department() {
    }

    public Department(String departmentNumber, String departmentName) {
        this.departmentNumber = departmentNumber;
        DepartmentName = departmentName;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentNumber='" + departmentNumber + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                '}';
    }
}