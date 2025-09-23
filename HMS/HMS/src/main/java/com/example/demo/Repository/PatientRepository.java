//package com.example.demo.Repository;
//
//import com.example.demo.Entities.Appointments;
//import com.example.demo.Entities.Patient;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface PatientRepository extends JpaRepository<Patient, Long> {
//    Optional<Patient> findByEmail(String email);
//    static void deleteByEmail(String email) {}
//    List<Appointments> findByPatient(Patient patient);
//
//}


package com.example.demo.Repository;

import com.example.demo.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
    void deleteByEmail(String email);
}