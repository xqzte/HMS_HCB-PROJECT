package com.example.demo.Service;

import com.example.demo.DTO.PatientRegistrationDto;
import com.example.demo.Entities.Account;
import com.example.demo.Entities.Patient;
import com.example.demo.Entities.Role;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.DoctorRepository;
import com.example.demo.Repository.PatientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {
    private String name;
    private String email;
    private String dateOfBirth;
    private String gender;
    private String medicalHistory;
    private String password;
    private PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public PatientService(PasswordEncoder passwordEncoder, PatientRepository patientRepository, AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
        this.accountRepository = accountRepository;
    }

    public Patient savePatient(PatientRegistrationDto patientRegistrationDto){
        Account account = new Account();
        account.setEmail(patientRegistrationDto.getEmail());
        account.setPassword(passwordEncoder.encode(patientRegistrationDto.getPassword()));
        account.setRole(Role.DOCTOR);
        accountRepository.save(account);


        Patient patient = new Patient();
        patient.setName(patientRegistrationDto.getName());
        patient.setEmail(patientRegistrationDto.getEmail());
        patient.setDateOfBirth(patientRegistrationDto.getDateOfBirth());
        patient.setGender(patientRegistrationDto.getGender());
        patient.setPassword(passwordEncoder.encode(patientRegistrationDto.getPassword()));
        return patientRepository.save(patient);

    }


    public List<Patient> getAllPatients (){
        return patientRepository.findAll();
    }

    public Optional<Patient> findPatientByEmail(String email){
        return patientRepository.findByEmail(email);
    }

    public Patient updatePatient (String email, Patient patient){
        return patientRepository.findByEmail(email)
                .map(existing ->{
                    existing.setMedicalHistory(patient.getMedicalHistory());
                    return patientRepository.save(existing);
                }).orElseThrow(()-> new RuntimeException("Patient Not Found"));
    }

    public void deletePatient(String email){
        DoctorRepository.deleteByEmail(email);
    }


}
