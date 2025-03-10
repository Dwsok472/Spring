package com.dw.firstapp.controller;

import com.dw.firstapp.dto.EmployeeDepartmentDTO;
import com.dw.firstapp.model.Department;
import com.dw.firstapp.model.Employee;
import com.dw.firstapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping ("/find-all-employee")
    public ResponseEntity<List<Employee>> getAllemployee(){
        return new ResponseEntity<>(
                employeeService.getAllemployee(),
                HttpStatus.OK
        );
    }

    // Query Parameters ( 쿼리 문자열 )
    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam String id){
        return new ResponseEntity<>(
                employeeService.getEmployeeById(id),
                HttpStatus.OK
        );
    }
    // Path Parameters ( 경로 매개변수 )
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById_2(@PathVariable String id) {
        return new ResponseEntity<>(
                employeeService.getEmployeeById(id),
                HttpStatus.OK
        );
    }
    @GetMapping("/employees/department")
    public ResponseEntity<List<Map<String, Object>>> getEmployeesWithDepartName() {
        return new ResponseEntity<>(
                employeeService.getEmployeesWithDepartName(),
                HttpStatus.OK
        );
    }

    @GetMapping("/employees/department2")
    public ResponseEntity<List<EmployeeDepartmentDTO>> getEmployeesWithDepartName2(){
        return new ResponseEntity<>(
                employeeService.getEmployeesWithDepartName2(),
                HttpStatus.ACCEPTED
        );
    }
    @GetMapping("/employees/{departmentNumber}/{position}")
    public ResponseEntity<List<Employee>> getEmployeesWithDepartmentAndPosition(@PathVariable String departmentNumber,
                                                                                @PathVariable String position
    ) {
        return new ResponseEntity<>(employeeService.getEmployeesWithDepartmentAndPosition(
                departmentNumber, position),
                HttpStatus.ACCEPTED);
    }
    @PostMapping("/post/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(
                employeeService.saveEmployee(employee),
                HttpStatus.ACCEPTED
        );
    }
    // 4-3 입사일을 매개변수로 해당 입사일 이후로 입사한 사원들을 조회하는 API
    // hiredate를 0으로 입력하면 가장 최근 입사한 사원의 정보를 조회하시오.
    @GetMapping("/employees/hireDate/{hireDate}")
    public ResponseEntity<List<Employee>> getEmployeeAfterHireDate(@PathVariable String hireDate) {
        return new ResponseEntity<>(
                employeeService.getEmployeeAfterHireDate(hireDate),
                HttpStatus.OK
        );
    }

}
