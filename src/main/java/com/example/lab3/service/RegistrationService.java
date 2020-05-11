package com.example.lab3.service;

import com.example.lab3.entity.Registration;
import com.example.lab3.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public RegistrationService(RegistrationRepository registrationRepository, StudentService studentService, CourseService courseService) {
        this.registrationRepository = registrationRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Registration get(long id) {
        Registration registration = registrationRepository.get(id);
        registration.setCourse(courseService.get(registrationRepository.getCourseIdByRegistrationId(id)));
        registration.setStudent(studentService.get(registrationRepository.getStudentIdByRegistrationId(id)));
        return registration;
    }

    public boolean post(Registration registration) {
        return registrationRepository.post(registration);
    }

    public boolean delete(long id) {
        return registrationRepository.delete(id);
    }
}
