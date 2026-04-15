package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Criteria: Method retrieves patient by email using derived or custom query
    Optional<Patient> findByEmail(String email);

    // Criteria: Method retrieves patient using either email or phone number
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}
