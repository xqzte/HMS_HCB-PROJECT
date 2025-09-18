package com.example.demo.Repository;

import com.example.demo.Entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
