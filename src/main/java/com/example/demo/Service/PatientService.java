package com.example.demo.Service;

import com.example.demo.Controller.PatientController;
import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Patient;
import com.example.demo.Repository.PatientRepository;

import java.util.List;
import java.util.Optional;

public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient savePatient(Patient patient){
    return patientRepository.save(patient);

    }

    public List<Patient > getAllPatient (){
        return patientRepository.findAll();
    }


    public Optional<Patient > findPatientById(Long id){
        return patientRepository.findById(id);
    }

    public Patient  updatePatient  (Long id, Patient patient){
        return patientRepository.findById(id)
                .map(existing ->{
                    existing.setName(patient.getName());
                    existing.setDateOfBirth(patient.getDateOfBirth());
                    existing.setGender(patient.getGender());
                    existing.setMedicalHistory(patient.getMedicalHistory());

                    return patientRepository.save(existing);
                }).orElseThrow(()-> new RuntimeException(" Patient Not Found"));
    }

    public void deletePatient(Long id){
         patientRepository.delete(id);
    }

}

