package com.example.rjany.dtos;

import com.example.rjany.model.enums.CourseStatus;
import com.example.rjany.model.enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseDto {

    @NotBlank(message = "Name is required.")
    private String name;
    @NotBlank(message = "Code is required.")
    private String code;
    @NotBlank(message = "Description is required.")
    private String description;
    @NotNull(message = "You must enter credits for the course.")
    private Integer credits;
    @NotBlank(message = "Professor name is required.")
    private String professor;
    @NotNull(message = "Please specify semester.")
    @Enumerated(EnumType.STRING)
    private Semester semester;
    @NotNull(message = "Please enter a number of enrolled students.")
    private Integer enrolledStudents;
    @NotNull(message = "Course status is required.")
    private CourseStatus status;
}
