package com.dw.companyapp.repository;

import com.dw.companyapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository extends JpaRepository <Employee,String> {
    @Query("SELECT e FROM Employee e WHERE e.department.departmentId = :departmentNumber AND e.position = :position")
    List<Employee> findEmployeesDepartmentAndPosition(@Param("departmentNumber") String departmentNumber,@Param("position") String position);
    @Query("SELECT e FROM Employee e ORDER BY e.hireDate DESC")
    List<Employee> getEmployeeByHiredate1();
    @Query("SELECT e FROM Employee e WHERE e.hireDate > :hireDate ORDER BY e.hireDate ASC")
    List<Employee> getEmployeeByHiredate2(String hireDate);
}
