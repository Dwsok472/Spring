package com.dw.firstapp.repository.template;

import com.dw.firstapp.exception.ResourceNotFoundException;
import com.dw.firstapp.model.Employee;
import com.dw.firstapp.repository.iface.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeTemplateRepository implements EmployeeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeNumber(rs.getString("사원번호"));
            employee.setName(rs.getString("이름"));
            employee.setEnglishName(rs.getString("영문이름"));
            employee.setEmployeeClass(rs.getString("직위"));
            employee.setGender(rs.getString("성별"));
            employee.setBirthDate(LocalDate.parse(rs.getString("생일")));
            employee.setHireDate(LocalDate.parse(rs.getString("입사일")));
            employee.setAdress(rs.getString("주소"));
            employee.setCity(rs.getString("도시"));
            employee.setRegion(rs.getString("지역"));
            employee.setHomePhone(rs.getString("집전화"));
            employee.setSupervisorId(rs.getString("상사번호"));
            employee.setDepartmentId(rs.getString("부서번호"));
            return employee;
        }
    };

    @Override
    public List<Employee> getAllemployee() {
        String query = "select * from 사원";
        return jdbcTemplate.query(query, employeeRowMapper);
    }


    @Override
    public Employee getEmployeeById(String id) {
        String query = "select * from 사원 where 사원번호 = ?";
        try {
            return jdbcTemplate.queryForObject(query, employeeRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(
                    "사원번호가 올바르지 않습니다 : " + id
            );
        }
    }

    @Override
    public List<Map<String, Object>> getEmployeesWithDepartName() {
        String query = "select 이름, 입사일, 부서명 from 사원" +
                "inner join 부서 on 사원.부서번호 = 부서.부서번호";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Map<String, Object> employee = new HashMap<>();
            employee.put("이름", rs.getString("이름"));
            employee.put("입사일", rs.getString("입사일"));
            employee.put("부서명", rs.getString("부서명"));
            return employee;
        });
//        RowMapper<Map<String,Object>> mapper = new RowMapper<Map<String, Object>>() {
//            @Override
//            public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Map<String, Object> employee = new HashMap<>();
//                employee.put("이름", rs.getString("이름"));
//                employee.put("입사일", rs.getString("입사일"));
//                employee.put("부서명", rs.getString("부서명"));
//                return employee;
//            }
//        };
//        return jdbcTemplate.query(query, mapper);
    }

    @Override
    public List<Employee> getEmployeesWithDepartmentAndPosition(String departmentNumber, String position) {
        String query = "select * from 사원 where 부서번호 = ? and 직위 = ?";
        try {
            return jdbcTemplate.query(query, employeeRowMapper, departmentNumber, position);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(
                    "부서번호 혹은 직위가 올바르지 않습니다 :" + departmentNumber + position
            );
        }
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        String query = "insert into 사원(사원번호, 이름, 영문이름, 직위, 성별, 생일, 입사일, 주소, 도시, 지역, 집전화, 상사번호, 부서번호) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        jdbcTemplate.update(query,
                employee.getEmployeeNumber(),
                employee.getName(),
                employee.getEnglishName(),
                employee.getClass(),
                employee.getGender(),
                employee.getBirthDate(),
                employee.getHireDate(),
                employee.getAdress(),
                employee.getRegion(),
                employee.getHomePhone(),
                employee.getSupervisorId(),
                employee.getDepartmentId());
        return employee;
    }

    // 4-3 입사일을 매개변수로 해당 입사일 이후로 입사한 사원들을 조회하는 API
    // hiredate를 0으로 입력하면 가장 최근 입사한 사원의 정보를 조회하시오.
    @Override
    public List<Employee> getEmployeeAfterHireDate(String hireDate) {
        String query = "select * from 사원 where 입사일 > ? ";
        return jdbcTemplate.query(query , employeeRowMapper, hireDate);
    }
    public List<Employee> getEmployeeAfterHireDate1(){
        String query1 = "select * from 사원 order by 입사일 desc limit 1";
        return jdbcTemplate.query(query1, employeeRowMapper);
    }
}



