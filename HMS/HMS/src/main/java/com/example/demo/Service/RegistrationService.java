package com.example.demo.Service;

import com.example.demo.DTO.DoctorRegistrationDto;
import com.example.demo.DTO.NurseRegistrationDto;
import com.example.demo.DTO.PatientRegistrationDto;
import com.example.demo.Entities.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final AccountRepository accountRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(AccountRepository accountRepository,
                               DoctorRepository doctorRepository,
                               NurseRepository nurseRepository,
                               PatientRepository patientRepository,
                               PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }


    //Register Doctor.
    public Doctor registerDoctor(DoctorRegistrationDto dto) {
        Account account = new Account();
        account.setEmail(dto.getEmail());
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setRole(Role.DOCTOR);
        accountRepository.save(account);

        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setYearsOfExperience(dto.getYearsOfExperience());
        doctor.setAccount(account);

        return doctorRepository.save(doctor);
    }



    //Register Nurse
    public Nurse registerNurse(NurseRegistrationDto dto) {
        Account account = new Account();
        account.setEmail(dto.getEmail());
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setRole(Role.NURSE);
        accountRepository.save(account);

        Nurse nurse = new Nurse();
        nurse.setName(dto.getName());
        nurse.setDepartment(dto.getDepartment());
        nurse.setYearsOfExperience(dto.getYearsOfExperience());
        nurse.setAccount(account);

        return nurseRepository.save(nurse);
    }



    //Register Patient.
    public Patient registerPatient(PatientRegistrationDto dto) {
        Account account = new Account();
        account.setEmail(dto.getEmail());
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setRole(Role.PATIENT);
        accountRepository.save(account);

        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAccount(account);

        return patientRepository.save(patient);
    }
}
