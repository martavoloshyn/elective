package com.example.lab3.controller;

import com.example.lab3.entity.Registration;
import com.example.lab3.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/{registrationId}")
    public ResponseEntity<Registration> getRegistration(@PathVariable long registrationId) {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.get(registrationId));
    }

    @PostMapping()
    public ResponseEntity<String> postRegistration(@RequestBody Registration registration) {
        if (registrationService.post(registration)) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
    }

    @DeleteMapping("/{registrationId}")
    public ResponseEntity<String> deleteRegistration(@PathVariable long registrationId) {
        if (registrationService.delete(registrationId)) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
    }
}
