package com.example.lab3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private long registrationId;
    private Student student;
    private Course course;
    private int year;
    private int semester;
}
