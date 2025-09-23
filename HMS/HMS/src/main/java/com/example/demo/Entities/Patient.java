package com.example.demo.Entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String dateOfBirth;
    private String gender;
    private String medicalHistory;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "patient")
    private List<Appointments> appointments;

    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "patient")
    private List<VitalSigns> vitalSigns;

    public Patient() {}

    public Patient(Long id, String name, String email, String password, String dateOfBirth, String gender, String medicalHistory,
                   Account account, List<Appointments> appointments, List<MedicalRecord> medicalRecords, List<VitalSigns> vitalSigns) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.account = account;
        this.appointments = appointments;
        this.medicalRecords = medicalRecords;
        this.vitalSigns = vitalSigns;
    }

    // Getters and setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public List<Appointments> getAppointments() { return appointments; }
    public void setAppointments(List<Appointments> appointments) { this.appointments = appointments; }

    public List<MedicalRecord> getMedicalRecords() { return medicalRecords; }
    public void setMedicalRecords(List<MedicalRecord> medicalRecords) { this.medicalRecords = medicalRecords; }

    public List<VitalSigns> getVitalSigns() { return vitalSigns; }
    public void setVitalSigns(List<VitalSigns> vitalSigns) { this.vitalSigns = vitalSigns; }

    // UserDetails methods

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public String getUsername() {
//        return email; // Use email for login
//    }
//
//    @Override
//    public boolean isAccountNonExpired() { return true; }
//
//    @Override
//    public boolean isAccountNonLocked() { return true; }
//
//    @Override
//    public boolean isCredentialsNonExpired() { return true; }
//
//    @Override
//    public boolean isEnabled() { return true; }
}