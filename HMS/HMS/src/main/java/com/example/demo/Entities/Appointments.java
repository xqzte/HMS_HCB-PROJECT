package com.example.demo.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Appointments {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Long doctorId;
    private LocalDate date;
    private AppointmentStatus status;
    private String reason;

    @OneToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    public Appointments() {}

    public Appointments(Long id, Patient patient, Long doctorId, LocalDate date, String reason) {
        this.id = id;
        this.patient = patient;
        this.doctorId = doctorId;
        this.date = date;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }}