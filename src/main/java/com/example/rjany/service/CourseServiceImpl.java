package com.example.rjany.service;

import com.example.rjany.dtos.CourseResponseDto;
import com.example.rjany.dtos.CreateCourseDto;
import com.example.rjany.mapping.CourseMapper;
import com.example.rjany.model.Course;
import com.example.rjany.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper mapper = CourseMapper.INSTANCE;

    @Override
    public List<CourseResponseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public Optional<CourseResponseDto> getCourseById(Long id) {
        return courseRepository.findById(id).map(mapper::toResponseDto);
    }

    @Override
    public CourseResponseDto saveCourse(CreateCourseDto course) {
        Course courseEntity = mapper.toEntity(course);
        return mapper.toResponseDto(courseRepository.save(courseEntity));
    }

    @Override
    public Optional<Course> updateCourse(Long id, CreateCourseDto course) {
        return courseRepository.findById(id)
                .map(current -> {
                    fillCourseNewInfo(current, mapper.toEntity(course));
                    return courseRepository.save(current);
                });
    }

    private void fillCourseNewInfo(Course courseToUpdate, Course course) {
        courseToUpdate.setName(course.getName());
        courseToUpdate.setCode(course.getCode());
        courseToUpdate.setDescription(course.getDescription());
        courseToUpdate.setCredits(course.getCredits());
        courseToUpdate.setProfessor(course.getProfessor());
        courseToUpdate.setSemester(course.getSemester());
        courseToUpdate.setStatus(course.getStatus());
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new EntityNotFoundException("Course not found");
        }
        courseRepository.deleteById(id);
    }
}
