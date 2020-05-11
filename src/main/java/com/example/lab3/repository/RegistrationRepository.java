package com.example.lab3.repository;

import com.example.lab3.entity.Registration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository {

    private final JdbcTemplate jdbcTemplate;

    public RegistrationRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Registration get(long id) {
        return jdbcTemplate.queryForObject("SELECT * from registrations WHERE registration_id=?",
                new BeanPropertyRowMapper<>(Registration.class), id);
    }

    public Long getCourseIdByRegistrationId(long registrationId) {
        return jdbcTemplate.queryForObject("SELECT course_id FROM registrations WHERE registration_id=?",
                new Object[]{registrationId}, Long.class);
    }

    public Long getStudentIdByRegistrationId(long registrationId) {
        return jdbcTemplate.queryForObject("SELECT student_id FROM registrations WHERE registration_id=?",
                new Object[]{registrationId}, Long.class);
    }

    public boolean post(Registration registration) {
        return jdbcTemplate.update("INSERT INTO registrations (student_id,course_id,year,semester) VALUES (?,?,?,?)",
                registration.getStudent().getStudentId(), registration.getCourse().getCourseId(),
                registration.getYear(), registration.getSemester()) == 1;
    }

    public boolean delete(long id) {
        return jdbcTemplate.update("DELETE FROM registrations WHERE registration_id=?", id) == 1;
    }
}