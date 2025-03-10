package com.dw.companyapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="부서")
public class Department {
    @Id
    @Column(name="부서번호")
    private String departmentId;
    @Column(name="부서명")
    private String departmentName;
}
