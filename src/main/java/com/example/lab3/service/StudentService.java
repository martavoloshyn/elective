package com.example.lab3.service;

import com.example.lab3.entity.Student;
import com.example.lab3.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupService groupService;

    public StudentService(StudentRepository studentRepository, GroupService groupService) {
        this.studentRepository = studentRepository;
        this.groupService = groupService;
    }

    public Student get(long id) {
        Student student = studentRepository.get(id);
        student.setGroup(groupService.get(studentRepository.getGroupIdByStudentId(id)));
        return student;
    }
}
