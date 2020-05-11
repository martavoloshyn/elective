package com.example.lab3.controller;

import com.example.lab3.entity.Archive;
import com.example.lab3.service.ArchiveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/archive")
public class ArchiveController {
    @Autowired
    private ArchiveService archiveService;

    @GetMapping("/{archiveId}")
    public ResponseEntity<Archive> getArchive(@PathVariable long archiveId) {
        return ResponseEntity.status(HttpStatus.OK).body(archiveService.get(archiveId));
    }

    @PostMapping()
    public ResponseEntity<String> postArchive(@RequestBody Archive archive) {
        if (archiveService.post(archive)) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
    }

    @PutMapping("/{archiveId}")
    public ResponseEntity<String> putMarkAndDate(@PathVariable long archiveId,
                                                 @RequestParam("mark") int mark,
                                                 @RequestParam("date") String date) {
        if (archiveService.putMarkAndDate(archiveId, mark, Timestamp.valueOf(date))) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
    }

    @DeleteMapping("/{archiveId}")
    public ResponseEntity<String> deleteArchive(@PathVariable long archiveId) {
        if (archiveService.delete(archiveId)) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
    }
}
