package com.example.demo.Controller;

import com.example.demo.Entities.Nurse;
import com.example.demo.Entities.Patient;
import com.example.demo.Service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping
    public Patient  create (@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @GetMapping
    public List<Patient  > getAllPatient(){
        return  patientService.getAllPatient();
    }

    public Patient findById (@PathVariable Long id){
        return  patientService.findPatientById(id).orElseThrow(()-> new RuntimeException("Patient Not Found"));
    }

    public Patient  update (@PathVariable Long id, @RequestBody Patient patient){
        return patientService.updatePatient(id, patient);
    }

    public void  delete(@PathVariable Long id){
        patientService.deletePatient(id);
    }


}
