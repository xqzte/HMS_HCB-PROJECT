package com.example.demo.Service;

import com.example.demo.Entities.MedicalRecord;
import com.example.demo.Repository.MedicalRecordRepository;
import com.example.demo.ServiceInterface.MedicalRecordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordService implements MedicalRecordServiceInterface {

        @Autowired
        private MedicalRecordRepository medicalRecordRepository;

        @Override
        public MedicalRecord createMedicalRecord(MedicalRecord record) {
            return medicalRecordRepository.save(record);
        }

        @Override
        public MedicalRecord getMedicalRecordById(Long id) {
            return medicalRecordRepository.findById(id).orElseThrow(()-> new RuntimeException("Record not found!"));
        }

        @Override
        public MedicalRecord updateMedicalRecord(Long id, MedicalRecord updatedRecord) {
            MedicalRecord existing = getMedicalRecordById(id);
            existing.setDiagnosis(updatedRecord.getDiagnosis());
            existing.setTreatment(updatedRecord.getTreatment());
            existing.setDate(updatedRecord.getDate());
            return medicalRecordRepository.save(existing);
        }

        @Override
        public boolean deleteMedicalRecord(Long id) {
            medicalRecordRepository.deleteById(id);
            return true;
        }

        @Override
        public List<MedicalRecord> getAllMedicalRecords() {
            return medicalRecordRepository.findAll();
        }

        @Override

        public List<MedicalRecord> getRecordsByPatientId(Long patientId) {
            List<MedicalRecord> records = medicalRecordRepository.findByPatientId(patientId);
            return records != null ? records : new ArrayList<>();
        }
    }
