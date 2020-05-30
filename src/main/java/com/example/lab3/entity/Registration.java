package com.example.lab3.entity;

import lombok.Data;

@Data
public class Registration {
    private long registrationId;
    private Student student;
    private Course course;
    private int year;
    private int semester;
}
