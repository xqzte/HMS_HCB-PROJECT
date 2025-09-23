package com.example.demo.ServiceInterface;

import com.example.demo.Entities.MedicalRecord;

import java.util.List;

public interface MedicalRecordServiceInterface {
    MedicalRecord createMedicalRecord(MedicalRecord record);
    MedicalRecord getMedicalRecordById(Long id);
    MedicalRecord updateMedicalRecord(Long id, MedicalRecord updatedRecord);
    boolean deleteMedicalRecord(Long id);
    List<MedicalRecord> getAllMedicalRecords();
    List<MedicalRecord> getRecordsByPatientId(Long patientId);
}