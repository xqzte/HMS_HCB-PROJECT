package com.example.demo.Service;

import com.example.demo.Entities.Doctor;
import com.example.demo.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }


    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);

    }


    public List <Doctor> getAllDoctors (){
       return doctorRepository.findAll();
    }


    public Optional <Doctor> findDoctorById(Long id){
        return doctorRepository.findById(id);
    }

    public Doctor updateDoctor (Long id, Doctor doctor){
        return doctorRepository.findById(id)
                .map(existing ->{
                    existing.setSpecialization(doctor.getSpecialization());
                    existing.setYearsOfExperience(doctor.getYearsOfExperience());

                    return doctorRepository.save(existing);
                }).orElseThrow(()-> new RuntimeException("Doctor Not Found"));
    }

    public void deleteDoctor(Long id){
        doctorRepository.delete(id);
    }

}
