package com.example.lab3.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"courseName", "teacher"})
public class Course {
    private long courseId;
    private String courseName;
    private Teacher teacher;
}
