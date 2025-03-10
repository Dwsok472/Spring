package com.dw.firstapp.repository.iface;

import com.dw.firstapp.model.Employee;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    List<Employee> getAllemployee();
    Employee getEmployeeById(String id);
    List<Map<String, Object>> getEmployeesWithDepartName();
    List<Employee> getEmployeesWithDepartmentAndPosition(
            String departmentNumber, String position
    );
    Employee saveEmployee(Employee employee);
    List<Employee> getEmployeeAfterHireDate(String joinDate);
    List<Employee> getEmployeeAfterHireDate1();
}
