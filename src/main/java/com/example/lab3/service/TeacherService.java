package com.example.lab3.service;

import com.example.lab3.entity.Teacher;
import com.example.lab3.repository.AcademicStatusRepository;
import com.example.lab3.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AcademicStatusRepository academicStatusRepository;

    public TeacherService(TeacherRepository teacherRepository, AcademicStatusRepository academicStatusRepository) {
        this.teacherRepository = teacherRepository;
        this.academicStatusRepository = academicStatusRepository;
    }

    public Teacher get(long id) {
        Teacher teacher = teacherRepository.get(id);
        teacher.setAcademicStatus(academicStatusRepository.get(teacherRepository.getAcademicStatusIdByTeacherId(id)));
        return teacher;
    }
}
