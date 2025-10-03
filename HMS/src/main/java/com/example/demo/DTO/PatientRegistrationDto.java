package com.example.demo.DTO;


import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.PatientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PatientRegistrationDto {


    private PatientRepository patientRepository;
    private PasswordEncoder passwordEncoder;
    private AccountRepository accountRepository;

    private Long id;
    private String name;
    private String email;
    private String gender;
    private String password;
    private String dateOfBirth;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
