package com.example.demo.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class VitalSigns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;
    private int pulse;
    private int respiratoryRate;
    private int systolicPressure;
    private int diastolicPressure;
    private int oxygenSaturation;
    private double weight;
    private double height;

    private LocalDate date;            // date of recording
    private LocalDateTime recordedAt;  // precise timestamp

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointments appointment;

    public VitalSigns() {}

    public VitalSigns(Long id, double temperature, int pulse, int respiratoryRate, int systolicPressure,
                      int diastolicPressure, int oxygenSaturation, double weight, double height,
                      LocalDate date, LocalDateTime recordedAt, Patient patient, Nurse nurse,
                      MedicalRecord medicalRecord, Appointments appointment) {
        this.id = id;
        this.temperature = temperature;
        this.pulse = pulse;
        this.respiratoryRate = respiratoryRate;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.oxygenSaturation = oxygenSaturation;
        this.weight = weight;
        this.height = height;
        this.date = date;
        this.recordedAt = recordedAt;
        this.patient = patient;
        this.nurse = nurse;
        this.medicalRecord = medicalRecord;
        this.appointment = appointment;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getPulse() { return pulse; }
    public void setPulse(int pulse) { this.pulse = pulse; }

    public int getRespiratoryRate() { return respiratoryRate; }
    public void setRespiratoryRate(int respiratoryRate) { this.respiratoryRate = respiratoryRate; }

    public int getSystolicPressure() { return systolicPressure; }
    public void setSystolicPressure(int systolicPressure) { this.systolicPressure = systolicPressure; }

    public int getDiastolicPressure() { return diastolicPressure; }
    public void setDiastolicPressure(int diastolicPressure) { this.diastolicPressure = diastolicPressure; }

    public int getOxygenSaturation() { return oxygenSaturation; }
    public void setOxygenSaturation(int oxygenSaturation) { this.oxygenSaturation = oxygenSaturation; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Nurse getNurse() { return nurse; }
    public void setNurse(Nurse nurse) { this.nurse = nurse; }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord; }

    public Appointments getAppointment() { return appointment; }
    public void setAppointment(Appointments appointment) { this.appointment = appointment; }
}