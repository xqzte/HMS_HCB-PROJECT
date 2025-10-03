package com.example.demo.Service;

import com.example.demo.DTO.DoctorRegistrationDto;
import com.example.demo.DTO.NurseRegistrationDto;
import com.example.demo.Entities.*;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.DoctorRepository;
import com.example.demo.Repository.NurseRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {
    private final NurseRepository nurseRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public NurseService(NurseRepository nurseRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.nurseRepository = nurseRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Nurse saveNurse(Nurse nurse){
        return nurseRepository.save(nurse);

    }
    public Nurse saveNurse(NurseRegistrationDto nurseRegistrationDto){
        Account account = new Account();
        account.setEmail(nurseRegistrationDto.getEmail());
        account.setPassword(passwordEncoder.encode(nurseRegistrationDto.getPassword()));
        account.setRole(Role.DOCTOR);
        accountRepository.save(account);


        Nurse nurse = new Nurse();
        nurse.setName(nurseRegistrationDto.getName());
        nurse.setEmail(nurseRegistrationDto.getEmail());
        nurse.setGender(nurseRegistrationDto.getGender());
        nurse.setPassword(passwordEncoder.encode(nurseRegistrationDto.getPassword()));


        return nurseRepository.save(nurse);

    }

    public List<Nurse > getAllNurses (){
        return nurseRepository.findAll();
    }


    public Optional<Nurse> findNurseByEmail(String email){
        return nurseRepository.findByEmail(email);
    }

    public Nurse updateNurse (String email, Nurse nurse){
        return nurseRepository.findByEmail(email)
                .map(existing ->{
                    existing.setDepartment(nurse.getDepartment());
                    return nurseRepository.save(existing);
                }).orElseThrow(()-> new RuntimeException("Doctor Not Found"));
    }

    public void deleteNurse(String email){
        DoctorRepository.deleteByEmail(email);
    }
}
