package com.example.lab3.repository;

import com.example.lab3.entity.Archive;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class ArchiveRepository {
    private final JdbcTemplate jdbcTemplate;

    public ArchiveRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Archive get(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM archive WHERE archive_id=?",
                new BeanPropertyRowMapper<>(Archive.class), id);
    }

    public Long getRegistrationIdByArchiveId(long archiveId) {
        return jdbcTemplate.queryForObject("SELECT registration_id FROM archive WHERE archive_id=?",
                new Object[]{archiveId}, Long.class);
    }

    public boolean post(Archive archive) {
        return jdbcTemplate.update("INSERT INTO archive (registration_id,mark,date) VALUES (?,?,?)",
                archive.getRegistration().getRegistrationId(), archive.getMark(), archive.getDate()) == 1;
    }

    public boolean putMarkAndDate(long archiveId, int mark, Timestamp date) {
        return jdbcTemplate.update("UPDATE archive SET mark=?, date=? WHERE archive_id=?", mark, date, archiveId) == 1;
    }

    public boolean delete(long id) {
        return jdbcTemplate.update("DELETE FROM archive WHERE archive_id=?", id) == 1;
    }
}
