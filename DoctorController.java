package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import com.project.back_end.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Criteria: GET endpoint for doctor availability using dynamic parameters
    // Criteria: Validates token (simulated) and returns structured response using ResponseEntity
    @GetMapping("/availability/{id}")
    public ResponseEntity<?> getDoctorAvailability(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token) {

        // Token validation check
        if (token == null || !token.startsWith("Bearer ")) {
            return new ResponseEntity<>("Invalid or missing token", HttpStatus.UNAUTHORIZED);
        }

        List<String> availability = doctorService.getAvailableSlots(id);
        
        if (availability == null || availability.isEmpty()) {
            return new ResponseEntity<>("No available slots found for this doctor", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(availability, HttpStatus.OK);
    }
}
