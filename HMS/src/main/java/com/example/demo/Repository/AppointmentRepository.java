package com.example.demo.Repository;

import com.example.demo.Entities.AppointmentStatus;
import com.example.demo.Entities.Appointments;
import com.example.demo.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long> {
    List<Appointments> findByDoctorId(Long doctorId);

    List<Appointments> findByStatus(AppointmentStatus status);

    List<Appointments> findByPatientId(Long patientId);

    List<Appointments> findByDoctorIdAndStatus(Long doctorId, AppointmentStatus status);
    List<Appointments> findByPatient(Patient patient);
}
