package com.example.demo.Repository;


import com.example.demo.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    Optional<Doctor> findByEmail(String email);
    static void deleteByEmail(String email) {}
}
