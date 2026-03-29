package com.example.rjany.model;

import com.example.rjany.model.enums.CourseStatus;
import com.example.rjany.model.enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String description;
    private Integer credits;
    private String professor;
    @Enumerated(EnumType.STRING)
    private Semester semester;
    private Integer enrolledStudents;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;


}
