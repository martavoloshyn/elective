package com.example.lab3.repository;

import com.example.lab3.entity.Group;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository {

    private final JdbcTemplate jdbcTemplate;

    public GroupRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Group get(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM elective.groups WHERE group_id=?",
                new BeanPropertyRowMapper<>(Group.class), id);
    }
}
