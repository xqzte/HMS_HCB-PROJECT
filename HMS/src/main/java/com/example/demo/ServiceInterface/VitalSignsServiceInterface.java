package com.example.demo.ServiceInterface;

import com.example.demo.Entities.VitalSigns;

import java.util.List;

public interface VitalSignsServiceInterface {
    VitalSigns recordVitalSigns(VitalSigns vitalSigns);

    List<VitalSigns> getVitalSignsByPatientId(Long patientId);

    List<VitalSigns> getVitalSignsByMedicalRecordId(Long medicalRecordId);

    List<VitalSigns> getVitalSignsByAppointmentId(Long appointmentId);

    VitalSigns getVitalSignsById(Long id);

}
