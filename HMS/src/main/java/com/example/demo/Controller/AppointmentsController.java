package com.example.demo.Controller;

import com.example.demo.Entities.Appointments;
import com.example.demo.Entities.AppointmentStatus;
import com.example.demo.Service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;

    // Create a new appointment
    @PostMapping
    public ResponseEntity<Appointments> createAppointment(@RequestBody Appointments appointment) {
        Appointments saved = appointmentsService.createAppointment(appointment);
        return ResponseEntity.ok(saved);
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointments> getAppointmentById(@PathVariable Long id) {
        Appointments appointment = appointmentsService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }

    // ️ Get appointments by doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointments>> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        List<Appointments> appointments = appointmentsService.getAppointmentsByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }

    // 👤 Get appointments by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointments>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        List<Appointments> appointments = appointmentsService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(appointments);
    }

    // Get appointments by status (SCHEDULED, COMPLETED, CANCELLED)
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointments>> getAppointmentsByStatus(@PathVariable AppointmentStatus status) {
        List<Appointments> appointments = appointmentsService.getAppointmentsByStatus(status);
        return ResponseEntity.ok(appointments);
    }

    //  Update appointment status
    @PutMapping("/{id}/status")
    public ResponseEntity<Appointments> updateAppointmentStatus(@PathVariable Long id, @RequestParam AppointmentStatus status) {
        Appointments updated = appointmentsService.updateAppointmentStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    //  Delete an appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentsService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}