package com.dw.firstapp.repository.iface;

import com.dw.firstapp.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> getAlldepartment();
    Department saveDepartment(Department department);
    List<Department> saveDepartmentList(Department departmentList);
    Department updateDepartment(Department department);
    String deleteDepartment(String id);
}
