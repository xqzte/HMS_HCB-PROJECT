package com.example.demo.Controller;

import com.example.demo.Entities.VitalSigns;
import com.example.demo.Service.VitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vital-signs")
public class VitalSignsController {

    @Autowired
    private VitalSignsService vitalSignsService;

    // 🩺 Record new vital signs (typically by nurse)
    @PostMapping
    public ResponseEntity<VitalSigns> recordVitalSigns(@RequestBody VitalSigns vitalSigns) {
        VitalSigns saved = vitalSignsService.recordVitalSigns(vitalSigns);
        return ResponseEntity.ok(saved);
    }

    // 🔍 Get vitals by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<VitalSigns>> getByPatientId(@PathVariable Long patientId) {
        List<VitalSigns> vitals = vitalSignsService.getVitalSignsByPatientId(patientId);
        return ResponseEntity.ok(vitals);
    }

    // 🔍 Get vitals by medical record ID
    @GetMapping("/medical-record/{recordId}")
    public ResponseEntity<List<VitalSigns>> getByMedicalRecordId(@PathVariable Long recordId) {
        List<VitalSigns> vitals = vitalSignsService.getVitalSignsByMedicalRecordId(recordId);
        return ResponseEntity.ok(vitals);
    }

    // 🔍 Get vitals by appointment ID
    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<List<VitalSigns>> getByAppointmentId(@PathVariable Long appointmentId) {
        List<VitalSigns> vitals = vitalSignsService.getVitalSignsByAppointmentId(appointmentId);
        return ResponseEntity.ok(vitals);
    }

    // 🔍 Get a specific vital signs entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<VitalSigns> getById(@PathVariable Long id) {
        VitalSigns vitalSigns = vitalSignsService.getVitalSignsById(id);
        return ResponseEntity.ok(vitalSigns);
    }
}
