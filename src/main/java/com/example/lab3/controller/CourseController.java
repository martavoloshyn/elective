package com.example.lab3.controller;

import com.example.lab3.entity.Course;
import com.example.lab3.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable long courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.get(courseId));
    }

    @PutMapping("/{courseId}/teacher/{teacherId}")
    public ResponseEntity<String> changeTeacher(@PathVariable long courseId, @PathVariable long teacherId) {
        if (courseService.putTeacher(courseId, teacherId)) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
    }
}
