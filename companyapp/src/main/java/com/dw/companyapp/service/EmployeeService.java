package com.dw.companyapp.service;

import com.dw.companyapp.dto.EmployeeDepartmentDTO;
import com.dw.companyapp.exception.InvalidRequestException;
import com.dw.companyapp.exception.ResourceNotFoundException;
import com.dw.companyapp.model.Department;
import com.dw.companyapp.model.Employee;
import com.dw.companyapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 과제 3-1 사원정보를 조회할때 사원번호가 올바르지 않은 경우의 예외 처리
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("찾을수 없음"));
    }

    public List<Map<String,Object>> getEmployeesWithDepartName() {
//        List<Map<String ,Object>> employees = employeeRepository.findAllEmployees();
//
//        if (employees == null || employees.isEmpty()){
//            throw new ResourceNotFoundException("사원 정보가 없습니다.");
//        }
//        return employees.stream()
//                .map(employee -> {
//                    Map<String,Object> employees2 = new HashMap<>();
//                    employees2.put(employee.)
//                })
        return null;
    }

    public List<EmployeeDepartmentDTO> getEmployeesWithDepartName2() {
        return null;
    }

    // 과제 1-3 부서번호와 직위를 기준으로 해당 부서에 근무하는 특정 직위의 사원 정보를 조회하는 API
    // 과제 3-3 부서번호와 직위로 사원정보를 조회할때 데이터가 없는 경우의 예외처리
    public List<Employee> getEmployeesWithDepartmentAndPosition(
            String departmentNumber, String position
    ) {
        List<Employee> employees = employeeRepository.findEmployeesDepartmentAndPosition(departmentNumber, position);

        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("해당정보를 찾을수 없습니다.");
        }
        return employees;
    }

    // 과제 2-3 사원테이블에 사원 1명을 새로 추가하는 API
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // 과제 4-3 입사일을 매개변수로 해당 입사일 이후로 입사한 사원들을 조회하는 API
    // hiredate를 0으로 입력하면 가장 최근 입사한 사원의 정보를 조회하시오.
    public List<Employee> getEmployeesByHiredate(String hiredate) {
        if("0".equals(hiredate)) {
            return employeeRepository.getEmployeeByHiredate1();
        }else {
            return employeeRepository.getEmployeeByHiredate2(hiredate);
        }
    }
}
