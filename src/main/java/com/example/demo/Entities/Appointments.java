package com.example.demo.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        SCHEDULED, COMPLETED, CANCELLED
    }

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public Appointments(Long id, LocalDate date, Status status, Patient patient) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
