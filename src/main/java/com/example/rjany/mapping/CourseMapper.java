package com.example.rjany.mapping;

import com.example.rjany.dtos.CourseResponseDto;
import com.example.rjany.dtos.CreateCourseDto;
import com.example.rjany.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CreateCourseDto toDto(Course course);

    Course toEntity(CreateCourseDto course);

    CourseResponseDto toResponseDto(Course course);
    Course toEntity(CourseResponseDto course);
}
