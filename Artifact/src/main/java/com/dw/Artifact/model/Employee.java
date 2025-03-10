package com.dw.Artifact.model;

import java.time.LocalDate;

public class Employee {
    private String employeeNumber; // 사원번호
    private String name; // 이름
    private String englishName; // 영문이름
    private String employeeClass; // 직위
    private String gender; // 성별
    private LocalDate birthDate; // 생일
    private LocalDate joinDate; // 입사일
    private String adress; // 주소
    private String city; // 도시
    private String region;
    private String homePhone;
    private String supervisorId;
    private String departmentId;

    public Employee() {

    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEmployeeClass() {
        return employeeClass;
    }

    public void setEmployeeClass(String employeeClass) {
        this.employeeClass = employeeClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Employee(String employeeNumber, String name, String englishName, String employeeClass,
                    String gender, LocalDate birthDate, LocalDate joinDate, String adress,
                    String city, String region, String homePhone, String supervisorId,
                    String departmentId) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.englishName = englishName;
        this.employeeClass = employeeClass;
        this.gender = gender;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.adress = adress;
        this.city = city;
        this.region = region;
        this.homePhone = homePhone;
        this.supervisorId = supervisorId;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", name='" + name + '\'' +
                ", englishName='" + englishName + '\'' +
                ", employeeClass='" + employeeClass + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", joinDate=" + joinDate +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", supervisorId='" + supervisorId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}

