package com.example.lab3.service;

import com.example.lab3.entity.AcademicStatus;
import com.example.lab3.repository.AcademicStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class AcademicStatusService {
    private final AcademicStatusRepository academicStatusRepository;

    public AcademicStatusService(AcademicStatusRepository academicStatusRepository) {
        this.academicStatusRepository = academicStatusRepository;
    }

    public AcademicStatus get(long id) {
        return academicStatusRepository.get(id);
    }
}
