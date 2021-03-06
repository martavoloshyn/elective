package com.example.lab3.controller;

import com.example.lab3.entity.Course;
import com.example.lab3.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable long courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.get(courseId));
    }

    @PutMapping("/{courseId}/teacher/{teacherId}")
    public ResponseEntity<Course> changeTeacher(@PathVariable long courseId, @PathVariable long teacherId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.putTeacher(courseId, teacherId));
    }
}
