package com.dw.jpaapp.model;

import com.dw.jpaapp.dto.StudentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student") // 명시적으로 테이블 이름 설정
public class Student {
    @Id // PK로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 아이디숫자 자동증가
    @Column(name = "id") // @Id를 사용하면 안써도됨
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @ManyToMany(mappedBy = "studentlist")
    private List<Course> courseList = new ArrayList<>();


    public StudentDTO toDTO() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(this.id);
        studentDTO.setName(this.name);
        studentDTO.setEmail(this.email);
        List<Long> courseIds = new ArrayList<>();
        for (Course data : this.courseList) {
            courseIds.add(data.getId());
        }
        studentDTO.setCourseIds(courseIds);
        return studentDTO;
    }
}
