package com.example.demo.Controller;

import com.example.demo.DTO.PatientRegistrationDto;
import com.example.demo.Entities.Patient;
import com.example.demo.Service.PatientService;
import com.example.demo.Service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;
    private RegistrationService registrationService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


//    @PostMapping
//    public Patient create (@RequestBody Patient patient){
//        return patientService.savePatient(patient);
//    }

    @GetMapping
    public List<Patient  > getAllPatient(){
        return  patientService.getAllPatients();
    }

    @GetMapping("/{email}")
    public Patient findById (@PathVariable String email){
        return  patientService.findPatientByEmail(email).orElseThrow(()-> new RuntimeException("Patient Not Found"));
    }

    @PutMapping("/{email}")
    public Patient  update (@PathVariable String email, @RequestBody Patient patient){
        return patientService.updatePatient(email, patient);
    }

    @DeleteMapping("/{email}")
    public void  delete(@PathVariable String email){
        patientService.deletePatient(email);
    }

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody PatientRegistrationDto dto) {
        Patient patient = registrationService.registerPatient(dto);
        return ResponseEntity.ok(patient);
    }


}