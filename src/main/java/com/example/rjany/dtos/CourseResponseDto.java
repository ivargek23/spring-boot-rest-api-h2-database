package com.example.rjany.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String name;
    private String code;
    private String description;
    private Integer credits;
    private String professor;
    private String semester;
    private Integer enrolledStudents;
    private String status;
}
