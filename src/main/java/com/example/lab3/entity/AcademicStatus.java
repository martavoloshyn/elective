package com.example.lab3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicStatus {
    private long academicStatusId;
    private String academicStatus;
}
