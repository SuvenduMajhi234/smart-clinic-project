package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Criteria: Method returns available time slots for doctor on a given date
    public List<String> getAvailableSlots(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        return (doctor != null) ? doctor.getAvailableTimes() : List.of();
    }

    // Criteria: Method validates doctor login credentials and returns structured response
    public Map<String, Object> validateDoctorLogin(String email, String password) {
        // Simulated logic for validation
        if ("doctor@clinic.com".equals(email) && "password123".equals(password)) {
            return Map.of("status", "success", "message", "Login successful");
        }
        return Map.of("status", "error", "message", "Invalid credentials");
    }
}
