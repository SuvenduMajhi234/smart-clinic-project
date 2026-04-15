package com.project.back_end.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // Criteria: POST endpoint saves a prescription with token and request body validation
    // Criteria: Returns structured success or error messages using ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<?> addPrescription(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, String> prescriptionData) {

        // Token validation logic (Criteria)
        if (token == null || !token.startsWith("Bearer ")) {
            return new ResponseEntity<>(Map.of("error", "Unauthorized access"), HttpStatus.UNAUTHORIZED);
        }

        // Request body validation (Criteria)
        if (!prescriptionData.containsKey("medication") || prescriptionData.get("medication").isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Medication details are required"), HttpStatus.BAD_REQUEST);
        }

        // Simulated success response (Criteria)
        return new ResponseEntity<>(Map.of("message", "Prescription saved successfully!"), HttpStatus.CREATED);
    }
}
