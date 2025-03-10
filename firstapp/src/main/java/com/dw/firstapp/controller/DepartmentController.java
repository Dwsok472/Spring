package com.dw.firstapp.controller;

import com.dw.firstapp.model.Department;
import com.dw.firstapp.service.DepartmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping ("/find-all-department")
        public ResponseEntity<List<Department>> getAlldepartment() {
        return new ResponseEntity<>(
                departmentService.getAlldepartment(),
                HttpStatus.OK
        );
    }

    // single data ( 저장할 데이터 객체 1개 처리용 )
    @PostMapping("/post/department")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(
                departmentService.saveDpartment(department),
                HttpStatus.CREATED
        );
    }

    // multiple data ( 저장할 데이터가 리스트임 )
    @PostMapping("/post/departmentlist")
    public ResponseEntity<List<Department>> saveDepartmentList(@RequestBody List<Department> departmentList) {
        return new ResponseEntity<> (
                departmentService.saveDepartmentList(departmentList),
        HttpStatus.CREATED);
    }

    @PutMapping("/put/department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartment(department),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/department/id/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String id){
        return new ResponseEntity<>(
                "부서번호 : " + departmentService.deleteDepartment(id) + " 가 삭제되었습니다.",
        HttpStatus.OK);
    }
}
