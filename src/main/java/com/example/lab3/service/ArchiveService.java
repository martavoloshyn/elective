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

    public Long post(Archive archive) {
        archiveRepository.post(archive);
        return archiveRepository.getArchiveIdByRegistrationId(archive.getRegistration().getRegistrationId());
    }

    public Archive putMarkAndDate(long archiveId, int mark, Timestamp date) {
        archiveRepository.putMarkAndDate(archiveId, mark, date);
        return archiveRepository.get(archiveId);
    }

    public void delete(long id) {
        archiveRepository.delete(id);
    }
}
