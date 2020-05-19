package com.example.lab3.service;

import com.example.lab3.entity.Course;
import com.example.lab3.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherService teacherService;

    public CourseService(final CourseRepository courseRepository, final TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.teacherService = teacherService;
    }

    public Course get(long id) {
        Course course = courseRepository.get(id);
        course.setTeacher(teacherService.get(courseRepository.getTeacherIdByCourseId(id)));
        return course;
    }

    public boolean putTeacher(long courseId, long teacherId) {
        return courseRepository.putTeacher(courseId, teacherId) == 1;
    }
}
