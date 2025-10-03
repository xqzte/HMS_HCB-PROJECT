package com.example.demo.Service;

import com.example.demo.DTO.DoctorRegistrationDto;
import com.example.demo.Entities.Account;
import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Role;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.DoctorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;


    public DoctorService(DoctorRepository doctorRepository, PasswordEncoder passwordEncoder, AccountRepository accountRepository){
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }

    public Doctor saveDoctor(DoctorRegistrationDto doctorRegistrationDto){

        Account account = new Account();
        account.setEmail(doctorRegistrationDto.getEmail());
        account.setPassword(passwordEncoder.encode(doctorRegistrationDto.getPassword()));
        account.setRole(Role.DOCTOR);
        accountRepository.save(account);


        Doctor doctor = new Doctor();
        doctor.setName(doctorRegistrationDto.getName());
        doctor.setEmail(doctorRegistrationDto.getEmail());
        doctor.setGender(doctorRegistrationDto.getGender());
        doctor.setPassword(passwordEncoder.encode(doctorRegistrationDto.getPassword()));

        return doctorRepository.save(doctor);

    }

    public List<Doctor> getAllDoctors (){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findDoctorByEmail(String email){
        return doctorRepository.findByEmail(email);
    }

    public Doctor updateDoctor (String email, Doctor doctor){
        return doctorRepository.findByEmail(email)
                .map(existing ->{
                    existing.setSpecialization(doctor.getSpecialization());
                    existing.setYearsOfExperience(doctor.getYearsOfExperience());

                    return doctorRepository.save(existing);
                }).orElseThrow(()-> new RuntimeException("Doctor Not Found"));
    }

    public void deleteDoctor(String email){
        DoctorRepository.deleteByEmail(email);
    }
}
