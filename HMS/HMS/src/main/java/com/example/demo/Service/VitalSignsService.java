package com.example.demo.Service;

import com.example.demo.Entities.VitalSigns;
import com.example.demo.Repository.VitalSignsRepository;
import com.example.demo.ServiceInterface.VitalSignsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalSignsService implements VitalSignsServiceInterface {

        @Autowired
        private VitalSignsRepository vitalSignsRepository;

    public VitalSignsService(VitalSignsRepository vitalSignsRepository) {
        this.vitalSignsRepository = vitalSignsRepository;
    }

    @Override
        public VitalSigns recordVitalSigns(VitalSigns vitalSigns) {
            return vitalSignsRepository.save(vitalSigns);
        }

        @Override
        public List<VitalSigns> getVitalSignsByPatientId(Long patientId) {
            return vitalSignsRepository.findByPatientId(patientId);
        }

        @Override
        public List<VitalSigns> getVitalSignsByMedicalRecordId(Long medicalRecordId) {
            return vitalSignsRepository.findByMedicalRecordId(medicalRecordId);
        }

        @Override
        public List<VitalSigns> getVitalSignsByAppointmentId(Long appointmentId) {
            return vitalSignsRepository.findByAppointmentId(appointmentId);
        }

        @Override
        public VitalSigns getVitalSignsById(Long id) {
            return vitalSignsRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("VitalSigns not found"));
        }
    }