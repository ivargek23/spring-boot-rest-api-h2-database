package com.example.rjany.service;

import com.example.rjany.dtos.CourseResponseDto;
import com.example.rjany.dtos.CreateCourseDto;
import com.example.rjany.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseResponseDto> getAllCourses();
    Optional<CourseResponseDto> getCourseById(Long id);
    CourseResponseDto saveCourse(CreateCourseDto course);
    Optional<Course> updateCourse(Long id, CreateCourseDto course);
    void deleteCourse(Long id);
}
