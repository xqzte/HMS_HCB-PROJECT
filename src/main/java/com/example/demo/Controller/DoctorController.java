package com.example.demo.Controller;

import com.example.demo.Entities.Account;
import com.example.demo.Entities.Doctor;
import com.example.demo.Service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping
    public Doctor create (@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors (){
        return  doctorService.getAllDoctors();
    }

    public Doctor  findById (@PathVariable Long id){
        return  doctorService.findDoctorById(id).orElseThrow(()-> new RuntimeException("Doctor Not Found"));
    }

    public Doctor  update (@PathVariable Long id, @RequestBody Doctor doctor){
        return doctorService.updateDoctor(id, doctor);
    }

    public void  delete(@PathVariable Long id){
         doctorService.deleteDoctor(id);
    }



}
