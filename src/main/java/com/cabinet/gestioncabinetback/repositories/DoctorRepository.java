package com.cabinet.gestioncabinetback.repositories;

import com.cabinet.gestioncabinetback.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface DoctorRepository {
    Optional<Doctor> findByEmail(String email);
}
