package com.dw.jpaapp.model;

import com.dw.jpaapp.dto.InstructorDTO;
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
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name" , nullable = false)
    private String name;

    @Column (name = "career" )
    private String career;

    @OneToMany(mappedBy = "instructor_fk")
    private List<Course> courseList = new ArrayList<>();

    public InstructorDTO toDTO() {
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setId(this.id);
        instructorDTO.setName(this.name);
        instructorDTO.setCareer(this.career);
        List<Long> courseIds = new ArrayList<>();
        for (Course data : this.courseList) {
            courseIds.add(data.getId());
        }
        instructorDTO.setCourseIds(courseIds);
        return instructorDTO;
    }
}
