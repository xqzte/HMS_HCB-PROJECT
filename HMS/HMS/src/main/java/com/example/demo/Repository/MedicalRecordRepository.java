package com.example.demo.Repository;

import com.example.demo.Entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
        List<MedicalRecord> findByPatientId(Long patientId);
    }
