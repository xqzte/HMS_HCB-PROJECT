//package com.example.demo.Controller;
//
//import com.example.demo.DTO.AuthenticationRequest;
//import com.example.demo.DTO.AuthenticationResponse;
//import com.example.demo.DTO.DoctorRegistrationDto;
//import com.example.demo.DTO.NurseRegistrationDto;
//import com.example.demo.Entities.Account;
//import com.example.demo.Entities.Doctor;
//import com.example.demo.Entities.Nurse;
//import com.example.demo.Entities.Patient;
//import com.example.demo.Security.JwtAutheticationService;
//import com.example.demo.Service.DoctorService;
//import com.example.demo.Service.NurseService;
//import com.example.demo.Service.PatientService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/auth")
//public class AuthenticationController {
//    private final AuthenticationManager authenticationManager;
//
//    private final JwtAutheticationService jwtAutheticationService;
//
//    private NurseService nurseService;
//    private final PatientService patientService;
//    private  DoctorService doctorService;
//
//    private final UserDetailsService userDetailsService;
//
//    public AuthenticationController(AuthenticationManager authenticationManager, JwtAutheticationService jwtAutheticationService, PatientService patientService, UserDetailsService userDetailsService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtAutheticationService = jwtAutheticationService;
//        this.patientService = patientService;
//        this.userDetailsService = userDetailsService;
//    }
//
//
//    @PostMapping("/patient")
//
//    public ResponseEntity<Patient> register(@RequestBody DoctorRegistrationDto doctorRegistrationDto){
//        return ResponseEntity.ok(patientService.savePatient(doctorRegistrationDto));
//    }
//
//
//    @PostMapping("/doctor")
//    public ResponseEntity<Doctor> registerDoctor(@RequestBody DoctorRegistrationDto doctorDto) {
//        Doctor registeredDoctor = doctorService.saveDoctor(doctorDto);
//        return ResponseEntity.ok(registeredDoctor);
//    }
//
//
//    @PostMapping("/nurse")
//    public ResponseEntity<Nurse> registerNurse(@RequestBody NurseRegistrationDto nurseDto) {
//        Nurse registeredNurse = nurseService.saveNurse(nurseDto);
//        return ResponseEntity.ok(registeredNurse);
//    }
//
//
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse>login (@RequestBody AuthenticationRequest request){
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getemail(), request.getPassword()));
//
//        Account account = (Account) userDetailsService.loadUserByUsername(request.getemail());
//        String token = jwtAutheticationService.generateToken(account);
//
//        return  ResponseEntity.ok(new AuthenticationResponse(token));
//    }
//
//}


package com.example.demo.Controller;

import com.example.demo.DTO.AuthenticationRequest;
import com.example.demo.DTO.AuthenticationResponse;
import com.example.demo.DTO.DoctorRegistrationDto;
import com.example.demo.DTO.NurseRegistrationDto;
import com.example.demo.DTO.PatientRegistrationDto;
import com.example.demo.Entities.Account;
import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Nurse;
import com.example.demo.Entities.Patient;
import com.example.demo.Security.JwtAutheticationService;
import com.example.demo.Service.DoctorService;
import com.example.demo.Service.NurseService;
import com.example.demo.Service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtAutheticationService jwtAutheticationService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final NurseService nurseService;
    private final UserDetailsService userDetailsService;

    public AuthenticationController(
            AuthenticationManager authenticationManager,
            JwtAutheticationService jwtAutheticationService,
            PatientService patientService,
            DoctorService doctorService,
            NurseService nurseService,
            UserDetailsService userDetailsService
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtAutheticationService = jwtAutheticationService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.nurseService = nurseService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> registerPatient(@RequestBody PatientRegistrationDto patientDto) {
        Patient registeredPatient = patientService.savePatient(patientDto);
        return ResponseEntity.ok(registeredPatient);
    }

    @PostMapping("/doctor")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody DoctorRegistrationDto doctorDto) {
        Doctor registeredDoctor = doctorService.saveDoctor(doctorDto);
        return ResponseEntity.ok(registeredDoctor);
    }

    @PostMapping("/nurse")
    public ResponseEntity<Nurse> registerNurse(@RequestBody NurseRegistrationDto nurseDto) {
        Nurse registeredNurse = nurseService.saveNurse(nurseDto);
        return ResponseEntity.ok(registeredNurse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getemail(), request.getPassword())
        );

        Account account = (Account) userDetailsService.loadUserByUsername(request.getemail());
        String token = jwtAutheticationService.generateToken(account);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}