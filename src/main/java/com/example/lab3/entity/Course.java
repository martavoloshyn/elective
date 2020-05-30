package com.example.lab3.entity;

import lombok.Data;

@Data
public class Course {
    private long courseId;
    private String courseName;
    private Teacher teacher;
}
