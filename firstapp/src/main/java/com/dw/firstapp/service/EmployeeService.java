package com.dw.firstapp.service;

import com.dw.firstapp.dto.EmployeeDepartmentDTO;
import com.dw.firstapp.exception.InvalidRequestException;
import com.dw.firstapp.exception.ResourceNotFoundException;
import com.dw.firstapp.model.Customer;
import com.dw.firstapp.model.Employee;
import com.dw.firstapp.repository.iface.EmployeeRepository;
import com.dw.firstapp.repository.jdbc.EmployeeJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    @Qualifier("employeeTemplateRepository")
    EmployeeRepository employeeRepository;

    public List<Employee> getAllemployee() {
        return employeeRepository.getAllemployee();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Map<String, Object>> getEmployeesWithDepartName() {
        return employeeRepository.getEmployeesWithDepartName();
    }

    @GetMapping("/employees/{departmentNumber}/{Position}")
    public List<Employee> getEmployeesWithDepartNumberPosition(@PathVariable String departmentNumber, @PathVariable String position) {
        return employeeRepository.getEmployeesWithDepartmentAndPosition(departmentNumber, position);
    }

    public List<EmployeeDepartmentDTO> getEmployeesWithDepartName2() {
        List<EmployeeDepartmentDTO> employeeDepartmentDTOList =
                new ArrayList<>();

        List<Map<String, Object>> mapList =
                employeeRepository.getEmployeesWithDepartName();

        for (Map<String, Object> data : mapList) {
            EmployeeDepartmentDTO temp = new EmployeeDepartmentDTO(
                    LocalDate.parse((String) data.get("입사일")),
                    (String) data.get("부서명"),
                    (String) data.get("이름")
            );
            employeeDepartmentDTOList.add(temp);
        }

        return employeeDepartmentDTOList;

    }

    public List<Employee> getEmployeesWithDepartmentAndPosition(
            String departmentNumber, String position) {
        List<Employee> employees = employeeRepository.getEmployeesWithDepartmentAndPosition(departmentNumber, position);
        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("조건에 일치하는 사원이 없습니다:" + departmentNumber + "," + position);
        } else {
            return employees;
        }

    }


    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    // 4-3 입사일을 매개변수로 해당 입사일 이후로 입사한 사원들을 조회하는 API
    // hiredate를 0으로 입력하면 가장 최근 입사한 사원의 정보를 조회하시오.

    public List<Employee> getEmployeeAfterHireDate(String joinDate) {
        if (joinDate.equals("0")){
            return employeeRepository.getEmployeeAfterHireDate1();
        }else {
            try {
                LocalDate joinDate2 = LocalDate.parse(joinDate);

                return employeeRepository.getEmployeeAfterHireDate(joinDate2.toString());
            } catch (DateTimeException e) {
                throw new InvalidRequestException("입력하신 입사일이 올바르지 않습니다. :" + joinDate);
            }
        }
    }
}

