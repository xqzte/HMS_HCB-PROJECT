package com.example.demo.Repository;

import com.example.demo.Entities.VitalSigns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalSignsRepository extends JpaRepository<VitalSigns, Long> {

    List<VitalSigns> findByPatientId(Long patientId);

    List<VitalSigns> findByMedicalRecordId(Long medicalRecordId);

    List<VitalSigns> findByAppointmentId(Long appointmentId);

}
