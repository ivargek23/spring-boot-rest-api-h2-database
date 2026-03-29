package com.example.rjany.repository;

import com.example.rjany.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsById(Long id);
}
