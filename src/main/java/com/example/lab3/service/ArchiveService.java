package com.example.lab3.service;

import com.example.lab3.entity.Archive;
import com.example.lab3.repository.ArchiveRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ArchiveService {
    private final ArchiveRepository archiveRepository;
    private final RegistrationService registrationService;

    public ArchiveService(ArchiveRepository archiveRepository, RegistrationService registrationService) {
        this.archiveRepository = archiveRepository;
        this.registrationService = registrationService;
    }

    public Archive get(long id) {
        Archive archive = archiveRepository.get(id);
        archive.setRegistration(registrationService.get(archiveRepository.getRegistrationIdByArchiveId(id)));
        return archive;
    }

    public boolean post(Archive archive) {
        return archiveRepository.post(archive);
    }

    public boolean putMarkAndDate(long archiveId, int mark, Timestamp date) {
        return archiveRepository.putMarkAndDate(archiveId, mark, date);
    }

    public boolean delete(long id) {
        return archiveRepository.delete(id);
    }
}
