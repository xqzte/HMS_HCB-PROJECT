package com.example.demo.DTO;

import jakarta.persistence.GeneratedValue;

import java.time.LocalDate;

public class DoctorRegistrationDto {

    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private String medicalHistory;
    private String password;
    private String specialization;
    private int YearsOfExperience;


    public int getYearsOfExperience() {
        return YearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        YearsOfExperience = yearsOfExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public  String getGender() {
        return gender;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

//    public PasswordEncoder getPasswordEncoder() {
//        return passwordEncoder;
//    }
//
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

//    public DoctorRepository getDoctorRepository() {
//        return doctorRepository;
//    }
//
//    public void setDoctorRepository(DoctorRepository doctorRepository) {
//        this.doctorRepository = doctorRepository;
//    }
//
//    public AccountRepository getAccountRepository() {
//        return accountRepository;
//    }
//
//    public void setAccountRepository(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
}
