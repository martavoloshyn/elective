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

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/{registrationId}")
    public ResponseEntity<Registration> getRegistration(@PathVariable long registrationId) {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.get(registrationId));
    }

    @PostMapping
    public ResponseEntity<Long> postRegistration(@RequestBody Registration registration) {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.post(registration));
    }

    @DeleteMapping("/{registrationId}")
    public ResponseEntity<String> deleteRegistration(@PathVariable long registrationId) {
        registrationService.delete(registrationId);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
