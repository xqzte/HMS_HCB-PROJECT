package com.example.demo.Controller;


import com.example.demo.DTO.DoctorRegistrationDto;
import com.example.demo.DTO.PatientRegistrationDto;
import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Patient;
import com.example.demo.Service.DoctorService;
import com.example.demo.Service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private RegistrationService registrationService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }



    @PostMapping("/register")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody DoctorRegistrationDto dto) {
        Doctor doctor = registrationService.registerDoctor(dto);
        return ResponseEntity.ok(doctor);

    }

    @GetMapping
    public List<Doctor> getAllDoctors (){
        return  doctorService.getAllDoctors();
    }

    @GetMapping("/{email}")
    public Doctor  findByEmail(@PathVariable String email){
        return  doctorService.findDoctorByEmail(email).orElseThrow(()-> new RuntimeException("Doctor Not Found"));
    }

    @PutMapping("/{email}")
    public Doctor  update (@PathVariable  String email, @RequestBody Doctor doctor){
        return doctorService.updateDoctor(email, doctor);
    }

    @DeleteMapping("/{email}")
    public void  delete(@PathVariable String email){
        doctorService.deleteDoctor(email);
    }


    //NEW
//    @PostMapping("/register")
//    public ResponseEntity<Doctor> registerDoctor(@RequestBody DoctorRegistrationDto dto) {
//        Doctor doctor = registrationService.registerDoctor(dto);
//        return ResponseEntity.ok(doctor);
//    }
}
