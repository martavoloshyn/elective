package com.example.lab3.repository;

import com.example.lab3.entity.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CourseRepository {

    private final JdbcTemplate jdbcTemplate;

    public CourseRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Course get(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM courses WHERE course_id=?",
                new BeanPropertyRowMapper<>(Course.class), id);
    }

    public Long getTeacherIdByCourseId(long courseId) {
        return jdbcTemplate.queryForObject("SELECT teacher_id FROM courses WHERE course_id=?",
                new Object[]{courseId}, Long.class);
    }

    public boolean post(Course course) {
        return jdbcTemplate.update("INSERT INTO courses(course_id,course_name,teacher_id) VALUES (?,?,?)",
                course.getCourseId(), course.getCourseName(), course.getTeacher().getTeacherId()) == 1;
    }

    public boolean putTeacher(long courseId, long teacherId) {
        return jdbcTemplate.update("UPDATE courses SET teacher_id=? WHERE course_id=?", teacherId, courseId) == 1;
    }
}
