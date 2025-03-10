package com.dw.firstapp.dto;

import java.time.LocalDate;

public class EmployeeDepartmentDTO {
    private LocalDate hireDate; // 입사일
    private String departmentName; // 부서명
    private String employeeName; // 사원이름

    public EmployeeDepartmentDTO() {

    }

    public EmployeeDepartmentDTO(LocalDate hireDate, String departmentName, String employeeName) {
        this.hireDate = hireDate;
        this.departmentName = departmentName;
        this.employeeName = employeeName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return this.hireDate + ", " + this.departmentName + ", " +
                this.employeeName;
    }
}
