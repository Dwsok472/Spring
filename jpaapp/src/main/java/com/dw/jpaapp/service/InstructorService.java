package com.dw.jpaapp.service;

import com.dw.jpaapp.dto.InstructorDTO;
import com.dw.jpaapp.dto.InstructorGithubDTO;
import com.dw.jpaapp.model.Course;
import com.dw.jpaapp.model.Instructor;
import com.dw.jpaapp.model.InstructorProfile;
import com.dw.jpaapp.model.Student;
import com.dw.jpaapp.repository.CourseRepository;
import com.dw.jpaapp.repository.InstructorProfileRepository;
import com.dw.jpaapp.repository.InstructorRepository;
import com.dw.jpaapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    InstructorProfileRepository instructorProfileRepository;

    public List<InstructorDTO> getAllInstructors() {
        List<InstructorDTO> instructorDTOS = new ArrayList<>();
        for (Instructor data : instructorRepository.findAll()) {
            instructorDTOS.add(data.toDTO());
        }
        return instructorDTOS;
    }

    public String getInstructor(Long id) {
        return instructorRepository.findById(id)
                .map(Instructor::toDTO)
                .map(InstructorDTO::toString)
                .orElseThrow(() -> new RuntimeException("없는 데이터"));
    }

    public InstructorDTO saveInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setCareer(instructorDTO.getCareer());
        instructor.setCourseList(instructorDTO.getCourseIds().stream()
                .map(id -> courseRepository.findById(id))
                .map(optional -> optional.orElseThrow(() -> new RuntimeException("No course")))
                .peek(course -> course.setInstructor_fk(instructor))
                .toList()
        );
        return instructorRepository.save(instructor).toDTO();
    }

    public List<Object[]> getInstructorGithub() {
        List<Object[]> objects = new ArrayList<>();
        for (InstructorProfile data : instructorProfileRepository.findAll()) {
            Object[] temp = new Object[3];
            temp[0] = data.getInstructor().getId();
            temp[1] = data.getInstructor().getName();
            temp[2] = data.getGithubUrl();
            objects.add(temp);
        }
        return objects;
    }

    public List<InstructorGithubDTO> getInstructorGithub2() {
        return instructorProfileRepository.getInstructorGithub();
    }
}
